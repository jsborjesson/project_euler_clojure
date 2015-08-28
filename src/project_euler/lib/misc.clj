(ns project-euler.lib.misc)

(def divisible-by? (comp zero? mod))

(defn sum-of-digits
  [n]
  (reduce + (map (comp read-string str) (str n))))

;; This works by checking all divisors up to sqrt(n), then simply
;; adding their corresponding factor (n / factor) above sqrt(n).
;; It goes one past the square root so it is surely included, and then
;; returns a sorted set so there are no duplicates
(defn factors
  "All numbers that divide n evenly"
  [n]
  (let [low-factors (filter #(divisible-by? n %) (range 1 (inc (Math/sqrt n))))
        high-factors (map #(/ n %) low-factors)]
    (apply sorted-set (concat low-factors high-factors))))

(defn sum-factors
  "The sum of all factors of n, counting 1, not counting n"
  [n]
  (reduce + (butlast (factors n))))

(defn bitmap
  "Generates a vector of booleans"
  ([length] (bitmap length true))
  ([length default] (vec (take length (repeat default)))))

(defn sum-bitmap
  "Given a vector of booleans, return the sum of all true indices"
  [bitmap]
  (->>
    (map-indexed vector bitmap)
    (filter second)
    (map first)
    (apply +)))
