(ns project-euler.solutions.problem-1)

(def limit 1000)

(def multiple-of (comp zero? mod))
(defn condition
  "Either a multiple of 3 or 5"
  [n]
  (or
    (multiple-of n 3)
    (multiple-of n 5)))

(defn solution []
  (reduce + (filter condition (range limit))))

; (time (solution))
