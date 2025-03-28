/* Project name:
 * File name: TriangleController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Triangle FXML file.
 * Provides dropdown option of Area (Height and Width) increase for the shape.
 * Then displays the shape.
 */


package Shapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Triangle Controller class to prompt shape and
 * user selected dimension size.
 * **/

public class TriangleController implements Initializable {
    @FXML
    private Polygon triangleDisplay;

    @FXML
    private Label triangleLabel1;

    @FXML
    private Label triangleLabel2;

    @FXML
    private ChoiceBox<String> triangleChoiceBx;

    private String[] triangleDims = {"100", "110", "120", "130", "140", "150", "160"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        triangleChoiceBx.getItems().addAll(triangleDims);
        triangleChoiceBx.setOnAction(this::gettriangle);
    }

    private void gettriangle(javafx.event.ActionEvent actionEvent) {
        String selectedSize = triangleChoiceBx.getValue();
        triangleLabel1.setText("");
        triangleLabel2.setText("");
        triangleDisplay.setVisible(true);
        triangleDisplay.setFill(Color.BLUE);
        triangleDisplay.setStroke(Color.BLUE);
        double sideLength = Double.parseDouble(selectedSize);

        // Calculate the coordinates for an equilateral triangle
        double height = Math.sqrt(3) / 2 * sideLength;

        // Set the points for an equilateral triangle centered horizontally
        triangleDisplay.getPoints().clear(); // Clear any existing points
        triangleDisplay.getPoints().addAll(
                0.0, 0.0,                    // Top vertex
                sideLength / 2, height,      // Bottom right vertex
                -sideLength / 2, height      // Bottom left vertex
        );


    }


}
