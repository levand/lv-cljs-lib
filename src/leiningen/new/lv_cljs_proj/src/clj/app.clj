(ns {{name}}
  (:gen-class)
  (:require [{{name}}.sample :as sample]))

(defn -main
  "Entry point for Clojure application"
  [& args]
  (println (sample/hello "World")))
