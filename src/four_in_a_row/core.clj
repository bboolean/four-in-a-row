(ns four-in-a-row.core
  (:gen-class)
  (:require
   [four-in-a-row.print-board :as print-board]
   [four-in-a-row.check-for-winner :as check-for-winner]))

(def board
  '(()
    ()
    ()
    ()
    ()
    ()
    ()))

(defn add-checker-to-column [x turn index column]
  (if (= index x) (cons turn column) column))

(defn add-checker [x turn board]
  (map-indexed (partial add-checker-to-column x turn) board))

(defn print-board [board]
  (str
   "\n"
   "\033[31m"
   (print-board/print-board board)
   "\033[0m"
   "\n"
   "\033[34m"
   "1 2 3 4 5 6 7"
   "\033[0m"
   "\n\n"))

(defn print-prompt [turn]
  (str turn "'s turn> "))

(defn input-invalid? [x y]
  (or (> x 6)
      (< x 0)
      (> y 4)))

(defn game-loop [turn board]
  (do
    (print (print-board board))
    (print (print-prompt turn))
    (flush)
    (let [x (- (Integer/parseInt (read-line)) 1)
          new-board (add-checker x turn board)
          y (- (count (nth new-board x [])) 1)
          new-turn (if (= "x" turn) "o" "x")]
      (cond
        (input-invalid? x y)
        (do
          (println "\n### Input invalid; please try again ###")
          (game-loop turn board))

        (check-for-winner/winner? :x x :y y :turn turn :board new-board)
        (do
          (print (print-board new-board))
          (println (str "🎉🎉 Player " turn " wins! 🎉🎉\n")))

        :else
        (game-loop new-turn new-board)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (game-loop "x" board))

