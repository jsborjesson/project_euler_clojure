(ns project-euler.solutions.problem-23
  (:require [project-euler.lib.misc :refer [sum-factors bitmap sum-bitmap]]))

(def limit 28123)

(defn abundant?
  "Whether the sum of divisors of n is larger than n"
  [n]
  (> (sum-factors n) n))

(defn abundant-numbers
  "A seq of all abundant numbers up to limit"
  [limit]
  (filter abundant? (range limit)))

(defn solution
  [limit]
  (sum-bitmap
    (loop [bitmap (bitmap limit)
           abundants (abundant-numbers limit)]
      (if-let [abundants (seq abundants)]
        (let [base (first abundants)]
          (recur
            (reduce
              (fn [bitmap abundant]
                (let [sum (+ base abundant)]
                  (if (< sum limit)
                    (assoc bitmap sum false)
                    bitmap)))
              bitmap
              abundants)
            (rest abundants)))
        bitmap))))

; (time (solution limit))
