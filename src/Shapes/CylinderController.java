/* Project name: CMSC335PROJECT2
 * File name: CylinderController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Cylinder FXML file.
 * Provides dropdown option of radius and height increase for the shape.
 * Then displays the shape.
 */


package Shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Cylinder Controller class to prompt shape and
 * user selected dimension size.
 * **/
public class CylinderController implements Initializable {
    int i = 0;
    @FXML
    private Cylinder cylinderDisplay;

    @FXML
    private Label cylinderLabel1;

    @FXML
    private Label cylinderLabel2;

    @FXML
    private ChoiceBox<String> cylinderHtChoiceBx;

    @FXML
    private ChoiceBox<String> cylinderRdChoiceBx;

    private String[] cylinderDims = {"45", "60", "80", "100", "125"};
    private String[] cylinderRadius = {"45", "60", "70", "80", "95"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cylinderHtChoiceBx.getItems().addAll(cylinderDims);
        cylinderRdChoiceBx.getItems().addAll((cylinderRadius));
        cylinderHtChoiceBx.setOnAction(this::getcylinder);
        cylinderRdChoiceBx.setOnAction(this::getcylinder);
    }

    private void getcylinder(ActionEvent actionEvent) {
        String myCylinderheight = cylinderHtChoiceBx.getValue();
        String myCylinderRadius = cylinderRdChoiceBx.getValue();
        if (myCylinderheight == null || myCylinderRadius == null) {
            cylinderLabel1.setFont(new Font(13));
            cylinderLabel1.setText("Select both height & width.");
            return;
        }
        cylinderLabel1.setText("");
        cylinderLabel2.setText("");
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        cylinderDisplay.setVisible(true); //Displays the sphere
        cylinderDisplay.setMaterial(material);

        if (i == 0){
            cylinderDisplay.getTransforms().add(new Rotate(25, Rotate.X_AXIS));
            cylinderDisplay.getTransforms().add(new Rotate(25, Rotate.Y_AXIS));
            ++i;
        }


        double height = Double.parseDouble(myCylinderheight);
        double radius = Double.parseDouble(myCylinderRadius);
        cylinderDisplay.setHeight(height);
        cylinderDisplay.setRadius(radius);


    }


}
