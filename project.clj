(defproject four-in-a-row "0.1.0-SNAPSHOT"
  :description "Play four in a row."
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot four-in-a-row.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
