(ns timbre-midje.core-test
  (:require [timbre-midje.core :as core]
            [taoensso.timbre :as timbre]
            [midje.sweet :refer :all]))

(defn log-stub [level message])

(def stub-config
  {:appenders
    {:test-appender
      {:enabled? true
       :fn (fn [data] (log-stub (:level data) (:vargs data)))}}})

(fact "print info but not debug"
  (core/init :info stub-config) => nil
  (provided
    (log-stub :info ["Will be printed"]) => irrelevant :times 1
    (log-stub :debug ["Won't be printed"]) => irrelevant :times 0))
