package Week_2.problem_1;

public class Rectangle {
    private double width;
    private double height;
    public static String color = "yellow"; // so as to make it the default value no matter the constructor
    // alt + insert => generates getters and setters
    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
    public Rectangle(){
        this(1, 1); // vika gorniq konstruktor
    }

    public double getWidth() {
        return width;
    }

    public static String getColor() {
        return color;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if(width > 0){
            this.width = width;
        } else {
            this.width = 1;
        }
    }

    public void setHeight(double height) {
        if(width > 0){
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    public static void setColor(String color) {
        if (color == null || color.isEmpty()) {
            Rectangle.color = "yellow";
        } else {
            Rectangle.color = color;
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

}
