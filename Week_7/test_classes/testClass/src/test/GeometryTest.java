package Week_7.test_classes.testClass.src.test;
import Geometry.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name>

public class GeometryTest extends javafx.application.Application {

    public static void main (String[]args){
        launch(args);
    }

    public void drawRectangleWithDiagonals(Group root, Point uPoint, double width, double height) {
        Rectangle r = new Rectangle(uPoint, width, height);
        r.draw(root);

        double[] uPointCoords = uPoint.getCoordinates();

        Line diagonal1 = new Line(uPoint, new Point(new double[]{
                uPointCoords[0] + width, uPointCoords[1] + height
        }));
        Line diagonal2 = new Line(
                new Point(new double[]{
                        uPointCoords[0] + width, uPointCoords[1] }),
                new Point(new double[]{
                        uPointCoords[0], uPointCoords[1] + height
                })
        );
        diagonal1.draw(root);
        diagonal2.draw(root);
    }

    @Override
    public void start (Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);

        // TODO  Type code for Java FX drawing objects

        // using the random generator to create the two points
        Random generator = new Random();
        Point uPoint1 = new Point(new double[]{generator.nextDouble(500), generator.nextDouble(500)});
        Point uPoint2 = new Point(new double[]{generator.nextDouble(500), generator.nextDouble(500)});

        double width1 = generator.nextDouble(20, 100);
        double height1 = generator.nextDouble(20, 100);
        double width2 = generator.nextDouble(20, 100);
        double height2 = generator.nextDouble(20, 100);

        drawRectangleWithDiagonals(group, uPoint1, width1, height1);
        drawRectangleWithDiagonals(group, uPoint2, width2, height2);

        // end TODO
        stage.setTitle("Geometry"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
