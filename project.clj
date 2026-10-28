(defproject conao3/lambda-clojure "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.12.6"]
                 [compojure "1.7.2"]
                 [ring/ring-defaults "0.7.1"]
                 [ring/ring-json "0.5.1"]
                 [uswitch/lambada "0.1.2"]
                 [cheshire "6.2.0"]
                 [ring-apigw-lambda-proxy "0.4.0"]
                 [dali "1.0.2"]
                 [etaoin "1.1.43"]]
  :plugins [[lein-ring "0.12.6"]
            [lein-lambda "0.2.0"]]
  :ring {:handler conao3.lambda-clojure.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.6.2"]]}
   :uberjar {:aot :all}}
  :lambda {:function {:name "lambda-clojure"
                      :handler "conao3.lambda-clojure.lambda.LambdaFn"
                      :role "minimum-lambda-execution-role"}
           :api-gateway {:name "lambda-clojure"}
           :stages {"stable" {:warmup {:enable true}}
                    "dev" {}}})
