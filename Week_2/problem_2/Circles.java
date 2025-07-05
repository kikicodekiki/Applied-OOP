package Week_2.problem_2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name> 

public class Circles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);

        // TODO  Type code for Java FX drawing objects
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene


        // draw a line from the upper-left to the lower-right
        Line line = new Line(0, 0, width, height);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);
        // draw a line from the lower-left to the upper-right
        line = new Line(0, height, width, 0);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);

        Circle circle = new Circle(width / 2, height / 2, width / 2);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLUE);
        group.getChildren().add(circle);

        // end TODO
        stage.setTitle("Drawing scene"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}