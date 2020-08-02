import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DailyCodingProblem001 {

    public static void main(String[] args) {

        test(Arrays.asList(10, 15, 3, 7), 17);
        test(Arrays.asList(19, 6, 5, 8, 4), 7);
        test(Arrays.asList(1, 1, 1), 3);
    }

    /**
     * Checks whether any two elements in a list add up to a target sum.
     *
     * @param list   The list to check
     * @param target The target sum
     * @return True if the list contains two elements that add up to target. Otherwise false.
     */
    public static boolean doesSumOfAnyTwoInListEqual(final List<Integer> list, final int target) {

        final Map<Integer, Integer> d = new HashMap<>();

        for (final int current : list) {

            if (d.containsKey(target - current)) {
                return true;
            }

            // value is null because we only care about the key
            d.put(current, null);
        }

        return false;
    }

    /**
     * Tests whether a list has two elements that add up to k and prints the result.
     *
     * @param list The list to test
     * @param k    The target sum
     */
    private static void test(final List<Integer> list, final int k) {

        System.out.printf("List %s %s two elements that add up to %d\n", list,
                doesSumOfAnyTwoInListEqual(list, k) ? "has" : "does not have", k);
    }
}