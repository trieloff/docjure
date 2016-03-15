(defproject dk.ative/docjure "1.11.0-SNAPSHOT"
  :description "Easily read and write Office documents from Clojure."
  :url "http://github.com/mjul/docjure"
  :license {:name "MIT License"
            :url "http://http://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.poi/poi "3.13"]
                 [org.apache.poi/poi-ooxml "3.13"]]
  :plugins [[lein-difftest "2.0.0"]
            [test2junit "1.1.2"]
            [lein-maven-s3-wagon "0.2.4"]]
  :deploy-repositories {"private" {:url "s3://leinrepo/releases/"
                                   :username :env/aws_access_key ;; gets environment variable AWS_ACCESS_KEY
                                   :password :env/aws_secret_key}}
  :profiles {:1.3  {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4  {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5  {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6  {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7  {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8  {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :test {:global-vars  {*warn-on-reflection* false}
                    :dependencies [[com.cemerick/pomegranate "0.3.0"]]}}
  :test2junit-output-dir ~(or (System/getenv "CIRCLE_TEST_REPORTS") "target/test2junit")
  :aliases {"all" ["with-profile" "1.3:1.4:1.5:1.6:1.7:1.8"]}
  :global-vars {*warn-on-reflection* true})

