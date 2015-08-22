(ns project-euler.lib.misc)

(def divisible-by? (comp zero? mod))

(defn sum-of-digits
  [n]
  (reduce + (map (comp read-string str) (str n))))
