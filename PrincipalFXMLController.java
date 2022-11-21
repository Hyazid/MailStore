
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


public class PrincipalFXMLController implements Initializable {

    @FXML
    private Pane paneContainer;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void onCourrier(ActionEvent event) throws IOException {
       //change to personnel pane
            Parent fxml = FXMLLoader.load(getClass().getResource("courierFXML.fxml")); 
            paneContainer.getChildren().removeAll();
            paneContainer.getChildren().setAll(fxml);
        
    }
    
}
