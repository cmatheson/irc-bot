(ns irc-bot.core
  "echo bot"
  (:require [irclj.core :as irclj]))

(def channel "#cambot")

(defn echo [irc {:keys [nick text] :as data}]
  (irclj/message irc channel (str nick ":") text))

(def callbacks {:privmsg echo})

(defn -main []
  (let [freenode (irclj/connect "irc.freenode.net" 6667 "cambot"
                                :username "cambot"
                                :callbacks callbacks)]
    (irclj/join freenode channel)))
