(ns todo-list.store
  (:require [reagent.core :as reagent]))

(def todos (reagent/atom (sorted-map)))

(def todos-count (reagent/atom 0))

(defn update-todo [id] (swap! todos update-in [id :done] not))

(defn add-todo [title]
  (let [id (swap! todos-count inc)]
    (swap! todos assoc id {:id id :title title :done false})))

(defn remove-todo [id]
  (swap! todos dissoc id))