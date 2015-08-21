(ns project-euler.lib.misc)

(defn sum-of-digits
  [n]
  (reduce + (map (comp read-string str) (str n))))
