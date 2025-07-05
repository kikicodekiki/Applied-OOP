package Week_10.week10_6.com.geometry.utils.src.com.geometry.utils;

import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {
    public static void main(String[] args) {
        Comparable[] arr = new Comparable[9];
        Random r = new Random();
        int x, y, radius, height;
        for (int i = 0; i < 3; i++) {
            x = r.nextInt(10, 51);
            y = r.nextInt(10, 51);
            radius = r.nextInt(10, 31);
            height = r.nextInt(10, 61);
            arr[i] = new Point(x, y);
            arr[i+3] = new Circle(x, y, radius);
            arr[i+6] = new Cylinder(x, y, radius, height);
            // adding them with the same coordinates so as to check how they compare within themselves
        }
        SelectionSort.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
