/* Project name: CMSC335PROJECT2
 * File name: RectangleController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Rectangle FXML file.
 * Provides dropdown option of Area (height and width) increase for the shape.
 * Then displays the shape.
 */

package Shapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Rectangle Controller class to prompt shape and
 * user selected dimension size.
 * **/

public class RectangleController implements Initializable {
    @FXML
    private Rectangle rectangleDisplay;

    @FXML
    private Label rectangleLabel1;

    @FXML
    private Label rectangleLabel2;

    @FXML
    private ChoiceBox<String> rectheightChoiceBx;

    @FXML
    private ChoiceBox<String> rectWidthChoiceBx;

    private String[] recheightDims = {"120", "130", "140", "150", "160"};
    private String[] recwidthDims = {"300", "310", "320", "330", "340"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rectheightChoiceBx.getItems().addAll(recheightDims);
        rectWidthChoiceBx.getItems().addAll((recwidthDims));
        rectheightChoiceBx.setOnAction(this::getrectangle);
        rectWidthChoiceBx.setOnAction(this::getrectangle);
    }

    private void getrectangle(javafx.event.ActionEvent actionEvent) {
        String myRectangleheight = rectheightChoiceBx.getValue();
        String myRectanglewidth = rectWidthChoiceBx.getValue();
        if (myRectangleheight == null || myRectanglewidth == null) {
            rectangleLabel1.setFont(new Font(13));
            rectangleLabel1.setText("Select both height & width.");
            return;
        }
        rectangleLabel1.setText("");
        rectangleLabel2.setText("");
        rectangleDisplay.setFill(Color.BLUE);
        rectangleDisplay.setStroke(Color.BLUE);
        double height = Double.parseDouble(myRectangleheight);
        double width = Double.parseDouble(myRectanglewidth);
        rectangleDisplay.setHeight(height);
        rectangleDisplay.setWidth(width);


    }


}
