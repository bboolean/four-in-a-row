(ns four-in-a-row.check-for-winner
  (:require
   [four-in-a-row.print-board :as print-board]))

(def directions
  [[1 0]
   [-1 0]
   [0 1]
   [0 -1]
   [1 1]
   [1 -1]
   [-1 1]
   [-1 -1]])

(defn get-space [& {:keys [board x y num dir]}]
  (print-board/print-board-space
   board
   (+ y (* num (second dir)))
   (+ x (* num (first dir)))))

(defn get-four-spaces [& {:keys [board x y dir]}]
  (map
   (fn [num] (get-space :board board :x x :y y :dir dir :num num))
   (range 0 4)))

(defn check-direction [& {:keys [board x y turn dir]}]
  (= 4 (count (filter #(= turn %1)
                      (get-four-spaces :board board :x x :y y :dir dir)))))

(defn check-directions [& {:keys [board x y turn]}]
  (map
   (fn [dir] (check-direction :board board :x x :y y :turn turn :dir dir))
   directions))

(defn winner? [& {:keys [board x y turn]}]
  (<= 1 (count (filter true?
                       (check-directions :board board :x x :y y :turn turn)))))

