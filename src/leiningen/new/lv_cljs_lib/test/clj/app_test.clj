(ns {{name}}-test
    (:require [clojure.test :refer :all]
              [{{name}} :as app]))

(deftest tests-work
  (is (nil? (app/lib "World"))))
