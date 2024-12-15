/**
 * @file AggiungiController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della finestra di aggiunta.
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla finestra di aggiunta. 
 */
package gruppo15.interfacciagrafica;


import gruppo15.rubrica.Contatto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class AggiungiController extends ModificaController{
    private boolean aggiunto = false;
    
    /**
     * @brief  Inizializza gli elementi grafici della finestra per aggiungere i contatti.
     * 
     * Vengono inizializati i TextField come vuoti. Non è possibile aggiungere un contatto
     * che non abbia almeno il nome o il cognome.
     * 
     * @pre Il controller deve essere associato al file fxml opportuno.
     * 
     */
    public void inizializzaAggiungi(){
        initBindings();
    }
    
    
    @FXML
    @Override
    protected void handleConferma(ActionEvent event) {
        contatto = new Contatto();
        if(aggiornaContatto()){
            aggiunto = true;
            chiudiFinestra();
        }
    }

    /**
     * @brief  Controlla se il contatto è stato aggiunto.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere aggiunto alla rubrica, 
     * altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller deve essere aggiunto , altrimenti ritorna false.
     */
    public boolean isAggiunto() {
        return aggiunto;
    }

    /**
     * @brief  Restituisce il contatto.
     * 
     * Restituisce il contatto mantenuto dal controller.
     * 
     * @post il contatto potrebbe non dover essere aggiunto, per altre informazioni vedi isAggiuntio().
     * @see isAggiunto()
     * 
     * @return Viene restituito il contatto. Se il contatto deve essere aggiunto isAggiunto() ritorna true.
     */ 
    @Override
    public Contatto getContatto(){
        return contatto;
    }
    
}
