/* Project name: CMSC335PROJECT2
 * File name: SquareController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Square FXML file.
 * Provides dropdown option of Area (Height and Width) increase for the shape.
 * Then displays the shape.
 */

package Shapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Square Controller class to prompt shape and
 * user selected dimension size.
 * **/

public class SquareController implements Initializable {
    @FXML
    private Rectangle squareDisplay;

    @FXML
    private Label squareLabel1;

    @FXML
    private Label squareLabel2;

    @FXML
    private ChoiceBox<String> squareChoiceBx;

    private String[] squareDims = {"200", "210", "220", "230", "240"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        squareChoiceBx.getItems().addAll(squareDims);
        squareChoiceBx.setOnAction(this::getsquare);

    }

    private void getsquare(javafx.event.ActionEvent actionEvent) {
        String mySquareheight = squareChoiceBx.getValue();
        String mySquarewidth = squareChoiceBx.getValue();
        squareLabel1.setText("");
        squareLabel2.setText("");
        squareDisplay.setFill(Color.BLUE);
        squareDisplay.setStroke(Color.BLUE);
        double height = Double.parseDouble(mySquareheight);
        double width = Double.parseDouble(mySquarewidth);
        squareDisplay.setHeight(height);
        squareDisplay.setWidth(width);


    }


}
