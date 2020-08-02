(ns todo-list.components.todo-list
  (:require [todo-list.store :as store]
            [todo-list.helpers :as helpers]))

(defn on-toggle [id] ((store/update-todo id)
                      (helpers/log (str "checked todo: " id))))

(defn on-remove [id] ((store/remove-todo id)
                      (helpers/log (str "remove todo: " id))))

(defn render []
  [:div
   [:ul {:class "todo-list"}
    (for [[index todo] (map-indexed vector @store/todos)]
      (let [[id item] todo]
        [:li {:key index
              :class "todo-item"}
         [:input {:id (str "todo-item-" id)
                  :class "todo-item-checkbox"
                  :type "checkbox"
                  :checked (-> item :done)
                  :on-change #(on-toggle id)}]
         [:label {:for (str "todo-item-" id)
                  :class (if (-> item :done) "todo-item-label done" "todo-item-label")}
          (-> item :title)]
         [:button {:class "todo-item-button"
                   :on-click #(on-remove id)} "メ"]]))]
   "All tasks: " @store/todos-count])