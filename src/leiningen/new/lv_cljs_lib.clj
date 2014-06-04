(ns leiningen.new.lv-cljs-lib
  (:require [leiningen.new.templates :as lnt
             :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(defn lv-cljs-lib
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}
        render (fn [file] ((lnt/renderer "lv-cljs-lib") file data))]
    (main/info "Generating fresh 'lein new' lv-cljs-lib project.")
    (->files data
             ;; Project setup
             ["project.clj" (render "project.clj")]
             [".gitignore" (render "gitignore-template")]

             ;; Code
             [(format "src/cljx/%s/sample.cljx" (:sanitized data))
              (render "src/cljx/app/sample.cljx")]
             [(format "src/cljs/%s.cljs" (:sanitized data))
              (render "src/cljs/app.cljs")]
             [(format "src/clj/%s.clj" (:sanitized data))
              (render "src/clj/app.clj")]

             ;; Tests
             [(format "test/clj/%s_test.clj" (:sanitized data))
              (render "test/clj/app_test.clj")]
             [(format "test/clj/%s/test_helper.clj" (:sanitized data))
              (render "test/clj/app/test_helper.clj")]
             [(format "test/cljs/%s_test.cljs" (:sanitized data))
              (render "test/cljs/app_test.cljs")]
             [(format "test/cljs/%s/test_helper.cljs" (:sanitized data))
              (render "test/cljs/app/test_helper.cljs")]

             )))
