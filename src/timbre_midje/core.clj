(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(defn init [level]
  (timbre/set-level! level)
  (timbre/info "Will be printed")
  (timbre/debug "Won't be printed"))
