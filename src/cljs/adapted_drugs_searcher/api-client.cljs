(ns adapted-drugs-searcher.api-client
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(defn adapted-drugs [form-params handler]
  (go (handler (<! (http/post
                     "http://master.dockersw.vidal.net/rest/api/adapted-drugs"
                     {
                      :content-type "text/xml"
                      :form-params  {
                                     :vmpId          "511"
                                     :outputDrugType "PRODUCT"
                                     ;:facet "INDICATION|Angor"
                                     }
                      })))))
