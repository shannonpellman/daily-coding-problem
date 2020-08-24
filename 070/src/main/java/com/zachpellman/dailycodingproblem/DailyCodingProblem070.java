package com.zachpellman.dailycodingproblem;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DailyCodingProblem070 {

    public static int getNthPerfectNumber(final int n) {

        int number = 0;

        for (int i = 0; i < n; ) {
            if (sumDigits(++number) == 10) {
                i++;
            }
        }

        return number;
    }

    private static int sumDigits(final int number) {

        int sum = 0;

        for (int i = number; i > 0; i /= 10) {
            sum += i % 10;
        }

        return sum;
    }
}