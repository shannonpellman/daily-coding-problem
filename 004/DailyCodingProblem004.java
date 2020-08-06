public class DailyCodingProblem004 {

    public static void main(String[] args) {

        assert(getLowestMissingPositiveInteger(new int[]{0}) == 1);
        assert(getLowestMissingPositiveInteger(new int[]{1}) == 2);
        assert(getLowestMissingPositiveInteger(new int[]{1, 2, 3, 4, 5, 6}) == 7);
        assert(getLowestMissingPositiveInteger(new int[]{1, 2, 7, 4}) == 3);
        assert(getLowestMissingPositiveInteger(new int[]{-1, -2, -3, -4}) == 1);
        assert(getLowestMissingPositiveInteger(new int[]{-1, -2, -3, 1, -4}) == 2);
        assert(getLowestMissingPositiveInteger(new int[]{3, 4, -1, 1, 7, -3, 5}) == 2);
        assert(getLowestMissingPositiveInteger(new int[]{1, 2, 0}) == 3);
    }

    /**
     * Gets the lowest positive integer missing from an array of integers.
     *
     * @param array the array to search
     *
     * @return The lowest positive integer missing from the array.
     */
    public static int getLowestMissingPositiveInteger(final int[] array) {

        final int start = shiftNonPositiveIntegers(array);

        for (int i = start; i < array.length; i++) {

            final int valueIndex = Math.abs(array[i]) + start - 1;

            if (valueIndex < array.length && array[valueIndex] > 0) {
                array[valueIndex] *= -1;
            }
        }

        for (int i = start; i < array.length; i++) {

            if (array[i] > 0) {
                return i - start + 1;
            }
        }

        return (array.length - start) + 1;
    }

    /**
     * Shifts all non-positive integers in an array to the start of the array.
     *
     * @param array the array
     *
     * @return The index of the first positive integer in the array after shifting non-positive integers.
     */
    private static int shiftNonPositiveIntegers(final int[] array) {

        int j = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] < 1) {
                swap(array, i, j);
                j++;
            }
        }

        return j;
    }

    /**
     * Swaps two integers in an array.
     *
     * @param array the array containing the integers to swap
     * @param i The index of the first integer
     * @param j The index of the second integer
     */
    private static void swap(final int[] array, final int i, final int j) {

        final int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
