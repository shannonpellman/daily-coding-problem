package com.zpellman.dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DailyCodingProblem069Test {

    @ParameterizedTest
    @MethodSource("getTestArguments")
    void getLargestTripletProduct(final int[] list, final int expected) {

        Assertions.assertEquals(expected, DailyCodingProblem069.getLargestProduct(list, 3));
    }

    private static Stream<Arguments> getTestArguments() {

        return Stream.of(
                Arguments.of(new int[]{-10, -10, 5, 2}, 500),
                Arguments.of(new int[]{8, 3, 2, 9}, 216),
                Arguments.of(new int[]{-100, 1, 1}, -100),
                Arguments.of(new int[]{-100, 1, 1, 1}, 1)
        );
    }
}
