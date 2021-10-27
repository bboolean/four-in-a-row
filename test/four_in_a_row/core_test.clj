(ns four-in-a-row.core-test
  (:require [clojure.test :refer :all]
            [four-in-a-row.core :as core]))

(deftest add-checker-to-column-test
  (testing "add-checker-to-column"
    (is (=
         '("x" "o")
         (core/add-checker-to-column 0 "x" 0 '("o"))))
    (is (=
         '("o")
         (core/add-checker-to-column 1 "x" 0 '("o"))))))

(deftest add-checker-test
  (testing "add-checker"
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
