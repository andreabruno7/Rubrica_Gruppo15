/**
 * @file ModificaController.java
 * @brief  Questo file contiene i metodi e gli attributi per la gestione della finestra di modifica.
 * 
 * Il file mantiene la logica di gestione degli eventi associati alla finestra di modifica e mantiene il contatto da modificare.
 */
package gruppo15.interfacciagrafica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import gruppo15.rubrica.Contatto;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

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
    @FXML
    protected Button conferma;
    
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
        this.contatto = contatto;
        nomeField.setText(contatto.getNome());
        cognomeField.setText(contatto.getCognome());
        primoNumeroField.setText(contatto.getNumeroAt(0));
        secondoNumeroField.setText(contatto.getNumeroAt(1));
        terzoNumeroField.setText(contatto.getNumeroAt(2));
        primaMailField.setText(contatto.getEmailAt(0));
        secondaMailField.setText(contatto.getEmailAt(1));
        terzaMailField.setText(contatto.getEmailAt(2));
        initBindings();
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
        return contatto;
    }
    
    /**
    * @brief  Controlla se il contatto è stato modificato.
    * 
    * Il metodo ritorna true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
    * 
    * @return Viene restituito true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
    */    
    public boolean isModificato() {
        return modificato;
    }
    
    @FXML
    protected void handleEsci(ActionEvent event) {
        chiudiFinestra();
    }
    
    @FXML
    protected void handleConferma(ActionEvent event) {
        if(aggiornaContatto()){
            modificato = true;
            chiudiFinestra();
        }
    }
    
    protected void mostraErrore(String titolo,String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        ButtonType bottoneOk = new ButtonType("Ok");
        alert.getButtonTypes().setAll(bottoneOk);
        alert.show();
    }
    
    protected boolean aggiornaContatto(){
        contatto.setNome(nomeField.getText());
        contatto.setCognome(cognomeField.getText());
        try {
            contatto.setNumeroAt(0, primoNumeroField.getText());
            contatto.setNumeroAt(1, secondoNumeroField.getText());
            contatto.setNumeroAt(2, terzoNumeroField.getText());
        } catch (Exception ex) {
            mostraErrore("Errore nell'inserimento del numero","Il numero inserito non è valido");
            return false;
        }
        try {
            contatto.setEmailAt(0, primaMailField.getText());
            contatto.setEmailAt(1, secondaMailField.getText());
            contatto.setEmailAt(2, terzaMailField.getText());
        } catch (Exception ex) {
            mostraErrore("Errore nell'inserimento della mail","La mail inserita non è valida");
            return false;
        }
        return true;
    }
    
    protected void chiudiFinestra(){
        Stage stage = (Stage) ((nomeField).getScene().getWindow());
        stage.close();
    }
    
    protected void initBindings(){
        BooleanBinding binding = nomeField.textProperty().isEmpty().and(cognomeField.textProperty().isEmpty());
        conferma.disableProperty().bind(binding);
    }
}
