(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(defn log-stub [level message])

(defn init [level]
  (timbre/merge-config!
    {:appenders
      {:test-appender
        {:enabled? true
         :fn (fn [data] (log-stub (:level data) (:vargs data)))}}})
  (timbre/set-level! level)
  (timbre/info "Will be printed")
  (timbre/debug "Won't be printed"))
