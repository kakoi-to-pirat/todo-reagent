(ns todo-list.components.todo-list
  (:require [todo-list.store :as store]))

(defn render []
  [:div
   [:ul
    (for [[index todo] (map-indexed vector @store/todos)]
      (let [[id title] todo]
        ^{:key index}
        [:li {:class "todo-item"} id title]))]
   @store/todos-count])