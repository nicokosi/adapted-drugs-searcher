(ns adapted-drugs-searcher.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [accountant.core :as accountant]))

;; -------------------------
;; Views
(defn home-page []
  [:div
   [:h2 "Adapted drugs searcher"]
   [:text "Find adapted drugs for Virtual Medicamental Products."]
   [:form
    [:ul
     [:li [:text "VMP id:"] [:input {:type "text" :name "vmpId"}]]
     [:li
      [:text "output:"] [:br]
      [:input {:type "radio" :name "product" :value "PRODUCT"}] [:text "product"]  [:br]
      [:input {:type "radio" :name "package" :value "PACKAGE"}] [:text "package"]
      [:li [:input {:type "submit" :value "Search"}]]
     ]
    ]]
   ]
  )

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes
(secretary/defroute "/" []
                    (session/put! :current-page #'home-page))

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
