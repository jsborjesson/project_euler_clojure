(ns project-euler.solutions.problem-3
  (:require [project-euler.lib.misc :refer [divisible-by?]]
            [project-euler.lib.primes :refer [primes]]))

(def number 600851475143)

(defn biggest-prime-factor
  [n]
  (let [limit (int (Math/sqrt n))] ; The factor cannot be larger than the square root of number
    (reduce
      (fn [highest candidate]
        (if (divisible-by? n candidate) candidate highest))
      0
      (primes limit))))

(defn solution []
  (biggest-prime-factor number))

; (time (solution))
