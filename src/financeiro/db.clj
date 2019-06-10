(ns financeiro.db)

(def registros (atom []))

(defn transacoes [] @registros)

(defn registrar [transacao]
  (let [colecao-atualizada (swap! registros conj transacao)]
    (merge transacao {:id (count colecao-atualizada)})))

(defn limpar []
  (reset! registros []))