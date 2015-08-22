(ns project-euler.solutions.problem-22
  (:require [clojure.string :as s]))

(defn parse-names
  [names]
  (s/split (s/replace names #"\"" "") #","))

(def names (sort (parse-names (slurp "resources/p022_names.txt"))))

(defn letter-position
  "A capital letters position in the alphabet"
  [character]
  (- (int character) 64))

(defn alphabetical-value
  "The sum of all letter-positions in a name"
  [s]
  (reduce + (map letter-position s)))

(defn solution []
  (reduce +
    (map-indexed
      (fn [idx n] (* (inc idx) (alphabetical-value n)))
      names)))

; (time (solution))
