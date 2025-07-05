package Homeworks.Homework_1.probability;

import java.util.SplittableRandom;

public class ProbabilitySimulator {
    // using the Monte Carlo simulation from the lecture materials
    final static int SIMULATIONS_COUNT = 100000;// a large number of simulations

    public static int divisibleBy12Count () {
        // Run the simulation on a large number of tests whilst generating a random number
        SplittableRandom random = new SplittableRandom();
        int randomDivisible = 0;

        for(int i = 0; i < SIMULATIONS_COUNT; i++) {
            // translate the intervals
            int d1 = random.nextInt(6) + 1; // +1 so as to [0,5] -> [1,6]
            int d2 = random.nextInt(5) + 4; // [0,5) -> [0,4]+4 -> [4,8]
            int d3 = random.nextInt(5) + 3; // [3,7] -> [0,4]+3
            int d4 = random.nextInt(9) + 1; // [0,9) -> [1,9]
            int d5 = random.nextInt(8) + 1; // [0,8) -> [1,8]

            int number = d1 * 10000 + d2 * 1000 + d3 * 100 + d4 * 10 + d5;
            if (isDivisibleBy12(number)) {
                randomDivisible++;
            }
        }
        return randomDivisible;
    }

    public static double estimatedProbability() {
        // use the Monte Carlo probability
        return (double) divisibleBy12Count() / (double) SIMULATIONS_COUNT;
    }

    public static boolean isDivisibleBy3(int number) {
        // the sum of the digits must be divisible by 3
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum % 3 == 0;
    }

    public static boolean isDivisibleBy4 (int number) {
        // the last two digits must form a number divisible by 4
        int lastTwoDigits = number % 100;
        return lastTwoDigits % 4 == 0;
    }

    public static boolean isDivisibleBy12(int number) {
        // needs to be divisible by both 3 and 4
        return isDivisibleBy3(number) && isDivisibleBy4(number);
    }

}
