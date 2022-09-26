
package calender;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class DBConnection {
    public static Boolean Connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con ;
            con= DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            System.out.println("connection established.....");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public static Boolean loginPhase(String userName, String password ) throws ClassNotFoundException, SQLException{
       
            Class.forName("com.mysql.jdbc.Driver");
            Connection con ;
            con= DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
            Statement stm = con.createStatement();
            String sql ="SELECT username, pass FROM courier.administrateur WHERE pass='"+password+"' and username='"+userName+"'";
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
                System.out.print("the is something");
                return true;
            }
            else{
                System.out.print("the is no thing");
                return false;
            }
  
    }
    public static void ajouterCourrierDBstatic (String expediteur,String objet,String date_arichivage,String date_arriver) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con= DriverManager.getConnection("jdbc:mysql://localhost:3307/courier","root","root");
        Statement stm = con.createStatement();
        String sql ="INSERT INTO courier.courrierIN(expediteur,objet,date_archivage,date_arriver)"
                + "VALUES('"+expediteur+"','"+objet+"',STR_TO_DATE('"+date_arichivage+"','%d,%m,%Y'),STR_TO_DATE('"+date_arriver+"','%d/%m/%Y'))";
        stm.executeUpdate(sql);
        System.out.println("courrier ajouter avec succes");
        stm.close();
        
    }
}
