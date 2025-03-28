/* Project name:
 * File name: CircleController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Circle FXML file.
 * Provides dropdown option of radius increase for the shape.
 * Then displays the shape.
 */

package Shapes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Circle Controller class to prompt shape and
 * user selected dimension size.
 * **/
public class CircleController implements Initializable {
   @FXML
   private Circle circleDisplay;

   @FXML
   private Label circleLabel1;

   @FXML
   private ChoiceBox<String> circleChoiceBx;

   private String[] circleDims = {"12", "15", "20", "25", "30"};

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
           circleChoiceBx.getItems().addAll(circleDims);

       circleChoiceBx.setOnAction(this::getcircle);
   }

    private void getcircle(javafx.event.ActionEvent actionEvent) {
        String myCircle = circleChoiceBx.getValue();
        circleLabel1.setText("");
        circleDisplay.setFill(Color.BLUE);
        circleDisplay.setStroke(Color.BLUE);
        double radius = Double.parseDouble(myCircle);
        circleDisplay.setRadius(radius);


    }


}
