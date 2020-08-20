package com.zpellman.dailycodingproblem;

import java.util.Arrays;

public class DailyCodingProblem069 {

    /**
     * Gets the largest product of three integers from a given list.
     *
     * @param list a list of integers
     *
     * @return The largest product of three integers from the list.
     */
    public static int getLargestProduct(final int[] list, final int k) {

        assert(list.length >= k);

        int[] max = createArray(k);
        int[] min = createArray(k - 1);

        for (int value : list) {
            for (int j = 0; j < max.length; j++) {
                if (isUnset(max[j]) || value > max[j]) {
                    insertAt(max, value, j);
                    break;
                }
            }

            for (int j = 0; j < min.length; j++) {
                if (isUnset(min[j]) || value < min[j]) {
                    insertAt(min, value, j);
                    break;
                }
            }
        }

        return Math.max(Arrays.stream(max).reduce(1, (product, factor) -> product * factor),
                max[0] * Arrays.stream(min).reduce(1, (product, factor) -> product * factor));
    }

    private static int[] createArray(final int size) {

        final int[] array = new int[size];
        Arrays.fill(array, Integer.MAX_VALUE);

        return array;
    }

    private static boolean isUnset(final int value) {

        return Integer.MAX_VALUE == value;
    }

    private static void insertAt(final int[] list, final int value, final int position) {

        if (list.length - 1 - position >= 0)
            System.arraycopy(list, position, list, position + 1, list.length - 1 - position);

        list[position] = value;
    }
}
