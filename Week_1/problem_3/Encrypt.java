package Week_1.problem_3;

import java.util.Scanner;

public class Encrypt {

    public static boolean isFourDigit (int number) {
        int counter = 0;
        while (number != 0) {
            int digit = number % 10;
            number /= 10;
            counter++;
        }
        return counter == 4;
    }

    public static void swapNumbers (int number1, int number2) {
        int temp = number1;
        number1 = number2;
        number2 = temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number, originalNumber;
        System.out.print("Enter an 4-digit number: ");
        number = input.nextInt();
        originalNumber = number;
        if (!isFourDigit (number)) {
            System.out.println("Not a four digit number!");
            System.exit(0);
        }

        int digit1, digit2, digit3, digit4;
        digit4 = number % 10;
        number /= 10;
        digit3 = number % 10;
        number /= 10;
        digit2 = number % 10;
        number /= 10;
        digit1 = number;

        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;

        swapNumbers(digit1, digit2);

        int tmp = digit1;
        digit1 = digit3;
        digit3 = digit1;

        tmp = digit2;
        digit2 = digit4;
        digit4 = digit2;

        int encrypted = digit1 * 1000 + digit2*100 + digit3*10 + digit4;
        System.out.printf("%d Encrypted: %04d", originalNumber, encrypted);
        // %04d -> fills the empty blanks with 0s
    }
}
