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
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class TabellaController {
    @FXML
    protected TableView<Contatto> tabella;
    @FXML
    protected TableColumn<Contatto, String> nomeCln;
    @FXML
    protected TableColumn<Contatto, String> cognomeCln;
    
    protected ElencoContatti elenco;
    
    protected void inizializzaTabella(ElencoContatti lista){
        this.elenco=lista;
        tabella.setItems(elenco.getElencoOrdinato());
        nomeCln.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cognomeCln.setCellValueFactory(new PropertyValueFactory<>("cognome"));
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
        return this.elenco;
    }
    
    
    @FXML
    protected void handleContattoSelezionato() throws IOException{
        Contatto contatto = tabella.getSelectionModel().getSelectedItem();
        if(contatto!=null){
            mostraDettagli(contatto);
            aggiornaTabella();
        }
    }
        
    
    
    protected void mostraDettagli(Contatto contatto) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VisualizzaView.fxml"));
        VisualizzaController controller = new VisualizzaController();
        loader.setController(controller);
        Parent root = loader.load();
        controller.inizializzaVisualizza(contatto);
        mostraFinestra("Dettagli contatto",root,619,396);
        if(controller.isEliminato()){
            gestisciEliminazioneContatto(contatto);
            aggiornaTabella();
        }
        if(controller.isModificato()){
            elenco.modificaContatto(contatto,controller.getContatto());
            aggiornaTabella();
        }
        
    }
    protected void mostraFinestra(String titolo,Parent root, double larg, double ht){
        Stage stage = new Stage();
        stage.setTitle(titolo);
        stage.setScene(new Scene(root,larg,ht));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
        
    
    
    protected void aggiornaTabella(){
        tabella.refresh();
    }
        
        protected void gestisciEliminazioneContatto(Contatto contatto){
        elenco.removeContatto(contatto);
    }
}
