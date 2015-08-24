(ns project-euler.solutions.problem-21
  (:require [project-euler.lib.misc :refer [divisible-by? sum-factors]]))

(def limit 10000)

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
