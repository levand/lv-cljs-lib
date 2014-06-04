(ns {{name}}-test
    (:require-macros [cemerick.cljs.test :refer [is deftest]]
                     [clojure.test.check.clojure-test :refer [defspec]])
    (:require [cemerick.cljs.test :as t]
              [clojure.test.check.properties :as prop :include-macros true]
              [clojure.test.check.generators :as gen]
              [clojure.test.check.clojure-test]
              [{{name}} :as app]))

(deftest tests-work
  (is (nil? (app/lib "World"))))

(defspec property-tests-work
  1000
  (prop/for-all [s gen/string-ascii]
     (= (* 2 (.-length s)) (.-length (str s s)))))