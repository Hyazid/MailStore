/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class AjouterCourrierSortantController implements Initializable {

    @FXML
    private TextField objet;

    @FXML
    private TextField dateArrchive;
    @FXML
    private TextField addFile;
    @FXML
    private TextField destinataire;
    @FXML
    private BorderPane mainStage;
    @FXML
    private TextField dateEnvoi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterFichier(ActionEvent event) {
         FileChooser fil_chooser = new FileChooser();
        File file;
        Stage stage = (Stage) mainStage.getScene().getWindow();
        file = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
                  System.out.println(file.getAbsolutePath());
                   addFile.setText(file.getAbsolutePath());
                }
    }

    @FXML
    private void AjouterCourrierSortant(ActionEvent event) throws SQLException, ClassNotFoundException {
        String destinatairee = destinataire.getText();
          String objetIn=objet.getText();
          String date_envoi= dateEnvoi.getText();
          String dateArchivage= dateArrchive.getText();
          String fileText= addFile.getText();
          DBConnection.ajouterCourrierSortantDBstatic(destinatairee, objetIn, dateArchivage, date_envoi, fileText);
          System.out.println("ok");
    }  

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        stage.close();
    }
    
}
