(ns project-euler.solutions.problem-15)

; http://www.robertdickau.com/manhattan.html
; https://en.wikipedia.org/wiki/Binomial_coefficient
; https://en.wikipedia.org/wiki/Pascal%27s_triangle
;
; The number of paths is the Binominal coefficient.
; This means that the answer is in the middle of row 2x-1 in Pascal's triangle

(defn pascals-triangle
  ([] (pascals-triangle '(1 1)))
  ([coll]
   (cons
     coll
     (lazy-seq (pascals-triangle
                 (concat '(1) (map (partial apply +) (partition 2 1 coll)) '(1)))))))

(defn solution
  [n]
  (let [row (nth (pascals-triangle) (dec (* 2 n)))] ; Get row 2n-1
    (nth row (quot (count row) 2)))) ; Get middle element

; (time (solution 20))
