
package calender;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Calendermain extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalenderFXML.fxml"));
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.setTitle("calender");
        stage.show();
        stage.setResizable(false);
    }   
    public static void main(String []args){
        launch(args);
    }
    
}
