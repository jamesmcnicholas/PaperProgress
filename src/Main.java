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
        /*
        Scanner reader = new Scanner(System.in);
        BoundedCounter seconds = new BoundedCounter(59);
        BoundedCounter minutes = new BoundedCounter(59);
        BoundedCounter hours = new BoundedCounter(23);

        System.out.print("seconds: ");
        int s =Integer.parseInt(reader.nextLine());

        System.out.print("minutes: ");
        int m = Integer.parseInt(reader.nextLine());

        System.out.print("hours: ");
        int h = Integer.parseInt(reader.nextLine());

        seconds.setValue(s);
        minutes.setValue(m);
        hours.setValue(h);
        int i = 0;
        while ( i < 121 ) {
            System.out.println( hours + ":" + minutes + ":" + seconds);   // the current time printed
            seconds.next();
            if (seconds.getValue()==0){
                minutes.next();
                if (minutes.getValue()==0){
                    hours.next();
                }
            }
            i++;
        }
        */
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
