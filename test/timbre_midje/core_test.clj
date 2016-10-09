(ns timbre-midje.core-test
  (:require [timbre-midje.core :as core]
            [taoensso.timbre :as timbre]
            [midje.sweet :refer :all]))

(fact "print info but not debug"
  (core/init :info) => nil
  (provided
    (core/my-output-fn anything) => irrelevant :times 1))
