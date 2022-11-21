
package calender;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public class DeleteCourrierController implements Initializable {

    @FXML
    private Pane paneContainer;
    @FXML
    private TextField NCourrier;
    @FXML
    private  JFXComboBox<String> typeCourrier;
    @FXML
    private TextField expediteur;
    @FXML
    private TextField destinataire;
    @FXML
    private TextField dateArrivage;
    ObservableList<String> list
           = FXCollections.observableArrayList("Sortant", "Entrant", "Divers");
    @FXML
    private Label type;
    @FXML
    private TextField objet;
    @FXML
    private TextField dateEnvoi;
    @FXML
    private TextField dateArcchivage;
    @FXML
    private TextField fichier;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeCourrier.setItems(list);
        EventHandler <ActionEvent>eventt= new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                type.setText(typeCourrier.getValue()+" selectionner");
            }
            
        };
        typeCourrier.setOnAction(eventt);
        NCourrier.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
               if (t.getCode().equals(KeyCode.ENTER)) {
                System.out.println("entre key has been pressed");
                   System.out.println("-->"+typeCourrier.getValue());
                   if(typeCourrier.getValue()=="Entrant"){
                System.out.print("entre-->---");
                    try {
                        HashMap result= DBConnection.getInfoToDelPanelEntant(NCourrier.getText());
                        expediteur.setText((String)result.get("expediteur"));
                        objet.setText((String)result.get("objet"));
                        dateArcchivage.setText((String)result.get("dateArchive"));
                        dateArrivage.setText((String)result.get("dateArrive"));
                        fichier.setText((String)result.get("fichier"));
                        destinataire.setText("");
                        dateEnvoi.setText("");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else if(typeCourrier.getValue()=="Sortant"){
                System.out.print("Sortant-->--");
                    try {
                        HashMap result=DBConnection.getInfoToDelPanelSortant(NCourrier.getText());
                        destinataire.setText((String)result.get("destinataire"));
                        dateArcchivage.setText((String)result.get("dateArchive"));
                        objet.setText((String)result.get(("objet")));
                        dateEnvoi.setText((String)result.get("dateEnvoi"));
                        fichier.setText((String)result.get("fichier"));
                        expediteur.setText("");
                        dateArrivage.setText("");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else if(typeCourrier.getValue()=="Divers"){
                System.out.print("Divers-->--");
                    try {
                        HashMap result=DBConnection.getInfoToDelPanelDivers(NCourrier.getText());
                        destinataire.setText((String)result.get("destinataire"));
                        dateArcchivage.setText((String)result.get("dateArchive"));
                        objet.setText((String)result.get(("objet")));
                        dateArrivage.setText((String)result.get("dateArrive"));
                        fichier.setText((String)result.get("fichier"));
                        expediteur.setText((String)result.get("expediteur"));
                        dateEnvoi.setText("");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteCourrierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }else{
                type.setText("Choisissez le type de courrier");
            }
            }
            }
        });
        
        
    }    

    @FXML
    private void supprimer(ActionEvent event) throws ClassNotFoundException, SQLException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Suppression");
        String s = "Vous les vous vraiment supprimé ce courrier !";
        alert.setContentText(s);
        Optional<ButtonType> result = alert.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            System.out.println("ok button pressed");
                if(typeCourrier.getValue()=="Entrant"){
                    DBConnection.supprimerCourrierEntrant(NCourrier.getText());
                }
                else if(typeCourrier.getValue()=="Sortant"){
                    DBConnection.getInfoToDelPanelSortant(NCourrier.getText());
                }
                else if(typeCourrier.getValue()=="Divers"){
                    DBConnection.supprimerCourrierDivers(NCourrier.getText());
                }
                else{
                    
                }
            }
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }


    @FXML
    private void dateEnvoi(ActionEvent event) {
    }

    public void actionPerformed(ActionEvent e){
        
    }

    @FXML
    private void search(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            if(typeCourrier.getValue()=="Entrant"){
                System.out.print("entre-->");
            }
            else if(typeCourrier.getValue()=="Sortant"){
                System.out.print("Sortant-->");
            }
            else if(typeCourrier.getValue()=="Divers"){
                System.out.print("Divers-->");
            }else{
                type.setText("Choisissez le type de courrier");
            }
        }
    }
  
}
