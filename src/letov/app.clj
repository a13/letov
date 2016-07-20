(ns letov.app
  (:require
   [clojure.string :as str])
  (:gen-class))

(def files-content
  (map
   (comp
    (partial remove str/blank?)
    str/split-lines
    slurp
    #(str "data/list_" % ".txt"))
   (range 1 5)))

(defn verse
  []
  (cons '("О-о-о-о! Моя оборона!")
        (repeatedly 4 #(map rand-nth files-content))))

(defn -main [& args]
  (while true
    (doseq [line (verse)]
      (doseq [char (str/join " " line)]
        (print char)
        (flush)
        (Thread/sleep 40))
      (Thread/sleep 200)
      (newline))
    (newline))
  (newline))


