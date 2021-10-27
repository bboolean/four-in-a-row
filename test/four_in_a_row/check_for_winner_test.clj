(ns four-in-a-row.check-for-winner-test
  (:require [clojure.test :refer :all]
            [four-in-a-row.check-for-winner :as check-for-winner]))

(deftest get-space-test
  (testing "get-space"
   (is (=
        "a"
        (check-for-winner/get-space
         :x 2
         :y 0
         :dir [0 0]
         :num 0
         :board '(()
                  ()
                  ("a")
                  ()
                  ()
                  ()
                  ()))))))

(deftest get-four-spaces-test
  (testing "get-four-spaces"
   (is (=
        ["a" "b" "c" "d"]
        (check-for-winner/get-four-spaces
         :x 2
         :y 0
         :dir [1 1]
         :board '(()
                  ()
                  ("a")
                  ("b" "_")
                  ("c" "_" "_")
                  ("d" "_" "_" "_")
                  ()))))))

(deftest check-direction-test
  (testing "check-direction"
   (is (=
        true
        (check-for-winner/check-direction
         :x 2
         :y 0
         :turn "x"
         :dir [1 1]
         :board '(()
                  ()
                  ("x")
                  ("x" "_")
                  ("x" "_" "_")
                  ("x" "_" "_" "_")
                  ()))))
    (is (=
         false
         (check-for-winner/check-direction
          :x 2
          :y 0
          :turn "x"
          :dir [1 0]
          :board '(()
                   ()
                   ("x")
                   ("x" "_")
                   ("x" "_" "_")
                   ("x" "_" "_" "_")
                   ()))))))

(deftest check-directions-test
  (testing "check-directions"
   (is (=
        [false false false false true false false false]
        (check-for-winner/check-directions
         :x 2
         :y 0
         :turn "x"
         :board '(()
                  ()
                  ("x")
                  ("x" "_")
                  ("x" "_" "_")
                  ("x" "_" "_" "_")
                  ()))))))

(deftest winner?-test
  (testing "winner?"
   (is (=
        true
        (check-for-winner/winner?
         :x 2
         :y 0
         :turn "x"
         :board '(()
                  ()
                  ("x")
                  ("x" "_")
                  ("x" "_" "_")
                  ("x" "_" "_" "_")
                  ()))))
    (is (=
         false
         (check-for-winner/winner?
          :x 2
          :y 0
          :turn "x"
          :board '(()
                   ()
                   ("x")
                   ("x" "_")
                   ("o" "_" "_")
                   ("x" "_" "_" "_")
                   ()))))))
