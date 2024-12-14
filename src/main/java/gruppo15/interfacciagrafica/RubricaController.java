/**
 * @file RubricaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della rubrica
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla rubrica
 * 
 */
package gruppo15.interfacciagrafica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gruppo15.rubrica.ElencoContatti;
import javafx.scene.control.Label;


public class RubricaController extends TabellaController {
    @FXML
    private Label numeroContatti;
    
    /**
     * @brief  Inizializza gli elementi grafici della finestra principale della rubrica.
     * 
     * Viene inizializzata la tabella della finestra principale come vuota. 
     * La tabella avrà come colonne solo i campi nome e cognome degli oggetti Contatto che conterrà.
     * 
     * @pre Il controller deve essere associato al file fxml opportuno.
     * @post La tabella viene creata vuota.
     * 
     * @param[in] elenco L'elenco i cui contatti verranno aggiunti alla tabella.
     * 
     */
    public void inizializzaRubrica(ElencoContatti elenco) {
        
    }
    
    @FXML
    private void handleAggiungi(ActionEvent event) {
        
    }
    
    @FXML
    private void handleSalva(ActionEvent event){
        
    }
    
    @FXML
    private void handleCarica(ActionEvent event){
        
    }
    
    
    @FXML
    private void handleRicerca(ActionEvent event){
        
    }
    
}
