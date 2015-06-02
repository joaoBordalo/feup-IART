(import nrc.fuzzy.jess.*)
(import nrc.fuzzy.*)

(deftemplate Estado-metereologia "descriao generica do estado metereologico" 
(slot condicao) (slot intensidade) (slot temperatura) (slot hora)
)

 (defglobal ?*fuzzy-temperatura* = (new nrc.fuzzy.FuzzyVariable "temperatura" 0.0 33.0 "C"))
 (defglobal ?*fuzzy-hora* = (new nrc.fuzzy.FuzzyVariable "hora" 0.0 24.0 "h"))
 
 
 (defrule init-fuzzy-Temperature-Hour
	?fact <- (initial-fact)
  => 
   (load-package nrc.fuzzy.jess.FuzzyFunctions) 
   ;; terms for the temperature Fuzzy Variable 
   ;;(?*fuzzy-temperatura* addTerm "calor" (new SFuzzySet 25.0 33.0))
   ;;(?*fuzzy-temperatura* addTerm "ameno" (new PIFuzzySet 18.0 28.0))
   ;;(?*fuzzy-temperatura* addTerm "frio" (new ZFuzzySet 12.0 20.0))
   ;;(assert (theTemp (new FuzzyValue ?*fuzzy-temperatura* "frio"))) 
   
   ;; terms for the hour Fuzzy Variable 
   ;;(?*fuzzy-hora* addTerm "manha" (new SFuzzySet 0.0 13.0))
   ;;(?*fuzzy-hora* addTerm "tarde" (new PIFuzzySet 12.0 20.0))
   ;;(?*fuzzy-hora* addTerm "noite" (new ZFuzzySet 19.0 24.0))
   ;;(assert (theHour (new FuzzyValue ?*fuzzy-hora* "manha"))) 
  
  (bind ?xCalor  (create$ 25.0 33.0)) 
   (bind ?yCalor  (create$ 0.0 1.0)) 
   (bind ?xAmeno  (create$ 18.0 23.0 28.0)) 
   (bind ?yAmeno  (create$ 0.0 1.0 0.0)) 
   (bind ?xFrio (create$ 0.0 15.0)) 
   (bind ?yFrio (create$ 1.0 0.0)) 
   ;; terms for the temperature Fuzzy Variable 
   (?*fuzzy-temperatura* addTerm "calor" ?xCalor ?yCalor 2) 
   (?*fuzzy-temperatura* addTerm "frio" ?xFrio ?yFrio 2) 
   (?*fuzzy-temperatura* addTerm "ameno" ?xAmeno ?yAmeno 2) 
   
  (bind ?xManha  (create$ 0.0 13.0)) 
  (bind ?yManha  (create$ 1.0 0.0)) 
  (bind ?xTarde  (create$ 12.0 15.0 20.0)) 
  (bind ?yTarde  (create$ 0.0 1.0 0.0)) 
  (bind ?xNoite (create$ 19.0 24.0)) 
  (bind ?yNoite (create$ 0.0 1.0)) 
   ;; terms for the hour Fuzzy Variable 
  (?*fuzzy-hora* addTerm "manha" ?xManha ?yManha 2) 
  (?*fuzzy-hora* addTerm "tarde" ?xTarde ?yTarde 3) 
  (?*fuzzy-hora* addTerm "noite" ?xNoite ?yNoite 2) 

)


;(defrule envia-facebook
;	
;	=>
;	(assert (envia-facebook oquequiseres))
;	(printout t "A enviar para o Facebook..." crlf)
;)	

(defrule email-guardachuva
        (Estado-metereologia (condicao chuva))
        =>
        (assert (envia-email guardachuva))
)

(defrule envia-email-generico 
        ?mail <- (envia-email ?tipo)
        =>
        (retract ?mail)
)


(defrule bom-tempo
        (Estado-metereologia (condicao sol) (intensidade alta) (temperatura calor)(hora manha))
        ;;(theTemp ?t&:(fuzzy-match ?t "calor"))
        ;;(theHour ?h&:(fuzzy-match ?h "manha"))
        =>
        (assert (janelas abrir))
        (assert (luzes 0))
        (assert (envia-facebook Vai Estar Um Dia Quente))
        (printout t "dia quente" crlf)
        )

(defrule noite 
        (Estado-metereologia  (hora noite))
        =>
        (assert (janelas fechar))
        (printout t "Esta noite" crlf)
        )


(defrule bom-tempo-tarde
        (condicao sol)
        (or (intensidade-sol media) (intensidade-sol baixa))
        =>
        (assert (luzes 3))
        (printout t "Fim do dia " crlf)
        )
        
(defrule ligar-ac
		(temperatura calor)
		
		=>
		(assert (ac ligado))
		(printout t "Ligar Ar-condicionado!" crlf)
)

(defrule desligar-ac
		(temperatura frio)
		
		=>
		(assert (ac desligado))
		(printout t "Desligar Ar-condicionado!" crlf)
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
        (printout t "Fechar Janelas!" crlf)
)

(defrule mudar-luzes
        ?luz <-(luzes ?valor)
        =>
        (printout t "a ajustar luzes para " ?valor crlf)
        (retract ?luz)
        )




