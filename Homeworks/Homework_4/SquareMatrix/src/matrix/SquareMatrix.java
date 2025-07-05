package Homeworks.Homework_4.SquareMatrix.src.matrix;

import java.util.Arrays;
import java.util.Random;

public class SquareMatrix {
    private int dataArray[][];
    int size;
    static final int DEFAULT_SIZE = 8;

    public int[][] getDataArray() {
        // returning a deep copy rather than a reference
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = dataArray[i][j];
            }
        }
        return copy;
    }

    public void setDataArray(int[][] dataArray) {
        if(dataArray == null ||dataArray.length == 0|| dataArray.length != dataArray[0].length) {
            // set to some default value
            this.size = DEFAULT_SIZE;
            this.dataArray = new int[size][size];
            Random r = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.dataArray[i][j] = r.nextInt(101); // set some random values
                }
            }
        } else {
            this.size = dataArray.length;
            this.dataArray = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.dataArray[i][j] = dataArray[i][j];
                }
            }
        }
    }

    public SquareMatrix(int[][] dataArray) {
        setDataArray(dataArray);
    }

    public SquareMatrix() {
        setDataArray(null); // so as to call the default implementation
    }

    public SquareMatrix(SquareMatrix other) {
        this(other.getDataArray());
    }

    public int findMaxSum () {
        // not using a prefix sum because it might be an overkill
        // so just iterating over every sub-matrix
        // and checking if the sum is larger
        if(size < 2) return -1; // some invalid value
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                int currentSum = dataArray[i][j] + dataArray[i+1][j]
                            + dataArray[i][j+1] + dataArray[i+1][j+1];
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }
        return max;
    }

    public void printAll () {
        int max = findMaxSum();
        if(max == -1) {
            System.out.println("No matrix found");
            return;
        }
        System.out.printf("Max Sum: %d\n", max);
        System.out.println("Submatrices with Maximum sum:");
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                int currentSum = dataArray[i][j] + dataArray[i+1][j]
                        + dataArray[i][j+1] + dataArray[i+1][j+1];
                if (currentSum == max) {
                    System.out.printf("[%d, %d]\n", i, j);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(Arrays.toString(dataArray[i]));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
