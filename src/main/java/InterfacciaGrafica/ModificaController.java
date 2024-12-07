/**
 * @file ModificaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della finestra di modifica.
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla finestra di modifica e mantiene il contatto da modificare.
 */
package InterfacciaGrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ModificaController {
    @FXML
    protected TextField nomeField;
    @FXML
    protected TextField cognomeField;
    @FXML
    protected TextField primoNumeroField;
    @FXML
    protected TextField secondoNumeroField;
    @FXML
    protected TextField terzoNumeroField;
    @FXML
    protected TextField primaMailField;
    @FXML
    protected TextField secondaMailField;
    @FXML
    protected TextField terzaMailField;
    
    protected Contatto contatto;
    private boolean modificato = false;


    /**
     * @brief  Inizializza gli elementi grafici della finestra di modifica.
     * 
     * Viene inizializzato il contatto da modificare e vengono mostrate le sue informazioni
     * nei TextField. Il contatto che viene passato non è stato ancora modificato.
     * 
     * @pre Il controller deve essere associato al file fxml opportuno.
     * @post Vengono visualizzate nella finestra tutte le informazioni del contatto.
     * @post Queste informazioni sono modificabili.
     * 
     * @param[in] contatto il contatto da modificare.
     */
    public void inizializzaModifica(Contatto contatto){
        
    }
    
    /**
     * @brief  Restituisce il contatto.
     * 
     * Restituisce il contatto mantenuto dal controller.
     * 
     * @post il contatto potrebbe non essere modificato, per altre informazioni vedi isModificato().
     * @see isModificato()
     * 
     * @return Viene restituito il contatto. Se il contatto deve essere modificato isModificato() ritorna true.
     */    
    public Contatto getContatto(){
        
    }
    
    /**
    * @brief  Controlla se il contatto è stato modificato.
    * 
    * Il metodo ritorna true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
    * 
    * @return Viene restituito true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
    */    
    public boolean isModificato() {
        
    }
    
    @FXML
    protected void handleEsci(ActionEvent event) {
        
    }
    
    @FXML
    protected void handleConferma(ActionEvent event) {
        
    }
}
