package Homeworks.Homework_1.probability;

public class ProbabilityCalculator {
    public static int findTotalCount () {
        int total = 0;
        // looping through all possible ranges because I couldn't think of a smarter implementation
        // that wasn't just a mathematical one
        for(int i = 1; i <= 6; i++) {
            for (int j = 4; j <= 8; j++) {
                for (int k = 3; k <= 7; k++) {
                    for (int l = 1; l <= 9; l++) {
                        for (int m = 1; m <= 8; m++) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    public static int divisibleBy12Count() {
        int count = 0;
        // looping through all possible ranges because I couldn't think of a smarter implementation
        // that wasn't just a mathematical one
        for(int d1 = 1; d1 <= 6; d1++) {
            for (int d2 = 4; d2 <= 8; d2++) {
                for (int d3 = 3; d3 <= 7; d3++) {
                    for (int d4 = 1; d4 <= 9; d4++) {
                        for (int d5 = 1; d5 <= 8; d5++) {
                            int lastTwoDigits = d4 * 10 + d5;
                            int sumDigits = d1 + d2 + d3 + d4 + d5;
                            if (sumDigits % 3 == 0 && lastTwoDigits % 4 == 0) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static double probability() {
        return (double) divisibleBy12Count() / (double) findTotalCount();

    }
}
