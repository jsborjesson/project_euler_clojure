(ns project-euler.solutions.problem-6)

(def limit 100)
(def square #(* % %))
(def sum-of-squares (reduce + (map square (range 1 (inc limit)))))
(def square-of-sum  (square (reduce + (range 1 (inc limit)))))

(time (- square-of-sum sum-of-squares) )
