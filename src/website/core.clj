(ns website.core
  (:gen-class))

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

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
