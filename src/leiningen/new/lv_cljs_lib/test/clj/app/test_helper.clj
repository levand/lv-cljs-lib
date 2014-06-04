(ns {{name}}.test-helper)

(def ^:dynamic *testcheck-scale*
  (or (if-let [scale (System/getProperty "clojure.test.check.scale")]
        (Double/parseDouble scale))
      1.0))

(defn scale
  "Scale a test check count"
  [n]
  (int (* n *testcheck-scale*)))