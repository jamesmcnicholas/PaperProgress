import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }


    public void start(Stage stage){
        try{
            URL url = new File("src/Assets/PaperProgress.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            stage.setTitle("Paper Progress");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("Assets/logo.png"));
            stage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
