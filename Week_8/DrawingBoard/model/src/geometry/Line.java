package Week_8.DrawingBoard.model.src.geometry;

import javafx.scene.layout.Pane;

public class Line extends Point{ // sPoint
    private Point endPoint;

    public Line(int[] coords, Point endPoint) {
        super(coords); // like in Python -> call for the parent constructor
        this.endPoint = endPoint;
    }

    public Line() {
        this(new int[2], new Point( new int[]{50, 50} ));
    }

    public Line(Line line) {
        this(line.getCoords(), line.getEndPoint());
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        if(endPoint != null) {
            this.endPoint = new Point(endPoint);
        } else {
            this.endPoint = new Point( new int[]{60, 60});
        }
    }

    public double measureDistance() {
        int[] coordsS = getCoords();
        int[] coordsE = endPoint.getCoords();
        int a = coordsS[0] - coordsE[0];
        int b = coordsS[1] - coordsE[1];
        return Math.sqrt(a*a + b*b);
    }

    public void draw(Pane pane) {

        int[] coordsS = getCoords();
        int[] coordsE = endPoint.getCoords();

        javafx.scene.shape.Line line = new javafx.scene.shape.Line(
                coordsS[0], coordsS[1], coordsE[0], coordsE[1]
        );

        pane.getChildren().add(line);

    }

    @Override
    public String toString() {
        return String.format("sPoint: %s, ePoint: %s", super.toString(), endPoint);
    }

}
