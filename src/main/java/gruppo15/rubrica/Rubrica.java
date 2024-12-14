/**
 * @file Rubrica.java
 * @brief Questo file contiene i metodi necessari all'avvio dell'applicazione.
 * 
 * Questo file è la classe principale che gestisce l'applicazione JavaFX dedicata alla rubrica.
 * 
 */
package gruppo15.rubrica;

import gruppo15.interfacciagrafica.RubricaController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Rubrica extends Application {
    private ElencoContatti contatti;
    
/**
 * @brief  Caricamento della rubrica.
 * 
 * Carica il file FXML e crea la finestra per la gestione della rubrica.
 * 
 * @param[in] primaryStage Oggetto principale che viene creato e mostrato all'avvio dell'applicazione.
 */    
    @Override
    public void start(Stage primaryStage) throws IOException {
        contatti = new ElencoContatti();
            Parent root;
            FXMLLoader loader = new FXMLLoader(Rubrica.class.getResource("RubricaView.fxml"));
            RubricaController controller = new RubricaController();
            loader.setController(controller);
            root = loader.load();
            controller.inizializzaRubrica(contatti);

            Scene scene = new Scene(root, 462, 733);
            
            primaryStage.setTitle("Rubrica");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        
    }

/**
 * @brief Avvia l'applicazione JavaFX.
 * 
 * 
 * @param[in] args Argomenti da linea di comando.
 */ 
    public static void main(String[] args) {
        
    }
    
}
