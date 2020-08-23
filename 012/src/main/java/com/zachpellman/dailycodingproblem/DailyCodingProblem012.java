package com.zachpellman.dailycodingproblem;

public class DailyCodingProblem012 {

    public static int countWaysToClimbStairs(final int stairs, final int[] steps) {

        final int[] counts = new int[stairs + 1];
        counts[0] = 1;

        for (int i = 1; i <= stairs; i++) {
            for (int step : steps) {
                if (i >= step) {
                    counts[i] += counts[i - step];
                }
            }
        }

        return counts[stairs];
    }
}