package com.zachpellman.dailycodingproblem;

import java.util.Arrays;

public class DailyCodingProblem013 {

    static String getLongestSubstringOfDistinctCharacters(final String string, final int k) {

        final int[] charFrequencies = new int[26];

        int currentWindowStart = 0;
        int currentWindowEnd = 0;
        int maxWindowStart = 0;
        int maxWindowSize = 1;

        charFrequencies[string.charAt(0) - 'a']++;

        for (int i = 1; i < string.length(); i++) {

            charFrequencies[string.charAt(i) - 'a']++;
            currentWindowEnd++;

            while (!isValid(charFrequencies, k)) {
                charFrequencies[string.charAt(currentWindowStart) - 'a']--;
                currentWindowStart++;
            }

            final int currentWindowSize = currentWindowEnd - currentWindowStart + 1;

            if (currentWindowSize > maxWindowSize) {
                maxWindowSize = currentWindowSize;
                maxWindowStart = currentWindowStart;
            }
        }

        return string.substring(maxWindowStart, maxWindowStart + maxWindowSize);
    }

    private static boolean isValid(final int[] count, final int k) {

        return k >= Arrays.stream(count).filter(x -> x > 0).count();
    }
}