
package calender;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DiversController implements Initializable {

    @FXML
    private TableView<CourrierDiver> courrierTable;
    
    
    final ObservableList<CourrierDiver> data = FXCollections.observableArrayList();
   /* @FXML
    private TableColumn<?, ?> objet;
    @FXML
    private TableColumn<?, ?> expediteur;*/
    @FXML
    private Pane paneOption;
    @FXML
    private TableColumn<CourrierDiver, String> numeroCourrier;
    @FXML
    private TableColumn<CourrierDiver, String> destinataire;
    @FXML
    private TableColumn<CourrierDiver, String> objet;
    @FXML
    private TableColumn<CourrierDiver, String> expediteur;
    @FXML
    private TableColumn<CourrierDiver, String> dateArchivage;
    @FXML
    private TableColumn<CourrierDiver, String> cheminDossier;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            numeroCourrier.setCellValueFactory(new PropertyValueFactory<>("numeroCourrier")) ;
            destinataire.setCellValueFactory(new PropertyValueFactory<>("destinataire"));
            objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
            expediteur.setCellValueFactory(new PropertyValueFactory<>("expediteur"));
            dateArchivage.setCellValueFactory(new PropertyValueFactory<>("dateArchivage"));
            cheminDossier.setCellValueFactory(new PropertyValueFactory<>("cheminDossier"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            String sql ="SELECT * FROM courier.courrierDivers ";
            java.sql.Statement stm = con.createStatement();
            
            java.sql.ResultSet res= stm.executeQuery(sql);
            while(res.next()){
                data.add(new CourrierDiver(res.getString("id_courrier"), res.getString("expediteur"), res.getString("destinataire"),res.getString("objet"), res.getString("date_arriver"),res.getString("date_archivage"), res.getString("fileName")));
            }
            courrierTable.setItems(data);
            
            courrierTable.setEditable(true);
            numeroCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
            
            expediteur.setCellFactory(TextFieldTableCell.forTableColumn());
            
            objet.setCellFactory(TextFieldTableCell.forTableColumn());
            
            
            
            dateArchivage.setCellFactory(TextFieldTableCell.forTableColumn());
            
            cheminDossier.setCellFactory(TextFieldTableCell.forTableColumn());
            destinataire.setCellFactory(TextFieldTableCell.forTableColumn());
            /* } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiversController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(DiversController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiversController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiversController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

   



    
   
  

    @FXML
    private void ajouterCourrier(ActionEvent event) throws IOException {
        FXMLLoader parent = new FXMLLoader(getClass().getResource("AjouterCourrierDivers.fxml"));
        Parent root = (Parent)parent.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }


   
   /* private void onEditChangeFile(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
        CourrierDiver courrier= event.getRowValue();
        courrier.setCheminDossier(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET fileName='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }*/

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
    private void onEditChangeNumero(TableColumn.CellEditEvent<CourrierDiver, String> event) {
    }

    @FXML
    private void onEditChangeDestinataire(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
            CourrierDiver courrier= event.getRowValue();
        courrier.setObjet(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET objet='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeObjet(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
               CourrierDiver courrier= event.getRowValue();
        courrier.setObjet(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET objet='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeExpediteur0(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
                    CourrierDiver courrier= event.getRowValue();
        courrier.setExpediteur(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET expediteur='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeArchive(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
                    CourrierDiver courrier= event.getRowValue();
        courrier.setDateArchivage(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET date_archivage='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }

    @FXML
    private void onEditChangeFile(TableColumn.CellEditEvent<CourrierDiver, String> event) throws ClassNotFoundException, SQLException {
                CourrierDiver courrier= event.getRowValue();
        courrier.setCheminDossier(event.getNewValue());
        System.out.print(event.getNewValue());
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql="UPDATE  courier.courrierDivers SET fileName='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                stm.close();
    }

    

    
}
