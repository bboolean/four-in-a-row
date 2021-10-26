(ns four-in-a-row.check-for-winner-test
  (:require
   [four-in-a-row.check-for-winner :as check-for-winner]))

(deftest compute-new-coords-test
  (testing
   (is (=
        [1 99]
        (check-for-winner/compute-new-coords
         :x 0 :y 100 :num 1 :dir [1 -1])))))

(deftest compute-four-coords-test
  (testing
   (is (=
        [[0 100] [1 99] [2 98] [3 97]]
        (check-for-winner/compute-four-coords
         :x 0 :y 100 :dir [1 -1])))))

(deftest compute-possible-wins-coords-test
  (testing
   (is (=
        [[[0 100] [1 100] [2 100] [3 100]]
         [[0 100] [-1 100] [-2 100] [-3 100]]
         [[0 100] [0 101] [0 102] [0 103]]
         [[0 100] [0 99] [0 98] [0 97]]
         [[0 100] [1 101] [2 102] [3 103]]
         [[0 100] [1 99] [2 98] [3 97]]
         [[0 100] [-1 101] [-2 102] [-3 103]]
         [[0 100] [-1 99] [-2 98] [-3 97]]]
        (check-for-winner/compute-possible-wins-coords
         :x 0 :y 100)))))

(deftest compute-four-coords-test
  (testing
   (is (=
        [[0 100] [1 99] [2 98] [3 97]]
        (check-for-winner/convert-four-coords-to
         :x 0 :y 100 :dir [1 -1])))))

(deftest get-space
  (testing
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

(deftest get-four-spaces
  (testing
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

(deftest check-direction
  (testing
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
  (testing
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

(deftest check-for-winner-test
  (testing
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
