(ns project-euler.lib.misc)

(def divisible-by? (comp zero? mod))

(defn sum-of-digits
  [n]
  (reduce + (map (comp read-string str) (str n))))

;; This works by checking all divisors up to sqrt(n), then simply
;; adding their corresponding factor (n / factor) above sqrt(n)
(defn factors
  "All numbers that divide n evenly"
  [n]
  (let [factors-upto-sqrt (filter #(divisible-by? n %) (range 1 (Math/sqrt n)))
        factors-above-sqrt (reverse (map #(/ n %) factors-upto-sqrt))]
    (concat factors-upto-sqrt factors-above-sqrt)))

(defn sum-factors
  "The sum of all factors of n, counting 1, not counting n"
  [n]
  (reduce + (butlast (factors n))))

(defn bitmap
  "Generates a vector of booleans"
  ([length] (bitmap length true))
  ([length default] (vec (take length (repeat default)))))
