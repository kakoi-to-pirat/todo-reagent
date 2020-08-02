(ns todo-list.components.todo-input
  (:require
   [reagent.core :as reagent]
   [todo-list.helpers :as helpers]
   [todo-list.store :as store]))

(def input-value (reagent/atom ""))

(def enter-key 13)

(def escape-key 27)

(defn on-enter [] ((store/add-todo @input-value)
                   (helpers/log (str "enter: " @input-value))))

(defn on-esc [] (helpers/log "esc"))

(defn on-key-down [key] (condp = (.-which key)
                          enter-key (on-enter)
                          escape-key (on-esc)
                          nil))

(defn on-blur [] (helpers/log "blur"))

(defn on-change [value] (reset! input-value value))

(defn render []
  [:input {:class "todo-input"
           :type "text"
           :value @input-value
           :placeholder "What needs to be done?"
           :on-blur #(on-blur)
           :on-change #(on-change (-> % .-target .-value))
           :on-key-down #(on-key-down %)}])