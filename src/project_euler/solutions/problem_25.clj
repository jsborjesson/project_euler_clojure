(ns project-euler.solutions.problem-25)

; Copied from problem 2, but with bigints to prevent overflow
(defn fib
  ([] (fib 1N 1N))
  ([a b] (cons a (lazy-seq (fib b (+ b a))))))

(defn count-digits
  [n]
  (count (str n)))

(defn solution [num-digits]
  (inc (count (take-while #(< (count-digits %) num-digits) (fib)))))

; (time (solution 1000))
