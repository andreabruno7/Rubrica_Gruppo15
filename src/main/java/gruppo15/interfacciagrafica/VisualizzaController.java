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
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

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
        Stage stage = (Stage) nomeLbl.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleModifica(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(VisualizzaController.class.getResource("ModificaView.fxml"));
        ModificaController controller = new ModificaController();
        loader.setController(controller);
        Parent root = loader.load();
        controller.inizializzaModifica(contatto);
        Stage stage = new Stage();
        stage.setTitle("Modifica contatto");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        modificato = controller.isModificato();
        if(modificato){
            inizializzaVisualizza(controller.getContatto());
        }
    }
    
    @FXML
    private void handleElimina(ActionEvent event) {
        eliminato = mostraConferma();
        if(eliminato){
            Stage stage = (Stage) nomeLbl.getScene().getWindow();
            stage.close();
        }
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
            this.contatto = contatto;
    if (contatto.getNome() != null) {
        nomeLbl.setText(contatto.getNome());
    } else {
        nomeLbl.setText(""); 
    }
    if (contatto.getCognome() != null) {
        cognomeLbl.setText(contatto.getCognome());
    } else {
        cognomeLbl.setText("");
    }
    for (int i = 0; i < 3; i++) {
        String numero = contatto.getNumeroAt(i);
        if (numero != null) {
            switch (i) {
                case 0:
                    primoNumeroLbl.setText(numero);
                    break;
                case 1:
                    secondoNumeroLbl.setText(numero);
                    break;
                case 2:
                    terzoNumeroLbl.setText(numero);
                    break;
                default:
                    break;
            }
        } else {
            switch (i) {
                case 0:
                    primoNumeroLbl.setText("");
                    break;
                case 1:
                    secondoNumeroLbl.setText("");
                    break;
                case 2:
                    terzoNumeroLbl.setText("");
                    break;
                default:
                    break;
            }
        }
    }
    for (int i = 0; i < 3; i++) {
        String email = contatto.getEmailAt(i);
        if (email != null) {
            switch (i) {
                case 0:
                    primaMailLbl.setText(email);
                    break;
                case 1:
                    secondaMailLbl.setText(email);
                    break;
                case 2:
                    terzaMailLbl.setText(email);
                    break;
                default:
                    break;
            }
        } else {
            switch (i) {
                case 0:
                    primaMailLbl.setText("");
                    break;
                case 1:
                    secondaMailLbl.setText("");
                    break;
                case 2:
                    terzaMailLbl.setText("");
                    break;
                default:
                    break;
            }
        }
    }
    }
    
    /**
     * @brief  Controlla se il contatto è stato modificato.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller deve essere modificato , altrimenti ritorna false.
     */
    public boolean isModificato(){
          return modificato;
    }
   
    /**
     * @brief  Controlla se il contatto è stato eliminato.
     * 
     * Il metodo ritorna true se il contatto mantenuto dal controller deve essere eliminato , altrimenti ritorna false.
     * 
     * @return Viene restituito true se il contatto mantenuto dal controller deve essere eliminato , altrimenti ritorna false.
     */
    public boolean isEliminato(){
        return eliminato;
    }

    public Contatto getContatto() {
        return contatto;
    }
    
    private boolean mostraConferma(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma eliminazione");
        alert.setHeaderText(null);
        alert.setContentText("Sei sicuro di voler eliminare il contatto?");
        ButtonType bottoneSi = new ButtonType("Sì");
        ButtonType bottoneNo = new ButtonType("No");
        alert.getButtonTypes().setAll(bottoneSi,bottoneNo);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == bottoneSi;
    }
    
    
}
