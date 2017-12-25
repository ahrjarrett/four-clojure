(ns four-clojure.core
  (:gen-class))

(defn -main
  []
  "don't matter")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; *** INDEPENDENT STUDY: QuickSort in Clojure *** ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; INCOMPLETE as of 11/12/17
(defn rand-numbers [n]
  (take n (repeatedly #(rand-int 100))))

(rand-numbers 100) ;; => (93 2 32 94 ...)


;;;;;;;;;;;;;;;;;;;;;;;;
;; *** ELEMENTARY *** ;;
;;;;;;;;;;;;;;;;;;;;;;;;

;; #3: Intro to Strings
;; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))


;; #4: Intro to Lists
;; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))


;; #5: Lists: conj
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))
(= (list 1 2 3 4) (conj '(2 3 4) 1))
(= (list 1 2 3 4) (conj '(3 4) 2 1))


;; #6: Intro to Vectors
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))


;; #7: Vectors: conj
;; (= __ (conj [1 2 3] 4))
(= (vec '(1 2 3 4)) (conj [1 2 3] 4))
(= (into [] '(1 2 3 4)) (conj [1 2 3] 4))


;; #8: Intro to Sets
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))


;; #9: Sets: conj
;; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))


;; #10: Intro to Maps
;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;; (= __ (:b {:a 10, :b 20, :c 30}))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))


;; #11: Maps: conj
;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))


;; #12: Intro to Sequences
;; (= __ (first '(3 2 1)))
;; (= __ (second [2 3 4]))
;; (= __ (last (list 1 2 3)))
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))


;; #13: Sequences: Rest
;; (= __ (rest [10 20 30 40]))
(= [20 30 40] (rest [10 20 30 40]))


;; #14: Intro to Functions
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;; (= __ ((fn [x] (+ x 5)) 3))
;; (= __ (#(+ % 5) 3))
;; (= __ ((partial + 5) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))


;; #15: Double Down
;; Write a function that doubles a number.
(defn double-down [n] (* n 2))
(double-down 8)


;; #16: Hello World
;; Write a function which returns a personalized greeting.
(defn greeting [name] (str "Hello, " name))
(greeting "Grizzly") ;; => "Hello, Grizzly"
(#(str "Hellow, " %) "Ash") ;; => "Hellow, Ash"


;; #17: Sequences: Map
;; (= __ (map #(+ % 5) '(1 2 3)))
(= (list 6 7 8) (map #(+ % 5) '(1 2 3)))


;; #18: Sequences: Filter
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))


;; 19 last element
(#(last %) [1 2 3 4])
(#(count %) [1 2 3 9])
(#(nth % (- (count %) 1)) [1 2 3 9])

;; #64: Intro to Reduce
;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
;; (=  6 (reduce __ 1 [2 3]))
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))


;; #134: A nil key
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

;; #162: Logical falsity and truth
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


;; #161: Subset and Superset
;; Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained" inside B. A and B may coincide.
;; (clojure.set/superset? #{1 2} #{2})
;; (clojure.set/subset? #{1} __)
;; (clojure.set/superset? __ #{1 2})
;; (clojure.set/subset? #{1 2} __)
(clojure.set/superset? #{1 2} #{2}) ;; => true
(clojure.set/subset? #{1} #{1 2}) ;; => true
(clojure.set/superset? #{1 2} #{1 2}) ;; => true
(clojure.set/subset? #{1 2} #{1 2}) ;; => true


;; #52: Intro to Destructuring
;; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
(= [2 4] (let [[a b c d e] [0 1 2 3 4]] (vector c e))) ;; => true


;; #156: Map Defaults
;; Write a function which takes a default value and a sequence of keys and constructs a map.
;; (= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0})
;; (= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
;; (= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})
(defn cons-map
  [default-val keys]
  (zipmap keys (repeat default-val)))
(= (cons-map 0 [:a :b :c]) {:a 0 :b 0 :c 0})
(= (cons-map "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
(= (cons-map [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})


;;;;;;;;;;;;;;;;;;
;; *** EASY *** ;;
;;;;;;;;;;;;;;;;;;

;; #19: Last Element
;; Write a function which returns the last element in a sequence.
(defn last-one [s]
  (if (empty? (rest s)) (first s)
      (last-one (rest s))))
;; Or, using tail-recursion:
(defn new-last-one [s]
  (if (= (count s) 1) (first s)
      (recur (rest s))))
(= (new-last-one [1 2 3 4 5]) 5)
(= (new-last-one '(5 4 3)) 3)
(= (new-last-one ["b" "c" "d"]) "d")


;; #20: Penultimate Element
;; Write a function which returns the second to last element from a sequence.
(defn penultimate [coll]
  (if (= (count coll) 2) (first coll)
      (recur (rest coll))))
(= (penultimate (list 1 2 3 4 5)) 4)
(= (penultimate ["a" "b" "c"]) "b")
(= (penultimate [[1 2] [3 4]]) [1 2])


;; #21: Nth Element
;; Write a function which returns the Nth element from a sequence.
(defn nth-element [coll n]
  (if (zero? n)
    (first coll)
    (recur (rest coll) (- n 1))))
(= (nth-element '(4 5 6 7) 2) 6)
(= (nth-element [:a :b :c] 0) :a)
(= (nth-element [1 2 3 4] 1) 2)
(= (nth-element '([1 2] [3 4] [5 6]) 2) [5 6])


;; #22: Count a Sequence
;; Write a function which returns the total number of elements in a sequence.
(defn count-seq [coll]
  (loop [total 0 c coll]
    (if (empty? c) total
        (recur (inc total) (rest c)))))
(= (count-seq '(1 2 3 3 1)) 5)
(= (count-seq "Hello World") 11)
(= (count-seq [[1 2] [3 4] [5 6]]) 3)

;; Here's count-seq as a reduction:
(defn reduce-count-seq [coll]
  (reduce (fn [a _] (inc a)) 0 coll))
(reduce-count-seq '(1 2 3 4)) ;; => 4


;; #24: Sum It All Up
;; Write a function which returns the sum of a sequence of numbers.
(defn sum-it-all-up [coll]
  (reduce + coll))
(= (sum-it-all-up [1 2 3]) 6)
(= (sum-it-all-up (list 0 -2 5 5)) 8)
(= (sum-it-all-up #{4 2 1}) 7)
(= (sum-it-all-up '(0 0 -1)) -1)
(= (sum-it-all-up '(1 10 3)) 14)


;; #25: Find the odd numbers
;; Write a function which returns only the odd numbers from a sequence.
(defn my-odd? [coll]
  (filter #(= (mod % 2) 1)
          coll))
(= (my-odd? #{1 2 3 4 5}) '(1 3 5))
(= (my-odd? [4 2 1 6]) '(1))
(= (my-odd? [2 2 4 6]) '())
(= (my-odd? [1 1 1 3]) '(1 1 1 3))


;; #23: Reverse a Sequence
;; Write a function which reverses a sequence.
;; This one was fun!
(defn my-reverse [coll]
  (reduce conj () coll))
(my-reverse '(1 2 3 4 5)) ;; => (5 4 3 2 1)
(my-reverse [1 2 3 4 5]) ;; => (5 4 3 2 1)
;; We could make this even more condensed:
#(reduce conj '() %)


;; #27: Palindrome Detector
;; Write a function which returns true if the given sequence is a palindrome.
;; Old Attempt:
;;(defn palindrome? [data]
;;  (let [reversed (seq (apply str (reverse data)))
;;        original (seq data)]
;;    (do (println original reversed))
;;    (= reversed original)))
;; AHH. reverse returns a seq. I was making this wayy too difficult.
(defn palindrome? [data]
  (= (seq data) (reverse data)))
(palindrome? "racecar") ;; => true
(palindrome? "racecars") ;; => false
(palindrome? '(1 2 3 3 2 1));; => true
(palindrome? [2 3 2]);; => true
(palindrome? [4 3 2]);; => false


;; #26: Fibonacci Sequence
;; Write a function which returns the first X fibonacci numbers.
(defn fib [n]
  (take n
        (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))
;; (Alright, I kinda cheated on this one. But this solution is so cool c: )
(fib 3) ;; => (1 1 2)
(fib 6) ;; => (1 1 2 3 5 8)
(fib 8) ;; => (1 1 2 3 5 8 13 21)


;; #28: Flatten a Sequence
;; Write a function which flattens a sequence.
;; http://www.4clojure.com/problem/28

;; WHEN-LET: https://clojuredocs.org/clojure.core/when-let
;; From the docs: Very useful when working with sequences. Capturing the return value 
;; of `seq` brings a performance gain in subsequent `first`/`rest`/`next`
;; calls. Also the block is guarded by `nil` punning.

;; CONS vs CONJ vs CONCAT vs LIST vs LIST*?
;; https://gist.github.com/noahlz/5510191
(defn flat [coll]
  (lazy-seq
   (when-let [s (seq coll)]
     (if (coll? (first s))
       (concat (flat (first s)) (flat (rest s)))
       (cons (first s) (flat (rest s)))))))

(= (flat '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; true
(= (flat ["a" ["b"] "c"]) '("a" "b" "c")) ;; true
(= (flat '((((:a))))) '(:a)) ;; true
(= (flat '({:a 3})) '(:a 3))


;; #29: Get the Caps
;; Write a function which takes a string and returns
;; a new string containing only the capital letters.
(def get-caps (fn [s]
                (apply str (re-seq #"[A-Z]" s))))
(get-caps "HeLlO, WoRlD!")
(get-caps "nothing")
(get-caps "$#A(*&987Zf")


;; #30 Compress a Sequence
;; Write a function which removes consecutive duplicates from a sequence.
(defn compress-seq [seq]
  (map first (partition-by identity seq)))
;; PARTITION-BY: https://clojuredocs.org/clojure.core/partition-by
(compress-seq "leeeroy") ;; (\l \e \r \o \y)
(apply str (#(map first (partition-by identity %)) "hooowdy")) ;; "howdy"
(apply str (compress-seq "Leeeeeerrroyyy")) ;; => "Leroy"


;; #31: Pack a Sequence
;; Write a function which packs consecutive duplicates into sub-lists.
;; http://www.4clojure.com/problem/31
(defn pack-a-seq [coll]
  (partition-by identity coll))
(pack-a-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)) ;; '((1 1) (2) (1 1 1) (3 3))
(pack-a-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)) ;; '((:a :a) (:b :b) (:c))
(pack-a-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])) ;; '(([1 2] [1 2]) ([3 4]))


;; #32: Duplicate a Sequence
;; Write a function which duplicates each element of a sequence.
(defn dup [coll]
  (mapcat (fn [x] [x x]) coll))
(dup [1 2 3]) ;; => (1 1 2 2 3 3)


;; #33: Replicate a Sequence
;; Write a function which replicates each element of a sequence a variable number of times.
;; MAPCAT: https://clojuredocs.org/clojure.core/mapcat
(defn replicate-seq [s n] (mapcat #(repeat n %) s))
(= (replicate-seq [1 2 3] 2) '(1 1 2 2 3 3)) ;; true
(= (replicate-seq [:a :b] 4) '(:a :a :a :a :b :b :b :b)) ;; true
(= (replicate-seq [4 5 6] 1) '(4 5 6)) ;; true
(= (replicate-seq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) ;; true
(= (replicate-seq [44 33] 2) [44 44 33 33]) ;; true 


;; #34: Implement Range
;; Write a function which creates a list of all integers in a given range.
(defn my-range [start end]
  (loop [s start c []]
    (if (<= end s) c
        (recur (inc s) (conj c s)))))
(my-range 1 5) ;; => (1 2 3 4)
;; This solution also works, but I'm not a huge fan:
(#(take (- %2 %1) (iterate inc %1)) 5 13)


;; #38: Maximum Value
(defn max-val [& xs]
  (reduce
   #(if (> %1 %2)
      %1
      %2)
   xs))
(max-val 1 2 3) ;; => 3
(max-val 30 20) ;; => 30
(max-val 45 67 11 20) ;; => 67


;; #40: Interpose a Seq
;; Write a function which separates the items of a sequence by an arbitrary value.
;; http://www.4clojure.com/problem/40
(defn interpose-seq [joiner coll]
  (apply str (butlast (mapcat #(vector % joiner) coll))))
(interpose-seq ", " ["first" "second" "third"]) ;; "first, second, third"
(= (interpose-seq 0 [1 2 3]) [1 0 2 0 3]) ;; true
(= (apply str (interpose-seq ", " ["one" "two" "three"])) "one, two, three") ;; true
(= (interpose-seq :z [:a :b :c :d]) [:a :z :b :z :c :z :d]) ;; true


;; #41: Drop Every Nth Item
;; Write a function which drops every Nth item from a sequence.
;; http://www.4clojure.com/problem/41

;; PARTITION-ALL: How is it different than partition?
;; Returns a lazy sequence of lists like partition, **but may include
;; partitions with fewer than n items at the end**.  Returns a stateful
;; transducer when no collection is provided.
(defn drop-nth [coll n]
  (apply concat (partition-all (dec n) n coll)))
(drop-nth [5 6 7 8 9] 3) ;; [5 6 7 9]
(= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]) ;; true
(= (drop-nth [:a :b :c :d :e :f] 2) [:a :c :e]) ;; true
(= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6]) ;; true


;; #42: Factorial
;; Write a function that calculates factorials.
(defn factorial [n]
  (reduce * 1 (range 1 (inc n))))
(factorial 6) ;; => 720

;; Or here's a fun one;
;; have to inc the arg because range does not include its upper range in returned seq
(#(->> %
       inc
       range
       rest
       (reduce *)) 18) ; 6402373705728000

;; #45: Iterate
;; The iterate function can be used to produce an infinite lazy sequence.
;; (iterate f x)
;; x returns a lazy sequence of x, (f x), (f (f x)) etc.
(take 5 (iterate #(+ 3 %) 1)) ;; => (1 4 7 10 13)


;; #47: Contain Yourself
;; The contains? function checks if a KEY is present in a given collection. This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.
;; Answer: 4
(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 4)
(contains? {4 :a 2 :b} 4)
(not (contains? [1 2 4] 4))


;; #48: Intro to Some
;; SOME takes a predicate fn and a collection,
;; returning the first true value of (predicate x)
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))


;; #49: Split a Sequence
;; Write a function which will split a sequence into two parts.
;; http://www.4clojure.com/problem/49
;; Note: Solved, but there must be a better way than doing two INTOs
(defn split-seq [n coll]
  (into [] (map #(into []  %) (split-at n coll))))
(split-seq 3 [1 2 3 4 5 6]) ;; [[1 2 3] [4 5 6]]
(split-seq 1 [:a :b :c :d]) ;; [[:a] [:b :c :d]]
(= (split-seq 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]) ;; true
(= (split-seq 1 [:a :b :c :d]) [[:a] [:b :c :d]]) ;; true
(= (split-seq 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]) ;; true


;; #61: Map Construction



;; #83: A Half-Truth
;; Write a function which takes a variable number of booleans.
;; Your function should return true if some of the parameters are true,
;; but not all of the parameters are true. Otherwise your function should return false.
;; http://www.4clojure.com/problem/83
(defn half-true? [& bools]
  (if (and (some true? bools)
           (some false? bools))
    true false))
;; As an inline function:
(#(if (and (some true? %&) (some false? %&)) true false) true false true)
(half-true? false false true)
(half-true? true true true)
(half-true? false false false)
(= false (half-true? false false))
(= true (half-true? true false))
(= false (half-true? true))
(= true (half-true? false true false))
(= false (half-true? true true true))
(= true (half-true? true true true false))


;; #81
(defn set-intersect [s1 s2]
  (set (filter #(s1 %) s2)))

(set-intersect #{0 1 2 3} #{2 3 4 5}) ; #{2 3}
(= (set-intersect #{0 1 2} #{3 4 5}) #{})
(= (set-intersect #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})


;; #107
(defn to-the-nth [n]
  (fn [x]
    (reduce * (repeat n x))))
((to-the-nth 3) 4) ;; 64
;; Using the clojure to create intermediary functions:
(def to-the-8th
  (to-the-nth 8))
(to-the-8th 2) ;; 256


;;;;;;;;;;;;;;;;;;;;
;; *** MEDIUM *** ;;
;;;;;;;;;;;;;;;;;;;;

;; #43: Reverse Interleave
;; Write a function which reverses the interleave process into x number of subsequences.
;; Old Attempt:
;;(defn reverse-interleave [seq leaves]
;;  (take (/ (count seq) leaves) seq)
;;   )
(defn reverse-interleave [seq n]
  (apply map vector (partition n seq)))
(reverse-interleave [1 2 3 4 5 6] 2) ;; => ([1 3 5] [2 4 6])
(reverse-interleave (range 9) 3) ;; => ([0 3 6] [1 4 7] [2 5 8])
(= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))) ;; => true
(= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))) ;; => true
(= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))) ;; => true


;; #46 Flip
; Write a higher-order function which flips the order of the arguments of an input function.
(defn flip [f]
  (fn [a b] (f b a)))
;; Or, as a lambda fn:
#(fn [a b] (% b a))
(= 3 ((flip nth) 2 [1 2 3 4 5]))
(= true ((flip >) 7 8))
(= 4 ((flip quot) 2 8))
(= [1 2 3] ((flip take) [1 2 3 4 5] 3))

















