(ns timbre-midje.core-test
  (:require [timbre-midje.core :as core]
            [taoensso.timbre :as timbre]
            [midje.sweet :refer :all]))

(fact "print info but not debug"
  (core/init :info) => nil
  (provided
    (core/log-stub :info ["Will be printed"]) => irrelevant :times 1
    (core/log-stub :debug ["Won't be printed"]) => irrelevant :times 0))
