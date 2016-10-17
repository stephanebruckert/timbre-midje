(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(def default-config
  {})

(defn init
  ([level]
    (init level default-config))
  ([level config]
    (timbre/merge-config! config)
    (timbre/set-level! level)
    (timbre/info "Will be printed")
    (timbre/debug "Won't be printed")))
