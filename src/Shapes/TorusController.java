/* Project name: CMSC335PROJECT2
 * File name: TorusController.java
 * Author: Timothy Eckart
 * Date: 12 Nov 2024
 * Purpose: Controller file for the Torus FXML file.
 * Provides dropdown option of inner and outer radius increase for the shape.
 * Then displays the shape.
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
 * This is the Torus Controller class to prompt shape and
 * user selected dimension size.
 * **/
public class TorusController implements Initializable {
    int i = 0;
    @FXML
    private MeshView torusDisplay;

    @FXML
    private Label torusLabel1;

    @FXML
    private Label torusLabel2;

    @FXML
    private ChoiceBox<String> torusOutRdChoiceBx;

    @FXML
    private ChoiceBox<String> torusInRdChoiceBx;

    private final String[] torusOutRadius = {"100", "120", "130", "170", "180", "190", "200"};
    private final String[] torusInRadius= {"10", "20", "30", "40", "50"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        torusOutRdChoiceBx.getItems().addAll(torusOutRadius);
        torusInRdChoiceBx.getItems().addAll((torusInRadius));
        torusOutRdChoiceBx.setOnAction(this::gettorus);
        torusInRdChoiceBx.setOnAction(this::gettorus);
    }

    private void gettorus(ActionEvent actionEvent) {
        String myOutRadius = torusOutRdChoiceBx.getValue();
        String myInnerRadius = torusInRdChoiceBx.getValue();
        if (myOutRadius == null || myInnerRadius == null) {
            torusLabel1.setFont(new Font(13));
            torusLabel2.setText("Select both height & width.");
            return;
        }
        torusLabel1.setText("");
        torusLabel2.setText("");
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        torusDisplay.setVisible(true); //Displays the sphere
        torusDisplay.setMaterial(material);

        if (i == 0){
            torusDisplay.getTransforms().add(new Rotate(25, Rotate.X_AXIS));
            torusDisplay.getTransforms().add(new Rotate(25, Rotate.Y_AXIS));
            ++i;
        }


        float outerRadius = Float.parseFloat(myOutRadius);
        float innerRadius = Float.parseFloat(myInnerRadius);

        TriangleMesh torusMesh = createTorusMesh(outerRadius, innerRadius, 32, 16);
        torusDisplay.setMesh(torusMesh);
    }

    /** Method to the pass parameters to create Torus from MeshView
     * */
     private TriangleMesh createTorusMesh(float outerRadius, float innerRadius, int tubeDivisions, int circleDivisions) {
        TriangleMesh mesh = new TriangleMesh();

        // Create the points for the torus
        for (int i = 0; i <= circleDivisions; i++) {
            double theta = 2 * Math.PI * i / circleDivisions;
            float cosTheta = (float) Math.cos(theta);
            float sinTheta = (float) Math.sin(theta);

            for (int j = 0; j <= tubeDivisions; j++) {
                double phi = 2 * Math.PI * j / tubeDivisions;
                float cosPhi = (float) Math.cos(phi);
                float sinPhi = (float) Math.sin(phi);

                float x = (outerRadius + innerRadius * cosPhi) * cosTheta;
                float y = innerRadius * sinPhi;
                float z = (outerRadius + innerRadius * cosPhi) * sinTheta;

                mesh.getPoints().addAll(x, y, z);
            }
        }

        // Texture coordinates (simplified)
        mesh.getTexCoords().addAll(0, 0);

        // Create faces for the torus
        for (int i = 0; i < circleDivisions; i++) {
            for (int j = 0; j < tubeDivisions; j++) {
                int p0 = i * (tubeDivisions + 1) + j;
                int p1 = p0 + 1;
                int p2 = p0 + (tubeDivisions + 1);
                int p3 = p2 + 1;

                // First triangle of the face
                mesh.getFaces().addAll(p0, 0, p2, 0, p1, 0);

                // Second triangle of the face
                mesh.getFaces().addAll(p1, 0, p2, 0, p3, 0);
            }
        }
        return mesh;
    }


}



