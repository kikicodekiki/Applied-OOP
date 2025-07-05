package Week_10.week10_6.com.geometry.types.src.com.geometry.types;

public class Point implements Comparable<Point> {
    private int x;
    private int y;
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public Point(){
        this(0, 0);
    }

    public Point(Point point){
        this(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (o == null) {
            return 1; // curr object is bigger
        }

        if(this.x == o.getX()) {
            return this.y - o.getY(); // if bigger -> positive number
        }

        return this.x - o.getX();
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
