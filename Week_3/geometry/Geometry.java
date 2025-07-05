package Week_3.geometry;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name>

public class Geometry extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(width, height) / 3; // vzimame po-malkoto
        // TODO  Type code for Java FX drawing objects

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(null);
        circle.setStroke(Color.HOTPINK);
        // add it to the group so as to get drawn by the scene
        group.getChildren().add(circle);
        // the Scanner class does not work => using TextInputDialog
        double lineX = getLineX(width);
        Line line = new Line(lineX, 0, lineX, height);
        line.setStroke(Color.BLACK);
        group.getChildren().add(line);
        // have to find the points of intersection
        double chSquared = radius * radius - (centerX - lineX) * (centerX - lineX);
        if(chSquared >= 0) {
            // there is at least one point of intersection
            double intersectionOneY = centerY + Math.sqrt(chSquared);
            // draw intersection point
            drawIntersectionPoint(lineX, intersectionOneY, group);
            if (chSquared > 0) {
                double intersectionTwoY = centerY - Math.sqrt(chSquared);
                drawIntersectionPoint(lineX, intersectionTwoY, group);
            }
        } else {
            // no intersection points
            displayWarningDialog();
            // for a JavaFx application we use Platform.exit()
            Platform.exit(); // does not actually end the program so that's why we return
            return;
        }
        // end TODO
        stage.setTitle("Geometry"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    private double getLineX(double width) {
        // creating an object from the TextInputDialog class
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText("null");
        dialog.setContentText("Enter line X");
        double lineX;
        do {
            dialog.getEditor().setText(""); // clear the text
            lineX = Double.parseDouble(dialog.showAndWait().get());
            if(lineX < 0 || lineX > width) {
                displayErrorDialog(width);
            }
        } while(lineX < 0 || lineX > width);
        return lineX; // returns the result from the input like an optional => null check
    }

    private void drawIntersectionPoint(double x, double y, Group group) {
        Circle circle = new Circle (x, y, 3);
        group.getChildren().add(circle);
        Text text = new Text (x + 10, y, String.format("%.2f; %.2f", circle.getCenterX(), circle.getCenterY()));
        text.setFill(Color.BLACK);
        group.getChildren().add(text);
    }

    private void displayWarningDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // works the exact same way as the dialog window
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("There are no intersection points.");
        alert.showAndWait();
    }
    private void displayErrorDialog(double width) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.format("X must be in the interval: [0; %.2f].", width));
        alert.showAndWait();
    }
}
