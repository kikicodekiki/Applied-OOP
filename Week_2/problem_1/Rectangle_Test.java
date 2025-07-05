package Week_2.problem_1;

import java.util.Scanner;

public class Rectangle_Test {
    public static void main(String[] args) {
        Rectangle.setColor("blue"); // static so it allows to change the default color of every single instance
        Rectangle defaultRectangle = new Rectangle(); // [1,1]
        defaultRectangle.setHeight(3.7);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width of the rectangle: ");
        double width = input.nextDouble();
        System.out.println("Enter the height of the rectangle: ");
        double height = input.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);

        System.out.printf("Area: %.2f\nPerimeter: %.0f\nColor: %s", rectangle.getArea(),
                rectangle.getPerimeter(), Rectangle.getColor());
    }
}
