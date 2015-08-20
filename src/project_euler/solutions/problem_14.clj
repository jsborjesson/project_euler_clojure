(ns project-euler.solutions.problem-14)

(defn collatz
  "Returns the collatz sequence starting at start"
  [n]
  (if (= 1 n)
    '(1)
    (conj (if
            (even? n)
            (collatz (/ n 2))
            (collatz (inc (* 3 n))))
          n)))

(defn collatz-length
  [n]
  (count (collatz n)))

(defn solution
  [limit]
  (second (reduce
    (fn [[longest-length _ :as highest] candidate]
      (let [length (collatz-length candidate)]
        (if (> length longest-length)
          [length candidate]
          highest)))
    [1 1] ; Length of longest sequence, number producing that sequence
    (range 1 limit))))

; (time (solution 1000000))
