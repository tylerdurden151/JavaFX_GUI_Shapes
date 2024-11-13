/* Project name: CMSC335PROJECT2
 * File name: Main.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Script is to allow user to select a list of shapes from menu list
 * and prompts a dropdown height, width, or radius increase for the shape.
 *
 */

package Shapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is the Main class for the main method and prompts user
 * homepage page FXML
  */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home Page");
        primaryStage.show();
    }
    public static void main (String[]args){
        launch(args);
    }
}
