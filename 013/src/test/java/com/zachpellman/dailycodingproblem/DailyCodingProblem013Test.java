package com.zachpellman.dailycodingproblem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.zachpellman.dailycodingproblem.DailyCodingProblem013.getLongestSubstringOfDistinctCharacters;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyCodingProblem013Test {

    @ParameterizedTest
    @MethodSource("getTestArguments")
    void test(final String input, final int k, final String expected) throws Exception {

        assertEquals(expected, getLongestSubstringOfDistinctCharacters(input, k));
    }

    private static Stream<Arguments> getTestArguments() {

        return Stream.of(
                Arguments.of("abcba", 2, "bcb"),
                Arguments.of("abcba", 4, "abcba"),
                Arguments.of("abcba", 3, "abcba"),
                Arguments.of("ababcccc", 2, "bcccc"),
                Arguments.of("aabacbebebe", 3, "cbebebe")
        );
    }
}