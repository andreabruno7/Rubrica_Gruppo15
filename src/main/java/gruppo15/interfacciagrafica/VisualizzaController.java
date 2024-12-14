/**
 * @file VisualizzaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della finestra di visualizzazione.
 * 
 * Questo file contiene i metodi e gli attributi per la gestione della visualizzazione delle informazioni di un contatto
 * 
 */
package gruppo15.interfacciagrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import gruppo15.rubrica.Contatto;

public class VisualizzaController {
    @FXML
    private Label nomeLbl;
    @FXML
    private Label cognomeLbl;
    @FXML
    private Label primoNumeroLbl;
    @FXML
    private Label secondoNumeroLbl;
    @FXML
    private Label terzoNumeroLbl;
    @FXML
    private Label primaMailLbl;
    @FXML
    private Label secondaMailLbl;
    @FXML
    private Label terzaMailLbl;
    
    private Contatto contatto;
    private boolean modificato;
    private boolean eliminato;
    
    @FXML
    private void handleEsci(ActionEvent event) {
        
    }
    
    @FXML
    private void handleModifica(ActionEvent event) {
        
    }
    
    @FXML
    private void handleElimina(ActionEvent event) {
        
    }
    
    /**
     * @brief Inizializza gli elementi grafici della finestra di visualizzazione.
     * 
     * Il metodo inizializza le Label relative alle informazioni del contatto con i campi del contatto passato come parametro.
     * 
     * @pre Il controller deve essere associato al file fxml opportuno.
     * @post Vengono visualizzate nella finestra tutte le informazioni del contatto.
     * 
     * @param[in] contatto Il contatto da visualizzare.
     * 
     */
    public void inizializzaVisualizza(Contatto contatto) {
        
    }
    
    /**
     * @brief  Controlla se il contatto è stato modificato.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
     */
    public boolean isModificato(){
          
    }
   
    /**
     * @brief  Controlla se il contatto è stato eliminato.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere eliminato , altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller deve essere eliminato , altrimenti ritorna false.
     */
    public boolean isEliminato(){
        
    }
    
    
}
