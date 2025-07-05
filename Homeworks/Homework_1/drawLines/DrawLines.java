package Homeworks.Homework_1.drawLines;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawLines extends Application {
    // Static constants for shared resources between instances
    private final static int NUMBER_OF_OPERATIONS = 21;
    private final static int SCENE_SIZE = 450;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, SCENE_SIZE, SCENE_SIZE);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double heightCoefficient = height / NUMBER_OF_OPERATIONS; // Needed to calculate the coordinates
        double widthCoefficient = width / NUMBER_OF_OPERATIONS;

        drawPicture (group, width, height, widthCoefficient, heightCoefficient);

        stage.setTitle("Drawing scene"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    private void drawPicture(Group group, double width, double height, double widthCoefficient, double heightCoefficient) {
        // a private method that implements the core logic without the need for four different for-cycles
        Line line = new Line(); // Reusing one instance for all iterations
        for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
            group.getChildren().add(createLine(line, 0, height - i * heightCoefficient,
                    width - i * widthCoefficient, height));
            group.getChildren().add(createLine(line, 0, i * heightCoefficient,
                    width - i * widthCoefficient, 0));
            group.getChildren().add(createLine(line,width, height - i * heightCoefficient,
                    widthCoefficient * i, height));
            group.getChildren().add(createLine(line, width, i * heightCoefficient,
                    i * heightCoefficient, 0));
        }
    }

    private Line createLine(Line line, double startX, double startY, double endX, double endY) {
        // Uses the line object instance so as to set the color and create it with the correct coordinates
        line = new Line(startX, startY, endX, endY);
        line.setStroke(Color.ORANGE);
        return line;
    }
}
