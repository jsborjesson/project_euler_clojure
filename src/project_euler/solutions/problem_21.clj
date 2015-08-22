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

; Making the memo function a simple pre-computed vector lookup almost doubled
; the performance over memoize, which already significantly improved it.
; (def sum-factors-memo (memoize sum-factors))
(def sums (mapv sum-factors (range limit)))
(defn sum-factors-memo [n] (sums n))

(defn amicable?
  "Whether a and b are an amicable pair"
  [a b]
  (and
    (not= a b)
    (= (sum-factors-memo a) b)
    (= (sum-factors-memo b) a)))

(defn solution
  "Count sum of amicable pairs up to limit"
  [limit]
  (reduce
    +
    (flatten
      (filter
        (partial apply amicable?)
        (for [a (range limit)
              b (range limit)
              :when (< a b)]
          [a b])))))

; (time (solution limit))
