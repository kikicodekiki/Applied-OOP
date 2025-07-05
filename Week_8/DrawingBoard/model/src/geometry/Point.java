package Week_8.DrawingBoard.model.src.geometry;

public class Point {
    private int[] coords;

    public Point(int[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new int[2]);
    }

    public Point(Point point) {
        this(point.getCoords());
    }

    public int[] getCoords() {
        // create a copy
        return new int[]{coords[0], coords[1]};
    }

    public void setCoords(int[] coords) {
        if(coords != null && coords.length == 2) {
            coords = new int[]{coords[0], coords[1]};
        } else {
            this.coords = new int[2];
        }
    }

    public Point getPoint() {
        return new Point(coords);
    }

    public void setCoords(Point point) {
        if(point != null) {
            this.coords = new int[]{point.getCoords()[0], point.getCoords()[1]};
        } else {
            this.coords = new int[2];
        }
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", coords[0], coords[1]);
    }
}
