package com.zachpellman.dailycodingproblem;

import java.util.Arrays;

public class DailyCodingProblem009 {

    public static int getLargestSumOfNonAdjacent(final int[] list) {

        int maxSum = 0;
        int lastMaxSum = 0;
        int lastNonAdjacentMaxSum = 0;

        for (int i = 0; i < list.length; i++) {

            final int value = list[i];

            if (i == 0) {
                maxSum = value;
            } else if (i == 1) {
                maxSum = max(value, lastMaxSum);
            } else {
                maxSum = max(lastNonAdjacentMaxSum, lastMaxSum, lastNonAdjacentMaxSum + value, value);
            }

            lastNonAdjacentMaxSum = lastMaxSum;
            lastMaxSum = maxSum;
        }

        return maxSum;
    }

    private static int max(int... args) {

        assert(args.length > 0);
        return Arrays.stream(args).max().getAsInt();
    }
}
