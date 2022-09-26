/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AjouterCourrierController implements Initializable {

    @FXML
    private TextField expediteur;
    @FXML
    private TextField objet;
    @FXML
    private TextField dateAr;
    @FXML
    private TextField dateArrchive;
    @FXML
    private BorderPane mainStage;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
   

    @FXML
    private void AjouterCourrier(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException {
          String expediterur = expediteur.getText();
          String objetIn=objet.getText();
          String date_arr= dateAr.getText();
          String dateArchivage= dateArrchive.getText();
          //Date Darriver=new SimpleDateFormat("dd/MM/yyyy").parse(date_arr);
         // Date Darchivage=new SimpleDateFormat("dd/MM/yyyy").parse(dateArchivage);
       DBConnection.ajouterCourrierDBstatic(expediterur,objetIn, date_arr,dateArchivage);
        System.out.println("ok");
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ajouterFichier(ActionEvent event) {
        FileChooser fil_chooser = new FileChooser();
        File file;
        Stage stage = (Stage) mainStage.getScene().getWindow();
        file = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
                  System.out.println("path path path ");
                }
    }
    
}
