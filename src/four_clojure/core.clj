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





