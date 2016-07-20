(ns letov.app
  (:require
   [clojure.string :as str])
  (:gen-class))

(def files-contents
  (map
   (comp
    str/split-lines slurp
    #(str "data/list_" % ".txt"))
   (range 1 5)))

(def text
  (repeatedly 4 #(map rand-nth files-contents)))

(defn -main [& args]
  (print "О-о-о-о! Моя оборона!")
  (doseq [line text]
    (newline)
    (doseq [word line]
      (print word "")
      (flush)
      (Thread/sleep 400))
    (Thread/sleep 500))
  (newline))


