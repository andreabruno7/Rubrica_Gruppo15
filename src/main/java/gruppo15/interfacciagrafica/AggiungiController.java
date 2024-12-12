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
    
    @FXML
    @Override
    protected void handleConferma(ActionEvent event) {
        
    }

    /**
     * @brief  Controlla se il contatto è stato aggiunto.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere aggiunto alla rubrica, 
     * altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller è stato aggiunto , altrimenti ritorna false.
     */
    public boolean isAggiunto() {
        
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
        
    }
    
}
