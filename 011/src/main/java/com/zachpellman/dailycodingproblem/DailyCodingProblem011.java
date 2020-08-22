package com.zachpellman.dailycodingproblem;

import java.util.Set;

public class DailyCodingProblem011 {

    public static Set<String> autocomplete(final Set<String> dictionary, final String query) {

        return Trie.of(dictionary).search(query);
    }
}