/**
 * @file RubricaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della rubrica
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla rubrica
 * 
 */
package gruppo15.interfacciagrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import gruppo15.rubrica.ElencoContatti;
import gruppo15.rubrica.IOFile;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import gruppo15.rubrica.Rubrica;
import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;


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
        inizializzaTabella(elenco);
        numeroContatti.textProperty().bind(Bindings.size(elenco.getElencoOrdinato()).asString());
    }
    
    @FXML
    private void handleAggiungi(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaView.fxml"));
        AggiungiController controller = new AggiungiController();
        loader.setController(controller);
        root = loader.load();
        controller.inizializzaAggiungi();
        mostraFinestra("Aggiungi contatto",root,619,369);
        if(controller.isAggiunto()){
            elenco.addContatto(controller.getContatto());
        }
        aggiornaTabella();
    }
    
    @FXML
    private void handleSalva(ActionEvent event) throws IOException{
        File file = scegliFile();
        if(file!=null){
            IOFile.salva(elenco,file.getCanonicalPath());
        }
    }
    
    @FXML
    private void handleCarica(ActionEvent event) throws Exception{
        File file = scegliFile();
        if(file!=null){
            ElencoContatti lista = IOFile.carica(file.getCanonicalPath());
            inizializzaRubrica(lista);
            aggiornaTabella();
        }
    }
    
    
    @FXML
    private void handleRicerca(ActionEvent event) throws IOException{
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RicercaView.fxml"));
        RicercaController controller = new RicercaController();
        loader.setController(controller);
        root = loader.load();
        controller.inizializzaRicerca(elenco);
        mostraFinestra("Ricerca",root,462,698);
        this.elenco=controller.getElenco();
        aggiornaTabella();
    }
    
    private File scegliFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Scegli il file");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("File csv","*.csv"),
            new FileChooser.ExtensionFilter("Tutti i file","*.*"));
        File selectedFile = fileChooser.showOpenDialog(tabella.getScene().getWindow());
        return selectedFile;
    }
}
