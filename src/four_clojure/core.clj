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
(= __ ((hash-map :a 10, :b 20, :c 30) :b))










