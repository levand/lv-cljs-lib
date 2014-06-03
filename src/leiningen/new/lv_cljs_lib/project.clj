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
                   :rules :cljs}]}
  :profiles
  {:dev {:plugins      [[lein-cljsbuild "1.0.3"]
                        [com.cemerick/clojurescript.test "0.3.1"]]
         :dependencies [[org.clojure/clojure "1.6.0"]
                        [org.clojure/clojurescript "0.0-2227"]]
         :hooks        [leiningen.cljsbuild]
         :cljsbuild    {:builds        {:whitspace      {:source-paths  ["test/cljs"]
                                                         :compiler      {:output-to     "target/cljsbuild/whitespace/{{name}}.js"
                                                                         :pretty-print  true}}
                                        :advanced {:source-paths  ["test/cljs"]
                                                   :compiler      {:output-to     "target/cljsbuild/advanced/{{name}}.js"
                                                                   :pretty-print  false
                                                                   :optimizations :advanced}}}
                        :test-commands {"test-whitespace" ["phantomjs" :runner
                                                           "target/cljsbuild/whitespace/{{name}}.js"]
                                        "test-advanced" ["phantomjs" :runner
                                                         "target/cljsbuild/advanced/{{name}}.js"]}}}}
  )