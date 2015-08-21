(ns project-euler.solutions.problem-16
  (:require [clojure.math.numeric-tower :as math]
            [project-euler.lib.misc :refer [sum-of-digits]]))

(defn solution []
  (sum-of-digits (math/expt 2 1000)))

; (time (solution))
