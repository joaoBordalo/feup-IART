(deftemplate Previsao-metereologica
        "descriao generica do estado metereologico"
        (slot condicao)
        (slot intensidade)
        (slot temperatura)
        (slot dia)
        (slot hora)
        (slot minuto)
)


;(deffacts factostempo
 ;      (Previsao-metereologica (condicao sol)
  ;                            (intensidade alta)
   ;                          (temperatura 30)
    ;                        (dia 12)
     ;                      (hora 23)
      ;                    (minuto 10)
 ;)
;)


(defrule email-guardachuva
        (condicao chuva)
        =>
        (assert (envia-email guardachuva))
        (printout t "a enviar email" crlf)
)

(defrule envia-email-generico 
        ?mail <- (envia-email ?tipo)
        =>
        (printout t "enviei email sobre " ?tipo crlf)
        (retract ?mail)
)



(defrule bom-tempo
        (Previsao-metereologica (condicao sol) (intensidade alta) {hora <= 20})
        =>
        (assert (janelas abrir))
        (assert (luzes 0))
        )

(defrule noite 
        (Previsao-metereologica  {hora > 20})
        =>
        (assert (janelas fechar))
        (printout t "esta noite" crlf)
        )


(defrule bom-tempo-tarde
        (condicao sol)
        (or (intensidade-sol media) (intensidade-sol baixa))
        =>
        (assert (luzes 3))
        (printout t "fim do dia " crlf)
        )

(defrule abrir-janelas
        ?janelas <- (janelas abrir)
        =>
        (retract ?janelas)
        (printout t "Abrir Janelas!" crlf)
)
(defrule fechar-janelas
        ?janelas <- (janelas fechar)
        =>
        (retract ?janelas)
        (printout t "fechar Janelas!" crlf)
)

(defrule mudar-luzes
        ?luz <-(luzes ?valor)
        =>
        (printout t "a ajustar luzes para " ?valor crlf)
        (retract ?luz)
        )



