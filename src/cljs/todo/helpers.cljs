(ns todo-list.helpers)

(defn log [& args] (apply (.-log js/console) args))