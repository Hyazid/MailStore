
package calender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


 
public class CourrierINController implements Initializable {

    @FXML
    private Pane paneOption;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajouterCourrier(ActionEvent event) throws IOException {
        FXMLLoader parent = new FXMLLoader(getClass().getResource("AjouterCourrier.fxml"));
        Parent root = (Parent)parent.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void modifierCourier(ActionEvent event) {
    }

    @FXML
    private void imprimer(ActionEvent event) {
    }

    @FXML
    private void supprimerCourrier(ActionEvent event) {
    }
    
}
