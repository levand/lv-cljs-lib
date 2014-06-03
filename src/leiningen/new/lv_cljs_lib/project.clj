(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "describe me"
  :url "url me"
  :license {:name "license me"
            :url ""}
  :plugins [[com.keminglabs/cljx "0.4.0"]]
  :hooks [cljx.hooks]
  :resource-paths []
  :source-paths ["src/clj"
                 "src/cljs"
                 "gen/clj"
                 "gen/cljs"]
  :test-paths ["test/clj"
               "test/cljs"]
  :main {{name}}
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "gen/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "gen/cljs"
                   :rules :cljs}]})
