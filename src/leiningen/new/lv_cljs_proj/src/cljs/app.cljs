(ns {{name}}
  (:require [{{name}}.sample :as sample]))

(defn ^:export main
  "Entry point for ClojureScript application"
  []
  (.log js/console (sample/hello "World")))
