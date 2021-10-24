(ns four-in-a-row.core
  (:gen-class)
  (:require [four-in-a-row.print-board :as print-board]))

(def board
  '(()
    ()
    ()
    ()
    ()
    ()
    ()))

(defn cons-checker [new-checker-index new-checker index list]
  (if
   (== index new-checker-index)
    (cons new-checker list)
    list))

(defn add-checker [new-checker-index new-checker board]
  (map-indexed (partial cons-checker new-checker-index new-checker) board))

(defn print-board [turn board]
  (str
   "\n"
   "\033[31m"
   (print-board/print-board board)
   "\033[0m"
   "\n"
   "\033[34m"
   "1 2 3 4 5 6 7"
   "\033[0m"
   "\n\n"
   turn "'s turn> "))

(defn game-loop [turn board]
  (do
    (print (print-board turn board))
    (flush)
    (let [new-checker-index (- (bigdec (read-line)) 1)
          new-board (add-checker new-checker-index turn board)
          new-turn (if (= "x" turn) "o" "x")]
      (game-loop new-turn new-board))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (game-loop "x" board))
