(ns project-euler.solutions.problem-67
  (:require [clojure.string :as s]
            [project-euler.solutions.problem-18 :refer [find-greatest-path]]))

(def raw-triangle (slurp "resources/p067_triangle.txt"))

(defn ->int [n] (Integer. n))

(defn parse-triangle
  [raw]
  (map
    #(map ->int (s/split % #" "))
    (s/split-lines raw)))

(def triangle (parse-triangle raw-triangle))

; The solution for 18 works here too
(defn solution []
  (find-greatest-path triangle))

; (time (solution))
