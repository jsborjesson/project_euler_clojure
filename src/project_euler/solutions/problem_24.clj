(ns project-euler.solutions.problem-24
  (:require [clojure.math.combinatorics :refer [nth-permutation]]))

(defn solution
  []
  (clojure.string/join (nth-permutation (range 10) 999999)))

(time (solution))
