/* Project name: CMSC335PROJECT2
 * File name: Controller.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: This is the main controller for the HomePage.
 * Prompts user selection choice to the appropriate FXML file.
 *
 */

package Shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is the Controller class for the FXML files and prompts shape Stage
 * selection.
 */

public class Controller {

    @FXML
    private Button circleButton;

    @FXML
    private Button rectangleButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button sphereButton;

    @FXML
    private Button cubeButton;

    @FXML
    private Button cylinderButton;

    @FXML
    private Button triangleButton;

    @FXML
    private Button coneButton;

    @FXML
    private Button torusButton;

    @FXML
    private void handleButton1Action(ActionEvent event) throws IOException {
        openWindow("Circle.fxml", "Circle Choice");
    }
    @FXML
    private void handleButton2Action(ActionEvent event) throws IOException {
        openWindow("Rectangle.fxml", "Rectangle Choice");
    }

    @FXML
    private void handleButton3Action(ActionEvent event) throws IOException {
        openWindow("Square.fxml", "Square Choice");
    }

    @FXML
    private void handleButton4Action(ActionEvent event) throws IOException{
        openWindow("Sphere.fxml", "Sphere Choice");
    }

    @FXML
    private void handleButton5Action(ActionEvent event) throws IOException{
        openWindow("Cube.fxml", "Cube Choice");
    }

    @FXML
    private void handleButton6Action(ActionEvent event) throws IOException{
        openWindow("Cylinder.fxml", "Cylinder Choice");
    }

    @FXML
    private void handleButton7Action(ActionEvent event) throws IOException{
        openWindow("Triangle.fxml", "Triangle Choice");
    }

    @FXML
    private void handleButton8Action(ActionEvent event) throws IOException{
        openWindow("Cone.fxml", "Cone Choice");
    }

    @FXML
    private void handleButton9Action(ActionEvent event) throws IOException{
        openWindow("Torus.fxml", "Torus Choice");
    }

    /** Method to pass handle Button action event
     * */
    private void openWindow(String fxmlFile, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }


}
