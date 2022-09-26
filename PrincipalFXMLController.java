/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class PrincipalFXMLController implements Initializable {

    @FXML
    private Pane paneContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCourrier(ActionEvent event) throws IOException {
       //change to personnel pane
            Parent fxml = FXMLLoader.load(getClass().getResource("courierFXML.fxml")); 
            paneContainer.getChildren().removeAll();
            paneContainer.getChildren().setAll(fxml);
        
    }
    
}
