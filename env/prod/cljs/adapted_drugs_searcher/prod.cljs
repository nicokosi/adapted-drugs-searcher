(ns adapted-drugs-searcher.prod
  (:require [adapted-drugs-searcher.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
