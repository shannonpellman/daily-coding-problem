package com.zachpellman.dailycodingproblem;

import java.util.stream.IntStream;

public class DailyCodingProblem014 {

    private static final int N = 100000;

    public static double estimatePi(final int decimals) {

        final double[] xCoords = IntStream.range(0, N).mapToDouble(i -> Math.random()).toArray();
        final double[] yCoords = IntStream.range(0, N).mapToDouble(i -> Math.random()).toArray();

        final double withinCircle = IntStream.range(0, N)
                .mapToDouble(i -> Math.pow(xCoords[i], 2.0) + Math.pow(yCoords[i], 2.0))
                .filter(r -> r < 1)
                .count();

        final double factor = Math.pow(10, decimals);

        return Math.floor(4 * withinCircle / N * factor) / factor;
    }
}