(ns four-in-a-row.core-test
  (:require [clojure.test :refer :all]
            [four-in-a-row.core :as core]))

(deftest cons-checker-test
  (testing "cons-checker-test"
    (is (=
         '("x" "o")
         (core/cons-checker 0 "x" 0 '("o"))))
    (is (=
         '("o")
         (core/cons-checker 1 "x" 0 '("o"))))))

(deftest add-checker-test
  (testing "add-checker-test"
    (is (=
         '(()
           ()
           ("x" "o")
           ()
           ()
           ()
           ())
         (core/add-checker
          2
          "x"
          '(()
            ()
            ("o")
            ()
            ()
            ()
            ()))))))
