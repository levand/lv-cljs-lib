(ns {{name}}-test
    (:require-macros [cemerick.cljs.test :refer [is deftest]])
    (:require [cemerick.cljs.test :as t]
              [{{name}} :as app]))

(deftest tests-work
  (is (nil? (app/lib "World"))))
