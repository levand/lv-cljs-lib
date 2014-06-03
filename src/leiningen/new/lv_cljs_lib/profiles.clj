{:profiles
 {:dev
  {:resource-paths ["resources"]
                  :plugins [[lein-cljsbuild "1.0.3"]]
                  :dependencies [[org.clojure/clojure "1.6.0"]
                                 [org.clojure/clojurescript "0.0-2227"]]
   :cljsbuild {:dev {:source-paths ["src/cljs" "gen/cljs"]
                     :output-to "resources/public/dev/gen/{{name}}.js"
                     :output-dir "resources/public/dev/gen"
                     :optimizations :none
                     :pretty-print :true
                     :source-map true}
               :prod {:source-paths ["src/cljs" "gen/cljs"]
                      :output-to "resources/public/gen/{{name}}.js"
                      :pretty-print false
                      :optimizations :advanced}}}}}
