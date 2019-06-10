(ns financeiro.db-test
  (:require [midje.sweet :refer :all]
            [financeiro.db :refer :all]))

(facts "Guarda uma transacao num átomo"
       (against-background [(before :facts (limpar))]
       (fact "a transação é o primeiro registro"
             (registrar {:valor 7 :tipo "receita"}) => {:id 1 :valor 7 :tipo "receita"}
             (count (transacoes)) => 1)
       (fact "a coleção de transações inicia vazia"
             (count (transacoes)) => 0)))