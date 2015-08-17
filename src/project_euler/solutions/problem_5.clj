(ns project-euler.solutions.problem-5)

(def divisible-by? (comp zero? mod))

(defn divisible-by-all?
  "Whether n is evenly divisible by every member of denoms"
  [n denoms]
  (every? (partial divisible-by? n) denoms))

(defn smallest-divident-by-all
  "Finds the smallest number divisible by every number up to highest-denom"
  [highest-denom]
  (let [step highest-denom
        denoms (range 1 (inc highest-denom))]
    (loop [n step]
      (if (divisible-by-all? n denoms)
        n
        (recur (+ n step))))))

(time (smallest-divident-by-all 20))
