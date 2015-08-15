(ns project-euler.solutions.problem-2)

(def limit 4000000)

(def fib (lazy-cat '(0 1) (map + fib (rest fib))))

(defn solution []
  (reduce + (filter even? (take-while #(< % limit) fib))))

(time (solution))
