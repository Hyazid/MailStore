
package calender;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.sql.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CourrierINController implements Initializable {

    @FXML
    private Pane paneOption;
    @FXML
    private TableView<Courrier> courrierTable;
    @FXML
    private TableColumn<Courrier, String> numeroCourrier;
    @FXML
    private TableColumn<Courrier, String> expediteurCourrier;
    @FXML
    private TableColumn<Courrier, String> objetCourrier;
    @FXML
    private TableColumn<Courrier, String> datArriveCourrier;
    @FXML
    private TableColumn<Courrier, String> dateArchivage;
   
     final ObservableList<Courrier> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Courrier, String> cheminDossier;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
            numeroCourrier.setCellValueFactory(new PropertyValueFactory<>("numeroCourrier"));
           
            expediteurCourrier.setCellValueFactory(new PropertyValueFactory<>("expediteur"));
            
            objetCourrier.setCellValueFactory(new PropertyValueFactory<>("objet"));
           
            datArriveCourrier.setCellValueFactory(new PropertyValueFactory<>("dateArrive"));
           
            dateArchivage.setCellValueFactory(new PropertyValueFactory<>("dateArchivage"));
           
            cheminDossier.setCellValueFactory(new PropertyValueFactory<>("cheminDossier"));
           
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                String sql ="SELECT * FROM courier.courrierin ";
                java.sql.Statement stm = con.createStatement();
            
                java.sql.ResultSet res= stm.executeQuery(sql);
                while(res.next()){
                    data.add(new  Courrier(res.getString("id_courrier"),res.getString("expediteur"),res.getString("objet"),
                    res.getString("date_archivage"),res.getString("date_arriver"),res.getString("fileName")));
                }
                
                courrierTable.setItems(data);
                
                courrierTable.setEditable(true);
                
                numeroCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
               
                expediteurCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
                
                objetCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
                
                datArriveCourrier.setCellFactory(TextFieldTableCell.forTableColumn());
                
                dateArchivage.setCellFactory(TextFieldTableCell.forTableColumn());
                
                cheminDossier.setCellFactory(TextFieldTableCell.forTableColumn());       
           
            }catch(ClassNotFoundException e){
                System.out.println("ther is an error ");
            } catch (SQLException ex) {
            Logger.getLogger(CourrierINController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
    public void avoirDATA() throws SQLException, ClassNotFoundException{
        String []arr= new String[4];
        Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            
            PreparedStatement p = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM courier.courrierin";
            p = (PreparedStatement) con.prepareStatement(sql);
            rs = (ResultSet) p.executeQuery();
            while(rs.next()){
                arr[0]=rs.getString("numero");
                arr[1]=rs.getString("expediteur");
                arr[2]=rs.getString("objet");
                arr[3]=rs.getString("date_archivage");
                arr[4]=rs.getString("date_arriver");
                System.out.println("-->"+arr[0]+"-->"+arr[1]+"-->"+arr[2]+"-->"+arr[3]+"");
            }
           
    }

    @FXML
    private void changeElementRow(MouseEvent event) {
                 
    }
    @FXML
    private void onEditChangeExpediteur(TableColumn.CellEditEvent<Courrier, String> event) throws SQLException, ClassNotFoundException {
        Courrier courrier= event.getRowValue();
            courrier.setExpediteur(event.getNewValue());
            System.out.print(event.getNewValue());
              Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
                  String sql="UPDATE  courier.courrierin SET expediteur='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                java.sql.Statement stm = con.createStatement();
            
               stm.executeUpdate(sql);
                stm.close();
    }
    @FXML
    private void onEditChangeObjet(TableColumn.CellEditEvent<Courrier, String> event) throws ClassNotFoundException, SQLException {
        Courrier courrier= event.getRowValue();
            courrier.setObjet(event.getNewValue());
            String a =courrier.getNumeroCourrier();
            System.out.println(event.getNewValue()+"--->>>");
            System.out.print(a);
            String sql="UPDATE  courier.courrierin SET objet='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                 stm.close();
    }
    @FXML
    private void onEditChangeArrive(TableColumn.CellEditEvent<Courrier, String> event) throws ClassNotFoundException, SQLException {
            Courrier courrier= event.getRowValue();
            courrier.setDateArrive(event.getNewValue());
            String a =courrier.getNumeroCourrier();
            System.out.println(event.getNewValue()+"--->>>");
            System.out.print(a);
            String sql="UPDATE  courier.courrierin SET date_arriver='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                 stm.close();
    }
    @FXML
    private void onEditChangeArchive(TableColumn.CellEditEvent<Courrier, String> event) throws ClassNotFoundException, SQLException {
         Courrier courrier= event.getRowValue();
            courrier.setDateArchivage(event.getNewValue());
            String a =courrier.getNumeroCourrier();
            System.out.println(event.getNewValue()+"--->>>");
            System.out.print(a);
            String sql="UPDATE  courier.courrierin SET date_archivage='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                 stm.close();
    }
    @FXML
    private void onEditChangeFile(TableColumn.CellEditEvent<Courrier, String> event) throws ClassNotFoundException, SQLException {
          Courrier courrier= event.getRowValue();
            courrier.setCheminDossier(event.getNewValue());
            String a =courrier.getNumeroCourrier();
            System.out.println(event.getNewValue()+"--->>>");
            System.out.print(a);
            String sql="UPDATE  courier.courrierin SET fileName='"+event.getNewValue()+"'WHERE id_courrier="+event.getRowValue().getNumeroCourrier() ;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            java.sql.Statement stm = con.createStatement();
            
                stm.executeUpdate(sql);
                 stm.close();
    }  


    
   
}
