(ns project-euler.solutions.problem-2)

(def limit 4000000)

(defn fib
  ([] (fib 1 1))
  ([a b] (cons a (lazy-seq (fib b (+ b a))))))

(defn solution []
  (reduce + (filter even? (take-while #(< % limit) (fib)))))

(time (solution))
