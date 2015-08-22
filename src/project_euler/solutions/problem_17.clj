(ns project-euler.solutions.problem-17
  (:require [project-euler.lib.misc :refer [divisible-by?]]))

(def words
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"
   100 "hundred"
   1000 "thousand"})

(defn text->int
  "Turns strings or chars into integers"
  [n]
  (Integer. (str n)))

(defn digits
  "A seq of integers representing every individual digit"
  [n]
  (map text->int (str n)))

(defn seq->int
  "Turns a sequence of numbers into one integer"
  [coll]
  (text->int (clojure.string/join coll)))

(defn count-letters
  "The number of letters in a string, ignoring all other characters"
  [s]
  (count (re-seq #"[a-z]" s)))

(defn english
  "Returns the number n written in English"
  [n]
  (if (or (> n 1000) (< n 0)) (throw (IllegalArgumentException. "out of bounds")))
    (let [digits (digits n)
          num-digits (count digits)]
      (cond
        ; 0-99
        (<= num-digits 2)
        (if-let [word (words n)]
          word                                    ; If it's in the hashmap, we can just return it as is
          (let [ten (words (* 10 (first digits))) ; Otherwise we construct it like "forty-two"
                one (words (last digits))]
            (str ten "-" one)))

        ; 100-999
        (= num-digits 3)
        (str
          (words (first digits))
          " "
          (words 100)
          (if (divisible-by? n 100)
            ""
            (str " and " (english (seq->int (rest digits))))))

        ; 1000
        (>= num-digits 4)
        (str "one " (words 1000))))) ; It only needs to go to 1000, otherwise it throws

(defn solution [limit]
  (reduce + (map count-letters (map english (range 1 (inc limit))))))

; (time (solution 1000))
