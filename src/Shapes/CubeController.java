/* Project name: CMSC335PROJECT2
 * File name: CubeController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Cube FXML file.
 * Provides dropdown option of Area (height and width) increase for the shape.
 *
 */

package Shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Cube Controller class to prompt shape and
 * user selected dimension size.
 * **/

public class CubeController implements Initializable {
    int i = 0;
    @FXML
    private Box cubeDisplay;

    @FXML
    private Label cubeLabel1;

    @FXML
    private Label cubeLabel2;

    @FXML
    private ChoiceBox<String> cubeChoiceBx;

    private String[] cubeDims = {"20", "25", "30", "35", "40", "45","50", "55"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cubeChoiceBx.getItems().addAll(cubeDims);
        cubeChoiceBx.setOnAction(this::getcube);

    }

    private void getcube(ActionEvent actionEvent) {
        String mySquareheight = cubeChoiceBx.getValue();
        String mySquarewidth = cubeChoiceBx.getValue();
        cubeLabel1.setText("");
        cubeLabel2.setText("");

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        cubeDisplay.setVisible(true); //Displays the sphere
        cubeDisplay.setMaterial(material);
        
        if (i == 0){
            cubeDisplay.getTransforms().add(new Rotate(45, Rotate.X_AXIS));
            cubeDisplay.getTransforms().add(new Rotate(45, Rotate.Y_AXIS));
            ++i;
        }

        double height = Double.parseDouble(mySquareheight) ;
        double width =  Double.parseDouble(mySquarewidth);
        cubeDisplay.setHeight(height);
        cubeDisplay.setWidth(width);


    }


}
