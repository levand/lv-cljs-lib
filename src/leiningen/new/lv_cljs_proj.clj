(ns leiningen.new.lv-cljs-proj
  (:require [leiningen.new.templates :as lnt
             :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(defn lv-cljs-proj
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}
        render (fn [file] ((lnt/renderer "lv-cljs-proj") file data))]
    (main/info "Generating fresh 'lein new' lv-cljs-proj project.")
    (->files data
             ;; Project setup
             ["project.clj" (render "project.clj")]
             ["profiles.clj" (render "profiles.clj")]

             ;; Resources
             [(format "resources/public/dev/%s.html" (:name data))
              (render "resources/public/dev/app.html")]
             [(format "resources/public/%s.html" (:name data))
              (render "resources/public/app.html")]
             [(format "resources/public/%s.css" (:name data))
              (render "resources/public/app.css")]

             ;; Code
             [(format "src/cljx/%s/sample.cljx" (:sanitized data))
              (render "src/cljx/app/sample.cljx")]
             [(format "src/cljs/%s.cljs" (:sanitized data))
              (render "src/cljs/app.cljs")]
             [(format "src/clj/%s.clj" (:sanitized data))
              (render "src/clj/app.clj")]

             )))
