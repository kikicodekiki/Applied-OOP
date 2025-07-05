package Homeworks.Homework_1.probability;

public class TestProbability {

    public static void main(String[] args) {
        // implements the main logic of the program
        final String welcome = "Welcome!\nThis console application calculates the probability,\nusing the exact " +
                "probability and the Monte Carlo Simulation from the lectures.";
        System.out.println(welcome);
        System.out.println("-----------------------------------------------"); // for better formatting
        System.out.println(String.format("Exact Probability:\tSimulated Probability:"));
        System.out.printf("%-20.6f%-20.6f",
                ProbabilityCalculator.probability(), ProbabilitySimulator.estimatedProbability());
        System.out.printf("%n----------------------------------------------%n");
        System.out.println("Count of numbers with the given properties:");
        System.out.printf("%d", ProbabilityCalculator.findTotalCount());
        System.out.printf("%n----------------------------------------------%n");
        System.out.println("Count of numbers, divisible by 12:");
        System.out.printf("%d", ProbabilityCalculator.divisibleBy12Count());

    }

}
