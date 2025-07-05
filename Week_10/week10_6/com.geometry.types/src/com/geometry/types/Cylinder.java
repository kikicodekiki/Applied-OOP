package Week_10.week10_6.com.geometry.types.src.com.geometry.types;

public class Cylinder extends Circle {
    private int height;

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    public Cylinder() {
        this(0, 0, 1, 1);
    }

    public Cylinder (Cylinder c) {
        this(c.getX(), c.getY(), c.getRadius(), c.getHeight());
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height > 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    @Override
    public int compareTo(Point o) {
        if(!(o instanceof Cylinder)) {
            return 1;
        }
        Cylinder c = (Cylinder) o;
        int baseCompare = super.compareTo(o);
        if(baseCompare != 0) {
            return baseCompare;
        }
        return this.height - c.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Base: %s, Height: %d", super.toString(), height);
    }
}
