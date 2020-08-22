package com.zachpellman.dailycodingproblem;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.zachpellman.dailycodingproblem.DailyCodingProblem011.autocomplete;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyCodingProblem011Test {

    @Test
    void emptyDictionary() {

        assertEquals(ImmutableSet.of(), autocomplete(ImmutableSet.of(), "foo"));
    }

    @Test
    void emptyQuery() {

        final Set<String> dictionary = ImmutableSet.of("foo", "bar", "baz");

        assertEquals(dictionary, autocomplete(dictionary, ""));
    }

    @Test
    void noMatches() {

        assertEquals(ImmutableSet.of(), autocomplete(ImmutableSet.of("foo", "bar", "baz"), "needle"));
    }

    @Test
    void matchesWithoutSuffixes() {

        assertEquals(ImmutableSet.of("deer", "deal"), autocomplete(ImmutableSet.of("dog", "deer", "deal"), "de"));
    }

    @Test
    void matchesWithSuffices() {

        assertEquals(ImmutableSet.of("word", "wording"),
                autocomplete(ImmutableSet.of("word", "wording", "wood"), "wor"));
    }
}