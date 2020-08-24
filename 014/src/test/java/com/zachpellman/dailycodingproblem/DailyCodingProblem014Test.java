package com.zachpellman.dailycodingproblem;

import org.junit.jupiter.api.Test;

import static com.zachpellman.dailycodingproblem.DailyCodingProblem014.estimatePi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyCodingProblem014Test {

    @Test
    void test() {

        final double piEstimate = estimatePi(3);

        assertEquals(3.141, estimatePi(3), 0.1);
    }
}