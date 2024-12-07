/**
 * @file RicercaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della finestra di ricerca.
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla finestra di ricerca.
 */
package InterfacciaGrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class RicercaController extends TabellaController{
    
    /**
     * @brief Inizializza gli elementi grafici della finestra di ricerca
     * 
     * Il metodo inizializza la tabella della finestra di ricerca come vuota.
     * La tabella avrà come colonne solo i campi nome e cognome degli oggetti Contatto che conterrà.
     * 
     * @pre Il controller deve essere associato al file fxml opportuno.
     * @post La tabella viene creata vuota.
     * 
     * @param[in] lista L'elenco in cui deve fare la ricerca.
     */
    public void inizializzaRicerca(ElencoContatti lista){
        
    }
    
    @FXML
    private TextField ricerca;
    
    

    @FXML
    private void handleRicerca(ActionEvent ev){
        
    }
    
    @FXML
    private void handleEsci(ActionEvent ev){
        
    }
}
