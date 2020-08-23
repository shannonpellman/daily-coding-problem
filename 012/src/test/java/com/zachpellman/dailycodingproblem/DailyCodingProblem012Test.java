package com.zachpellman.dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DailyCodingProblem012Test {

    @ParameterizedTest
    @MethodSource("getTestArguments")
    void test(final int expected, final int stairs, final int[] steps) {

        Assertions.assertEquals(expected, DailyCodingProblem012.countWaysToClimbStairs(stairs, steps));
    }

    private static Stream<Arguments> getTestArguments() {

        return Stream.of(
                Arguments.of(5, 4, new int[]{1, 2}),
                Arguments.of(2, 6, new int[]{2, 3}),
                Arguments.of(5, 5, new int[]{1, 3, 5})
        );
    }
}