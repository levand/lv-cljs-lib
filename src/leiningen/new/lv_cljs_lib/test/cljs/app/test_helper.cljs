(ns {{name}}.test-helper)

(def ^:dynamic *testcheck-scale*
  (or (this-as this (aget this "clojure.test.check.scale")) 1.0))

(defn scale
  "Scale a test check count"
  [n]
  (int (* n *testcheck-scale*)))