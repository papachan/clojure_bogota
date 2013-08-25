(ns website.examples
	(:require [clojure.pprint :refer [cl-format]]))

(cl-format nil "~{~R~^, ~}" [1 2 3 4])
;=> "one, two, three, four"

(cl-format nil "~r" (rand-int 1e9))

; partial
(def only-strings (partial filter string?))
(only-strings ["a" 5 "b" 6])
;=> ("a" "b")

(map (fn [n] (* n n n)) [1 2 3 4])
;=> (1 8 27 64)

(for [[k v] {:a 1 :b 2}] [v k])
;=> ([1 :a] [2 :b])

(if (< x 10) :less :more)
;=> :less

(defn sqr [n] (* n n))

(map sqr [1 2 3])
;=> (1 4 9)

(deftype Cons [h t])

(.-t (Cons. 1 108))
;=> 108

(defmulti classify-age :age)

(defmethod classify-age 36 [_] :ancient)

(classify-age {:age 36})
;=> :ancient


