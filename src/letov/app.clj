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
;;    #(str "data/list_" % ".txt"))
    #(str "https://raw.githubusercontent.com/a13/letov/master/data/list_" % ".txt"))
   (range 1 5)))

(defn- verse
  []
  (str/join \newline
   (cons "О-о-о-о! Моя оборона!"
         (repeatedly 4 #(str/join \space (map rand-nth files-content))))))

(defn- char-dly
  [char]
  (case char
    \space 100
    \newline 300
    40))

(defn- print-verse
  [verse]
  (doseq [char verse]
    (print char)
    (flush)
    (Thread/sleep (char-dly char)))
  (newline)
  (newline))

(defn -main [& args]
  (while true
    (print-verse (verse)))
  (newline))


