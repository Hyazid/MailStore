/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class CourierFXMLController implements Initializable {

    @FXML
    private AnchorPane paneContainerCourrier;
    @FXML
    private Pane panelContainerCourrier;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("CourrierIN.fxml"));
            panelContainerCourrier.getChildren().removeAll();
            panelContainerCourrier.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(CourierFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void courierEntrant(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("CourrierIN.fxml"));
            panelContainerCourrier.getChildren().removeAll();
            panelContainerCourrier.getChildren().setAll(fxml);
    }

    @FXML
    private void corrierSortant(ActionEvent event) {
    }

    @FXML
    private void Divers(ActionEvent event) {
    }
    
}
