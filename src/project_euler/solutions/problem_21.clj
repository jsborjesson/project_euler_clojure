(ns project-euler.solutions.problem-21
  (:require [project-euler.lib.misc :refer [divisible-by?]]))

(def limit 10000)

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

(defn amicable?
  "Whether a and b are an amicable pair"
  [a b]
  (and
    (not= a b)
    (= (sum-factors a) b)
    (= (sum-factors b) a)))

(defn solution
  [limit]
  (reduce
    (fn [sum candidate] ; Add the candidate and its amicable pair, and if it is the lower one in the pair (to prevent counting twice)
      (let [factor-sum (sum-factors candidate)]
        (if (and (< factor-sum candidate) (amicable? candidate factor-sum))
          (+ sum candidate factor-sum)
          sum)))
    0
    (range limit)))

; (time (solution limit))
