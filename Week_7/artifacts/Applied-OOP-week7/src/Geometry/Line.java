import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Line {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        setStartPoint(startPoint);
        setEndPoint(endPoint); // need both setters
    }

    public Line() {
        // setting default values using the copy constructors
        this(new Point(), new Point(new double[]{1, 1}));
    }

    public Line (Line line) {
        this(line.getStartPoint(), line.getEndPoint());
    }

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public void setStartPoint(Point startPoint) {
        if (startPoint == null) {
            this.startPoint = new Point();
        } else {
            this.startPoint = new Point(startPoint);
        }

    }

    public Point getEndPoint() {
        return new Point(endPoint);
    }

    public void setEndPoint(Point endPoint) {
        if (endPoint == null) {
            // setting new default coordinates
            this.endPoint = new Point(new double[]{1, 1});
        } else {
            // using the copy constructor
            this.endPoint = new Point(endPoint);
        }
    }

    public void draw (Group pane) {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(
                startPoint.getCoordinates()[0], startPoint.getCoordinates()[1],
                endPoint.getCoordinates()[0], endPoint.getCoordinates()[1]
        );
        line.setStroke(Color.BLACK);
        pane.getChildren().add(line);
    }

    @Override
    public String toString() {
        // calls the toString methods of the two points
        return String.format("Begin point: %s." +
                "End point: %s", startPoint, endPoint);
    }

    // creating a java archive by:
    // project structure -> artefacts -> + -> JAR from modules with dependencies "project-name"
    // everything else stays by default
    // after that : build -> build artifacts => ready to go!

}
