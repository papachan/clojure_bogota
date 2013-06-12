(ns website.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
