(ns four-clojure.core
  (:gen-class))

(defn -main
  []
  "don't matter"
)

;; Intro to Strings
;; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))

;; Intro to Lists
;; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))

;; Lists: conj
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))
(= (list 1 2 3 4) (conj '(2 3 4) 1))
(= (list 1 2 3 4) (conj '(3 4) 2 1))

;; Intro to Vectors
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; Vectors: conj
;; (= __ (conj [1 2 3] 4))
(= (vec '(1 2 3 4)) (conj [1 2 3] 4))

;; Intro to Sets
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

;; Sets: conj
;; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; Intro to Maps
;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;; (= __ (:b {:a 10, :b 20, :c 30}))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

;; Maps: conj
;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;; Intro to Sequences
;; (= __ (first '(3 2 1)))
;; (= __ (second [2 3 4]))
;; (= __ (last (list 1 2 3)))
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

;; Sequences: Rest
;; (= __ (rest [10 20 30 40]))
(= [20 30 40] (rest [10 20 30 40]))

;; Intro to Functions
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;; (= __ ((fn [x] (+ x 5)) 3))
;; (= __ (#(+ % 5) 3))
;; (= __ ((partial + 5) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

;; Double Down
;; Write a function that doubles a number.
(defn double-down [n] (* n 2))
(double-down 8)

;; Hello World
;; Write a function which returns a personalized greeting.
(defn greeting [name] (str "Hello, " name))
(greeting "Grizzly") ;; => "Hello, Grizzly"
(#(str "Hellow, " %) "Ash") ;; => "Hellow, Ash"

;; Sequences: Map
;; (= __ (map #(+ % 5) '(1 2 3)))
(= (list 6 7 8) (map #(+ % 5) '(1 2 3)))

;; Sequences: Filter
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; Intro to Reduce
;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
;; (=  6 (reduce __ 1 [2 3]))
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))

;; A nil key
;; Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
;; (true?  (__ :a {:a nil :b 2}))
;; (false? (__ :b {:a nil :b 2}))
;; (false? (__ :c {:a nil :b 2}))
(defn nil-check [k m]
  (if (and
       (contains? m k)
       (= (k m) nil))
    true
    false))

(true?  (nil-check :a {:a nil :b 2})) ;; => true
(false? (nil-check :b {:a nil :b 2})) ;; => true
(false? (nil-check :c {:a nil :b 2})) ;; => true

;; Logical falsity and truth
;; In Clojure, only nil and false represent the values of logical falsity in conditional tests - anything else is logical truth.
;; (= __ (if-not false 1 0))
;; (= __ (if-not nil 1 0))
;; (= __ (if true 1 0))
;; (= __ (if [] 1 0))
;; (= __ (if [0] 1 0))
;; (= __ (if 0 1 0))
;; (= __ (if 1 1 0))

(= 1 (if-not false 1 0))
(= 1 (if-not nil 1 0))
(= 1 (if true 1 0))
(= 1 (if [] 1 0))
(= 1 (if [0] 1 0))
(= 1 (if 0 1 0))
(= 1 (if 1 1 0))

;; Subset and Superset
;; Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained" inside B. A and B may coincide.
;; (clojure.set/superset? #{1 2} #{2})
;; (clojure.set/subset? #{1} __)
;; (clojure.set/superset? __ #{1 2})
;; (clojure.set/subset? #{1 2} __)

(clojure.set/superset? #{1 2} #{2})
(clojure.set/subset? #{1} #{1 2})
(clojure.set/superset? #{1 2} #{1 2})
(clojure.set/subset? #{1 2} #{1 2})

;; Intro to Destructuring
;; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
(= [2 4] (let [[a b c d e] [0 1 2 3 4]] (vector c e)))

