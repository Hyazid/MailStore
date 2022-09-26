/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class CalenderFXMLController implements Initializable {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private AnchorPane mainStage;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBConnection.Connection();
        
    }    

    @FXML
    private void enter(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        //get the field from the gui
        String username= userNameField.getText();
        String password = passwordField.getText();
        Boolean check = DBConnection.loginPhase(username, password);
        if(check==true){
            System.out.println("there is something");
            switchToPrincipal(event);
            Stage stage = (Stage) mainStage.getScene().getWindow();
            stage.close();
            
        }else{
            System.out.println("nothing");
        }
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        stage.close();
    }
    public void switchToPrincipal(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("principalFXML.fxml"));
        Parent root =(Parent)loader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
        
    }
    
}
