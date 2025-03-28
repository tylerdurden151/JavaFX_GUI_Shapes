/* Project name:
 * File name: SphereController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Sphere FXML file.
 * Provides dropdown option of radius increase for the shape.
 * Then displays the shape.
 */


package Shapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Sphere Controller class to prompt shape and
 * user selected dimension size.
 * **/

public class SphereController implements Initializable {
    @FXML
    private Sphere sphereDisplay;

    @FXML
    private Label sphereLabel1;

    @FXML
    private Label sphereLabel2;

    @FXML
    private ChoiceBox<String> sphereChoiceBx;

    private String[] sphereDims = {"30", "40", "50", "60", "70"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sphereChoiceBx.getItems().addAll(sphereDims);

        sphereChoiceBx.setOnAction(this::getcircle);
    }

    private void getcircle(javafx.event.ActionEvent actionEvent) {
        String mySphere= sphereChoiceBx.getValue();
        sphereLabel1.setText("");
        sphereLabel2.setText("");

        PhongMaterial material = new PhongMaterial(); //Change the color of the Sphere
        material.setDiffuseColor(Color.BLUE);
        sphereDisplay.setVisible(true); //Displays the sphere
        sphereDisplay.setMaterial(material);
        double radius = Double.parseDouble(mySphere);
        sphereDisplay.setRadius(radius);


    }


}
