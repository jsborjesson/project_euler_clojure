(ns project-euler.solutions.problem-18)

(def triangle
  '((75)
    (95 64)
    (17 47 82)
    (18 35 87 10)
    (20  4 82 47 65)
    (19  1 23 75  3 34)
    (88  2 77 73  7 63 67)
    (99 65  4 28  6 16 70 92)
    (41 41 26 56 83 40 80 70 33)
    (41 48 72 33 47 32 37 16 94 29)
    (53 71 44 65 25 43 91 52 97 51 14)
    (70 11 33 28 77 73 17 78 39 68 17 57)
    (91 71 52 38 17 14 91 43 58 50 27 29 48)
    (63 66  4 68 89 53 67 30 73 16 69 87 40 31)
    ( 4 62 98 27 23  9 70 98 73 93 38 53 60  4 23))
  )

(defn middle
  "A sequence without its first and last members"
  [coll]
  (rest (butlast coll)))

(defn sum-rows
  "Takes a two rows from a triangle, and produces a new list where the greatest
  of the reachable paths from above has been added to the bottom row.

  Example: (sum-rows '(2 4 6) '(8 5 9 3)) ;; => (10 9 15 9)"
  [top bottom]
  (let [start (+ (first top) (first bottom)) ; The first element is always the sum of the two first elements
        body  (map #(+ (apply max %1) %2)    ; The highest value of the 2 values above the value in the bottom row is added to it
                   (partition 2 1 top)
                   (middle bottom))
        end   (+ (last top) (last bottom))]  ; The last element is always the sum of the two last elements
    (flatten [start body end])))


(defn find-greatest-path
  [triangle]
  (loop [last-row-sums (first triangle)
         remaining-triangle (rest triangle)]
    (if-let [current-row (seq (first remaining-triangle))]
      (recur (sum-rows last-row-sums current-row)
             (rest remaining-triangle))
      (apply max last-row-sums)))) ; Hit bottom, return the greatest path

(defn solution []
  (find-greatest-path triangle))

; (time (solution))
