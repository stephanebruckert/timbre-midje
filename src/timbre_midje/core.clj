(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(defn init
  ([level]
    (init level nil))
  ([level config]
    (if-not (nil? config)
      (timbre/merge-config! config))
    (timbre/set-level! level)
    (timbre/info "Will be printed")
    (timbre/debug "Won't be printed")))
