/* Project name: CMSC335PROJECT2
 * File name: ConeController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Cone FXML file.
 * Provides dropdown option of height and radius increase for the shape.
 *
 */

package Shapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the Cone Controller class to prompt shape and
 * user selected dimension size.
 * **/
public class ConeController implements Initializable {
    int i = 0;
    @FXML
    private MeshView coneDisplay;

    @FXML
    private Label coneLabel1;

    @FXML
    private Label coneLabel2;

    @FXML
    private ChoiceBox<String> coneHtChoiceBx;

    @FXML
    private ChoiceBox<String> coneRdChoiceBx;

    private final String[] coneHeights = {"100", "150", "200", "250", "300"};
    private final String[] coneRadius= {"30", "40", "50", "60", "70"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coneHtChoiceBx.getItems().addAll(coneHeights);
        coneRdChoiceBx.getItems().addAll((coneRadius));
        coneHtChoiceBx.setOnAction(this::getcone);
        coneRdChoiceBx.setOnAction(this::getcone);
    }

    private void getcone(ActionEvent actionEvent) {
        String myConeheight = coneHtChoiceBx.getValue();
        String myConeRadius = coneRdChoiceBx.getValue();
        if (myConeheight == null || myConeRadius == null) {
            coneLabel1.setFont(new Font(13));
            coneLabel1.setText("Select both height & width.");
            return;
        }
        coneLabel1.setText("");
        coneLabel2.setText("");
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        coneDisplay.setVisible(true); //Displays the sphere
        coneDisplay.setMaterial(material);

       if (i == 0){
            coneDisplay.getTransforms().add(new Rotate(45, Rotate.X_AXIS));
            coneDisplay.getTransforms().add(new Rotate(45, Rotate.Y_AXIS));
            ++i;
        }


        double height = Double.parseDouble(myConeheight);
        double radius = Double.parseDouble(myConeRadius);
        TriangleMesh coneMesh = createConeMesh((float) radius, (float) height, 32);
        coneDisplay.setMesh(coneMesh);
    }
    /** Method to the pass parameters to create Cone from MeshView
     * */
        private TriangleMesh createConeMesh(float radius, float height, int divisions) {
            TriangleMesh mesh = new TriangleMesh();

            // Apex point at the top
            mesh.getPoints().addAll(0, -height / 2, 0); // Apex (top center)

            // Base points arranged in a circle
            double angleStep = 2 * Math.PI / divisions;
            for (int i = 0; i < divisions; i++) {
                double angle = i * angleStep;
                float x = radius * (float) Math.cos(angle);
                float z = radius * (float) Math.sin(angle);
                mesh.getPoints().addAll(x, height / 2, z); // Y is the base height
            }

            mesh.getTexCoords().addAll(0, 0);
            for (int i = 1; i < divisions; i++) {
                mesh.getFaces().addAll(
                        0, 0,        // Apex point
                        i, 0,        // Current base point
                        i + 1, 0     // Next base point
                );
            }


            mesh.getFaces().addAll(
                    0, 0,
                    divisions, 0, // Last base point
                    1, 0          // First base point
            );

            return mesh;
        }


    }



