
package calender;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.cell.TextFieldTableCell;


public class CourrieroutController implements Initializable {

    @FXML
    private TableView<CourrierOUT> courrierTable;
    @FXML
    private Pane paneOption;
    @FXML
    private TableColumn<CourrierOUT, String> numeroCourrier;
    @FXML
    private TableColumn<CourrierOUT, String > destinataire;
    @FXML
    private TableColumn<CourrierOUT, String > objet;
    @FXML
    private TableColumn<CourrierOUT,String> dateEnvoi;
    @FXML
    private TableColumn<CourrierOUT, String > dateArchivage;
    @FXML
    private TableColumn<CourrierOUT, String > cheminDossier;
    final ObservableList<CourrierOUT> data= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numeroCourrier.setCellValueFactory(new PropertyValueFactory<>("numeroCourrier"));
        destinataire.setCellValueFactory(new PropertyValueFactory<>("destinataire"));
        objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        dateEnvoi.setCellValueFactory(new PropertyValueFactory<>("dateEnvoi"));
        dateArchivage.setCellValueFactory(new PropertyValueFactory<>("dateArchivage"));
        cheminDossier.setCellValueFactory(new PropertyValueFactory<>("cheminDossier"));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con ;
             
            con= DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
           String sql= "SELECT * FROM courier.courrierout";
           java.sql.Statement stm=con.createStatement();
           java.sql.ResultSet res= stm.executeQuery(sql);
           while(res.next()){
               data.add(new CourrierOUT(res.getString("id_courrier"),res.getString("destinataire"),res.getString("objet"),
                    res.getString("date_archivage"),res.getString("date_envoi"),res.getString("fileName")));
           }
           courrierTable.setItems(data);
          
            courrierTable.setEditable(true);
           
            numeroCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
            
            destinataire.setCellFactory(TextFieldTableCell.forTableColumn());
            
            dateArchivage.setCellFactory(TextFieldTableCell.forTableColumn());
                
            cheminDossier.setCellFactory(TextFieldTableCell.forTableColumn());  
            
            dateEnvoi.setCellFactory(TextFieldTableCell.forTableColumn()); 
            
            objet.setCellFactory(TextFieldTableCell.forTableColumn());
        }catch(Exception e){
            System.out.print("there is an error ");
        }
    }    

    @FXML
    private void ajouterCourrier(ActionEvent event) throws IOException {
        FXMLLoader parent = new FXMLLoader(getClass().getResource("AjouterCourrierSortant.fxml"));
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
    private void imprimer(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void supprimerCourrier(ActionEvent event) throws IOException {
         FXMLLoader parent = new FXMLLoader(getClass().getResource("deleteCourrier.fxml"));
        Parent root = (Parent)parent.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void onEditChangeNumero(TableColumn.CellEditEvent<CourrierOUT, String> event) {
    }

    @FXML
    private void onEditChangeDestinataire(TableColumn.CellEditEvent<CourrierOUT, String> event) throws ClassNotFoundException, SQLException {
        CourrierOUT courrier=event.getRowValue();
        courrier.setDestinataire(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierout SET destinataire='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
        
    }

    @FXML
    private void onEditChangeObjet(TableColumn.CellEditEvent<CourrierOUT, String> event) throws ClassNotFoundException, SQLException {
            CourrierOUT courrier=event.getRowValue();
            courrier.setObjet(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierout SET objet='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeEnvoi(TableColumn.CellEditEvent<CourrierOUT, String> event) throws ClassNotFoundException, SQLException {
            CourrierOUT courrier=event.getRowValue();
            courrier.setDateEnvoi(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierout SET date_envoi='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeArchive(TableColumn.CellEditEvent<CourrierOUT, String> event) throws ClassNotFoundException, SQLException {
            CourrierOUT courrier=event.getRowValue();
            courrier.setDateArchivage(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierout SET date_archivage='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeFile(TableColumn.CellEditEvent<CourrierOUT, String> event) throws ClassNotFoundException, SQLException {
               CourrierOUT courrier=event.getRowValue();
            courrier.setCheminDossier(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierout SET fileName='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
    }
    
}
