(ns project-euler.solutions.problem-4
  (:require [clojure.math.combinatorics :refer [cartesian-product]]))

(defn palindrome?
  "Whether n can be read the same backwards"
  [n]
  (= (str n) (apply str (reverse (str n)))))

(defn solution []
  (reduce
    (fn [biggest [x y]]
      (let [product (* x y)]
        (if (and (palindrome? product)
                 (> product biggest))
          product
          biggest)))
    0
    (cartesian-product (range 100 1000) (range 100 1000))))

(time (solution))
