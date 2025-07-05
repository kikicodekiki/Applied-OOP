package Week_10.week10_6.com.geometry.types.src.com.geometry.types;

public class Circle extends Point{

    private int radius;

    // need another override for the compareTo function

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public Circle() {
        this(0, 0, 1);
    }

    public Circle(Circle circle) {
        this(circle.getX(), circle.getY(), circle.getRadius());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius <= 0){
            radius = 1;
        } else {
            this.radius = radius;
        }
    }

    @Override
    public String toString() {
        return String.format("Center: %s, Radius: %d", super.toString(), radius);
    }

    @Override
    public int compareTo(Point o) {
        if(o == null){
            return 0;
        } // next step -> check if the object is actually from tje Circle type

        if(!(o instanceof Circle)){ // -> this also checks for null so we don't need it but just to showcase
            return 1;
        }

        Circle c = (Circle) o; // casting back to Circle
        int centerCompare = super.compareTo(c);
        if( centerCompare == 0 ){
            return this.radius - c.getRadius();
        }

        return centerCompare;
    }
}
