(ns project-euler.solutions.problem-9)

(def limit 1000)

(def square #(* % %))

(defn pythagorean-triplets
  "List of pythagorean triplets where a + b + c = n"
  [n]
  (filter
    (fn [[a b c]]
      (= (+ (square a) (square b)) (square c)))
    ; All combinations of 3 numbers where a < b < c and a + b + c = limit
    (for [a (range n)
          b (range n)
          c (range n)
          :when (and
                  (< a b c)
                  (= n (+ a b c)))]
      [a b c])))

; (time (reduce * (first (pythagorean-triplets limit))))
