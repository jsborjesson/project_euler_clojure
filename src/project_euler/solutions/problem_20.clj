(ns project-euler.solutions.problem-20
  (:require [project-euler.lib.misc :refer [sum-of-digits]]))

(defn factorial
  [n]
  (if (= n 1)
    n
    (* n (factorial (dec n)))))

(defn solution []
  (sum-of-digits (factorial (bigint 100))))

; (time (solution))
