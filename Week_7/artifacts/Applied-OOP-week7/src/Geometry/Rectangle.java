import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint; // upper left
    private double width;
    private double height;

    public Rectangle(){
        this(new Point(), 1, 1);
    }

    public Rectangle(Rectangle r) {
        this(r.getUPoint(), r.getWidth(), r.getHeight());
    }

    public Rectangle(Point uPoint, double width, double height) {
        // always calling the 'set'- methods
        setUPoint(uPoint);
        setWidth(width);
        setHeight(height);
    }

    public Point getUPoint() {
        // using the copy constructor to create a copy of the object
        // rather than an instance to our own
        return new Point(uPoint);
    }
    public void setUPoint(Point uPoint) {

        if(uPoint == null) {
            this.uPoint = new Point(); // calling the default constructor
        } else {
            this.uPoint = new Point(uPoint);
        }

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {

        if(width <= 0) {
            this.width = 1; // default number
        } else {
            this.width = width;
        }

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {

        if(height <= 0) {
            this.height = 1;
        } else {
            this.height = height;
        }

    }

    @Override
    public String toString() {
        return String.format("Upper left corner coords: %s%n;" +
                "(width: %.2f, height: %.2f)", uPoint.toString(), width, height);
    }

    public void draw (Group pane) {
        // creates it with its full path so as to not confuse it with our implementation
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(
                uPoint.getCoordinates()[0], uPoint.getCoordinates()[1], width, height
        );
        // change the settings of the drawing per preference
       rectangle.setFill(Color.TRANSPARENT);
       rectangle.setStroke(Color.BLACK);
       pane.getChildren().add(rectangle);
    }

}
