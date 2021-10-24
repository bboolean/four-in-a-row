(ns four-in-a-row.print-board-test
  (:require [clojure.test :refer :all]
            [four-in-a-row.print-board :as print-bard]))

(deftest print-board-space
  (testing print-board-space
    (is (=
         "o"
         (print-board/print-board-space
          '(()
            ()
            ("x" "o")
            ()
            ()
            ()
            ())
          0
          2)))))

(deftest print-board-row-test
  (testing "print-board-row-test"
    (is (=
         "_ _ x _ _ _ _"
         (print-board/print-board-row
          0
          '(()
            ()
            ("x")
            ()
            ()
            ()
            ()))))))

(deftest print-board-test
  (testing "print-board-test"
    (is (=
         (str
          "_ _ _ _ _ _ _\n"
          "_ _ _ _ _ _ _\n"
          "_ _ _ _ _ _ _\n"
          "x _ _ o _ _ _\n"
          "o _ _ x _ x _")
         (print-board/print-board
          '(("x" "o")
            ()
            ()
            ("o" "x")
            ()
            ("x")
            ()))))))
