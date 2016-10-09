(ns timbre-midje.core
  ;; Clojure
  (:require [taoensso.timbre :as timbre]))

(defn my-output-fn [data]
  (println "my-output-fn was called")
  (timbre/default-output-fn data))

(defn init [level]
  (timbre/merge-config! {:output-fn my-output-fn})
  (timbre/set-level! level)
  (timbre/info "Will be printed")
  (timbre/debug "Won't be printed"))

(defn -main []
  (init :info))
