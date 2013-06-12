(ns website.app
  (:use (compojure handler
                   [core :only (GET POST defroutes)]))
  (:require [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [clostache.parser :as clostache])
  (:gen-class))

(def frases (list "A practical language for practical problems"
                  "sharing is cheap"
                  "immutable objects are always thread safe"))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource (str "templates/" template-name ".mustache"))))

(defn render-template [template-file params]
   (clostache/render (read-template template-file) params))

(defn index 
  []
  (let
    [cad (nth frases (rand-int (count frases)))]
    (render-template "random" {:phrase cad})))

(defroutes main-routes
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "404 Not Found"))

;; starting server as main
(defn -main []
  (let 
    [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (jetty/run-jetty main-routes {:port port})))

