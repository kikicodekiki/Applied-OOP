package Homeworks.Homework_4.HammingDistance.src.hamming;

import java.util.Scanner;

public class HammingTest {
    public static void main(String[] args) {
        byte a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter two bytes.");
        a = sc.nextByte();
        b = sc.nextByte();

        System.out.printf("The Hamming algorithm is using %d and %d bytes (decimal).\n", a, b);
        System.out.printf("In binary they look like this:\na: %s\nb: %s\n", HammingDist.toBinary(a),
                                                                            HammingDist.toBinary(b));
        System.out.printf("The result in is: %d\n", HammingDist.getDistance(a,b));
    }
}
