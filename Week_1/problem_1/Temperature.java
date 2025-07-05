package Week_1.problem_1;

import java.util.Scanner;

public class Temperature {
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius;
        // trqbva pone edno ot dvete da razglezhdame kato drobno chislo
        celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
        return celsius;
    }

    public static double celsiusToFahrenheit(double celcius) {
        return 9.0 / 5.0 * celcius + 32.0;
    }

    public static void main(String[] args) {
        // ako iskame drugi metodi da izvikvame v main-a => sushto trqbva da sa static
        Scanner input = new Scanner(System.in); // prochita info ot konzolata
        int choice; // let the user make a descision
        System.out.print("Enter 1 for F to C or 2 for C to F: ");
        // sout -> printl
        // souf -> printf (formated)
        choice = input.nextInt();
        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = input.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("Celsius = %.0f%n", celsius);
            // %f -> float and double (%.0f -> to decimal)
            // %d -> decimal
            // %s -> string
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = input.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("Fahrenheit = %.3f%n", fahrenheit);
        } else{
            // invalid choice
            System.out.println("Invalid choice!");
            System.exit(0); // end the program
            // other statuses -> for other expected errors
        }

        System.out.printf("%s%d", "Number: ", 3); // the correct order for formatting
        System.out.println();
        String name = "Alex";
        // String message = STR."Greetings \{name}!"; // postavq direktno promenlivata -> only Java21
        // choose language level 21 from settings->project structure
        // System.out.print(message);

    }
}
