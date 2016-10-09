(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(defn print [level]
  (timbre/set-level! level)
  (timbre/info "Will be printed")
  (timbre/debug "Should not be printed"))

(defn -main []
  (init :info))
