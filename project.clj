(defproject letov "0.1.0"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot letov.app
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
