package com.zachpellman.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyCodingProblem009Test {

    @ParameterizedTest
    @MethodSource("getIntArrays")
    void getLargestSumOfNonAdjacent(final int[] list, final int expected) {

        assertEquals(expected, DailyCodingProblem009.getLargestSumOfNonAdjacent(list));
    }

    private static Stream<Arguments> getIntArrays() {

        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{2, 4, 6, 2, 5}, 13),
                Arguments.of(new int[]{5, 1, 1, 5}, 10),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{4, 1}, 4),
                Arguments.of(new int[]{1, 4}, 4),
                Arguments.of(new int[]{-1, 4, 6}, 6),
                Arguments.of(new int[]{9, 7, 6, 1, 5, 1, 8, 6, 6}, 34),
                Arguments.of(new int[]{9, 7, 6, 1, 5, 1, 8, 15, 6}, 35),
                Arguments.of(new int[]{-1, -2, -3, -4}, -1)
        );
    }
}
