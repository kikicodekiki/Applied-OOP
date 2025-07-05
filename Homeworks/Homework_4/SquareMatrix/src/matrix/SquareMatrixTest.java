package Homeworks.Homework_4.SquareMatrix.src.matrix;

import java.util.Random;

public class SquareMatrixTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = rand.nextInt(2, 13);
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextInt(9);
            }
        }

        SquareMatrix test = new SquareMatrix(matrix);
        System.out.println(test.toString());
        test.printAll();

        SquareMatrix test2 = new SquareMatrix();
        System.out.println(test2.toString());
        test2.printAll();

        SquareMatrix test3 = new SquareMatrix(test);
        System.out.println(test3.toString());
        test3.printAll();

    }
}
