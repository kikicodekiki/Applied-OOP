package Week_1.problem_2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a five-digit number: ");
        int number = input.nextInt();
        int originalNumber = number; // avoid losing the number
        if (number > 9999 && number <= 99999) {
            // correct
            // can separate numbers like this: 99_999 without any problems
            int digit1, digit2, digit4, digit5; // do not need the middle number
            digit5 = number % 10;
            number /= 10;
            digit4 = number % 10;
            number /= 100; // to get only the second and first
            digit2 = number % 10;
            digit1 = number / 10;
            String resultString = "";
            if (digit5 == digit1 && digit4 == digit2) {
                // format the string -> %d for the innitial number
                resultString = String.format("%d is a palindrome", originalNumber);
            } else {
                resultString = String.format("%d is not a palindrome", originalNumber);
            }
            System.out.println(resultString);
        } else {
            // not valid -> display error message
            System.out.println("Not a five digit number!");
        }
    }
}
