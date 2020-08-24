package com.zachpellman.dailycodingproblem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.zachpellman.dailycodingproblem.DailyCodingProblem070.getNthPerfectNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyCodingProblem070Test {

    @ParameterizedTest
    @MethodSource("getTestArguments")
    void test(final int n, final int expected) {

        assertEquals(expected, getNthPerfectNumber(n));
    }

    private static Stream<Arguments> getTestArguments() {

        return Stream.of(
                Arguments.of(1, 19),
                Arguments.of(2, 28),
                Arguments.of(52, 622)
        );
    }
}