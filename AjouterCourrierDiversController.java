/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import javax.imageio.ImageIO;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class AjouterCourrierDiversController implements Initializable {

    @FXML
    private TextField expediteur;
    @FXML
    private TextField objet;
    @FXML
    private TextField dateAr;
    @FXML
    private TextField dateArrchive;
    @FXML
    private TextField addFile;
    @FXML
    private TextField destinataire;
    @FXML
    private BorderPane mainStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterFichier(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FileChooser fil_chooser = new FileChooser();
        File file;
        Stage stage = (Stage) mainStage.getScene().getWindow();
        file = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
                  System.out.println("path path path ");
                   addFile.setText(file.getAbsolutePath());
                }
    }

    @FXML
    private void AjouterCourrier(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
          String expediterur = expediteur.getText();
          String objetIn=objet.getText();
          String date_arr= dateAr.getText();
          String dateArchivage= dateArrchive.getText();
          String destinatair=destinataire.getText();
          String fileText= addFile.getText();
          DBConnection.ajouterCourrierDiversDBstatic(expediterur, destinatair, objetIn, dateArchivage, date_arr, fileText);
          //extract(fileText);
          System.out.println("ok");
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    public void extract (String path) throws IOException{
        File file =new File(path);
        String pathWithOutDots=path.replace(".", "");
        String pathWithOutSlash=pathWithOutDots.replace("\\", "");
        PDDocument p = Loader.loadPDF(file); 
        PDFRenderer pdfRenderer= new PDFRenderer(p);
        // Rendering an image
        // from the PDF document
        // using BufferedImage class
        BufferedImage img = pdfRenderer.renderImage(0);
        // Writing the extracted
        // image to a new file
       
        System.out.println(pathWithOutSlash+"88");
        ImageIO.write(
            img, "JPEG",
            new File("C:\\Users\\Mon pc\\Downloads\\"+pathWithOutSlash+".png"));
        System.out.println(
            "Image has been extracted successfully");
  
        // Closing the PDF document
        p.close();
    }
    
}
