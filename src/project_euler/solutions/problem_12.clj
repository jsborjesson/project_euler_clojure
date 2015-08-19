(ns project-euler.solutions.problem-12)

(defn tri
  "Constructs a lazy-seq of triangle numbers"
  ([] (tri 1 1))
  ; n is the natural number (1 2 3 ...)
  ; t is the triangle number (1 3 6 ...)
  ([n t] (cons t (lazy-seq (tri (inc n) (+ t (inc n)))))))

(def divisible-by? (comp zero? mod))

; Every factor below the square root of n has exactly one corresponding factor above it,
; therefore the number of factors = number of factors below sqrt(n)*2
(defn num-factors
  "The total number of divisors of n"
  [n]
  (* 2 (count (filter (partial divisible-by? n) (range 1 (inc (Math/sqrt n)))))))

(defn solution
  [limit]
  (first (filter #(> (num-factors %) limit) (tri))))

; (time (solution 500))
