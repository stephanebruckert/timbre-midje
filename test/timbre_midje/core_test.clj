(ns timbre-midje.core-test
  (:require [timbre-midje.core :as core]
            [taoensso.timbre :as timbre]
            [midje.sweet :refer :all]))

(fact "print info but not debug"
      (core/init :info) => nil
      (provided
       (timbre/default-output-fn (as-checker (fn [opts]
                                        (= (-> opts :config :level)
                                           :info))))
       => anything :times 1)
      (provided
       (timbre/default-output-fn (as-checker (fn [opts]
                                        (= (-> opts :config :level)
                                           :debug))))
       => anything :times 0))

(fact "print Will be printed, not Won't be printed"
      (core/init :info) => nil
      (provided
       (#'timbre/vargs->margs anything anything ["Will be printed"]) => {} :times 1)
      (provided
       (#'timbre/vargs->margs anything anything ["Won't be printed"]) => {} :times 0) )
