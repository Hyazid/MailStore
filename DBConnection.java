package calender;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {

    public static Boolean Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
            System.out.println("connection established.....");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static Boolean loginPhase(String userName, String password) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql = "SELECT username, pass FROM courier.administrateur WHERE pass='" + password + "' and username='" + userName + "'";
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            System.out.print("the is something");
            return true;
        } else {
            System.out.print("the is no thing");
            return false;
        }

    }

    public static void ajouterCourrierDBstatic(String expediteur, String objet, String date_arichivage, String date_arriver, String filePath) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql = "INSERT INTO courier.courrierIN(expediteur,objet,date_archivage,date_arriver,fileName)"
                + "VALUES('" + expediteur + "','" + objet + "',STR_TO_DATE('" + date_arichivage + "','%d/%m/%Y'),STR_TO_DATE('" + date_arriver + "','%d/%m/%Y'),'" + filePath + "')";
        stm.executeUpdate(sql);
        System.out.println("courrier ajouter avec succes");
        stm.close();

    }
    public static void ajouterCourrierSortantDBstatic(String destinataire, String objet, String date_arichivage, String date_envoi, String filePath) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql = "INSERT INTO courier.courrierout(destinataire,objet,date_archivage,date_envoi,fileName)"
                + "VALUES('" + destinataire + "','" + objet + "',STR_TO_DATE('" + date_arichivage + "','%d/%m/%Y'),STR_TO_DATE('" + date_envoi+ "','%d/%m/%Y'),'" + filePath + "')";
        stm.executeUpdate(sql);
        System.out.println("courrier ajouter avec succes");
        stm.close();

    }

    static HashMap avoirINFO() throws ClassNotFoundException, SQLException {

        String numero = "numero";
        String expediteur = "expediteur";
        String objet = "objet";
        String dateArchive = "dateArrchive";
        String dateArrive = "dateArrive";
        HashMap<String, String> result = new HashMap<String, String>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");

        System.out.println("Connected to the database successfully");
        Statement stm = con.createStatement();
        String sql="SELECT * FROM courier.courrierin";
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            result.put(numero, res.getString("id_courrier"));
            result.put(expediteur, res.getString("expediteur"));
            result.put(objet, res.getString("objet"));
            result.put(dateArchive, res.getString("date_archivage"));
            result.put(dateArrive, res.getString("date_arriver"));
            
           
        }
        return result;
        
     

    }
    public static void ajouterCourrierDiversDBstatic(String expediteur, String destinataire,String objet, String date_arichivage, String date_arriver, String filePath) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql = "INSERT INTO courier.courrierDivers(expediteur,destinataire,objet,date_archivage,date_arriver,fileName)"
                + "VALUES('" + expediteur + "','"+destinataire+"','" + objet + "',STR_TO_DATE('" + date_arichivage + "','%d/%m/%Y'),STR_TO_DATE('" + date_arriver + "','%d/%m/%Y'),'" + filePath + "')";
        stm.executeUpdate(sql);
        System.out.println("courrier ajouter avec succes");
        stm.close();

    }
    static HashMap getInfoToDelPanelSortant(String NumeroCourrier) throws ClassNotFoundException, SQLException{
        String numero = "numero";
        String destinataire = "destinataire";
        String objet = "objet";
        String dateArchive = "dateArchive";
        String dateEnvoi = "dateEnvoi";
        String fichier="fichier";
        HashMap<String, String> result = new HashMap<String, String>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="SELECT * FROM courier.courrierout Where id_courrier='"+NumeroCourrier+"'";
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            result.put(numero, res.getString("id_courrier"));
            result.put(destinataire, res.getString("destinataire"));
            result.put(objet, res.getString("objet"));
            result.put(dateArchive, res.getString("date_archivage"));
            result.put(dateEnvoi, res.getString("date_envoi"));
            result.put(fichier, res.getString("fileName"));
            
        }
        return result;
        
    }
   static HashMap getInfoToDelPanelEntant(String NumeroCourrier) throws ClassNotFoundException, SQLException{
         String numero = "numero";
        String expediteur = "expediteur";
        String objet = "objet";
        String dateArchive = "dateArchive";
        String dateArrive = "dateArrive";
        String fichier="fichier";
        HashMap<String, String> result = new HashMap<String, String>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="SELECT * FROM courier.courrierin Where id_courrier='"+NumeroCourrier+"'";
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            result.put(numero, res.getString("id_courrier"));
            result.put(expediteur, res.getString("expediteur"));
            result.put(objet, res.getString("objet"));
            result.put(dateArchive, res.getString("date_archivage"));
            result.put(dateArrive, res.getString("date_arriver"));
             result.put(fichier, res.getString("fileName"));
        }
        return result;

    }
     static HashMap getInfoToDelPanelDivers(String NumeroCourrier) throws ClassNotFoundException, SQLException{
        String numero = "numero";
        String expediteur = "expediteur";
        String destinataire="destinataire";
        String dateEnvoi="dateEnvoi";
        String objet = "objet";
        String dateArchive = "dateArchive";
        String dateArrive = "dateArrive";
        String fichier="fichier";
        HashMap<String, String> result = new HashMap<String, String>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="SELECT * FROM courier.courrierdivers Where id_courrier='"+NumeroCourrier+"'";
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            result.put(numero, res.getString("id_courrier"));
            result.put(expediteur, res.getString("expediteur"));
            result.put(destinataire, res.getString("destinataire"));
            result.put(objet, res.getString("objet"));
            result.put(dateArchive, res.getString("date_archivage"));
            result.put(dateArrive, res.getString("date_arriver"));
             result.put(fichier, res.getString("fileName"));
        }
        return result;

    }
     static void supprimerCourrierSortant(String Ncourrier) throws ClassNotFoundException, SQLException{
          Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="DELETE FROM courier.courrierout Where id_courrier='"+Ncourrier+"'";
        stm.executeUpdate(sql);
        System.out.println("courrier supprimer avec succes");
        stm.close();
        
        
         
     }
     static void supprimerCourrierEntrant(String Ncourrier) throws ClassNotFoundException, SQLException{
          Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="DELETE FROM courier.courrierin Where id_courrier='"+Ncourrier+"'";
        stm.executeUpdate(sql);
        System.out.println("courrier supprimer avec succes");
        stm.close();
     }
     static void supprimerCourrierDivers(String Ncourrier) throws ClassNotFoundException, SQLException{
          Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/courier", "root", "root");
        Statement stm = con.createStatement();
        String sql="DELETE FROM courier.courrierDivers Where id_courrier='"+Ncourrier+"'";
        stm.executeUpdate(sql);
        System.out.println("courrier supprimer avec succes");
        stm.close();
         
     }

}
