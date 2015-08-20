(ns project-euler.solutions.problem-16
  (:require [clojure.math.numeric-tower :as math]))

(defn solution []
  (reduce + (map (comp read-string str) (str (math/expt 2 1000)))))

; (time (solution))
