(ns project-euler.solutions.problem-19
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]))

; 20th century
(def start (t/date-time 1901 1 1))
(def end (t/date-time 2000 12 31))

(defn next-month
  [date-time]
  (t/plus date-time (t/months 1)))

(defn each-month
  "A lazy-seq iterating from start by one month"
  [start]
  (iterate next-month start))

(def firsts-of-20th-century
  "A sequence of all the first of months in the 20th century"
  (take-while #(t/before? % end) (each-month start)))

(defn solution
  []
  (count (filter pr/sunday? firsts-of-20th-century)))

; (time (solution))
