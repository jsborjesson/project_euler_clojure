(ns project-euler.lib.primes)

;; Copied from the Problem 3 solution

(defn bitmap
  "Generates a vector of booleans all defaulting to true"
  [length]
  (vec (take length (repeat true))))


(defn cross-out-multiples
  "Returns a new bitmap where all multiples of n have been flipped to false"
  [bitmap n limit] ; limit could be (count bitmap) but no need for the extra cycles
  (reduce
    (fn [bitmap index] (assoc bitmap index false))
    bitmap
    (range (* n 2) limit n)))


(defn prime-bitmap
  "Generates a bitmap where prime numbers are the indices of true values up to limit"
  [limit]
  (let [primes (into [false false] (drop 2 (bitmap limit)))] ; 0 and 1 are not primes
    (reduce
      (fn [bitmap candidate] (cross-out-multiples bitmap candidate limit))
      primes
      (range 2 limit)))) ; Start at 2


(defn primes
  "Generates a list of primes up to limit"
  [limit]
  (let [indexed-bitmap (partition 2 (interleave (range limit) (prime-bitmap limit)))]
    (map first (filter second indexed-bitmap))))

