/**
 * @file TabellaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della tabella
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla tabella
 *
 */
package gruppo15.interfacciagrafica;

import gruppo15.rubrica.Contatto;
import gruppo15.rubrica.ElencoContatti;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class TabellaController {
    @FXML
    protected TableView<Contatto> tabella;
    @FXML
    protected TableColumn<Contatto, String> nomeCln;
    @FXML
    protected TableColumn<Contatto, String> cognomeCln;
    
    protected ElencoContatti elenco;
    
    protected void inizializzaTabella(ElencoContatti lista){
        
    }
    
    /**
     * @brief Restituisce l'elenco contatti della tabella.
     * 
     * Il metodo restituisce l'oggetto ElencoContatti associato alla tabella.
     * 
     * @post L'elenco non conterrà contatti se non sono stati aggiunti alla tabella.
     * 
     * @return  Viene restituito l'elenco dei contatti presenti all'interno della tabella
     */
    public ElencoContatti getElenco() {
        
    }
    
    protected void setElenco(ElencoContatti lista){
        
    }
    
    @FXML
    protected void handleContattoSelezionato(){
        
    }
        
    
    
    protected void mostraDettagli(Contatto contatto){
        
    }
        
    
    
    protected void aggiornaTabella(){
        
    }
        
    
}
