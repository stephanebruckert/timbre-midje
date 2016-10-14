(ns timbre-midje.core-test
  (:require [timbre-midje.core :as core]
            [taoensso.timbre :as timbre]
            [midje.sweet :refer :all]))

(fact "print info but not debug"
  (core/init :info) => nil
  (provided
    (#'timbre/vargs->margs anything anything ["Will be printed"]) => {} :times 1
    (#'timbre/vargs->margs anything anything ["Won't be printed"]) => {} :times 0))
