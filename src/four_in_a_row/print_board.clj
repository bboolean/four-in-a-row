(ns four-in-a-row.print-board)

(defn print-board-space [board row column]
  (as-> board $
    (nth $ column "_")
    (reverse $)
    (nth $ row "_")))

(defn print-board-row [row board]
  (as-> (range 0 7) $
    (map (partial print-board-space board row) $)
    (clojure.string/join " " $)))

(defn print-board [board]
  (as-> (range 0 5) $
    (map
     (fn [row] (print-board-row row board))
     $)
    (reverse $)
    (clojure.string/join "\n" $)))
 
