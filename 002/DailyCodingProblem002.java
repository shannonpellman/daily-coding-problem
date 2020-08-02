import java.util.Arrays;

public class DailyCodingProblem002 {

    public static void main(String[] args) {

        assert(Arrays.equals(productsOfOthers(new int[]{1, 2, 3, 4, 5}), new int[]{120, 60, 40, 30, 24}));
        assert(Arrays.equals(productsOfOthers(new int[]{2, -1, 3}), new int[]{-3, 6, -2}));
        assert(Arrays.equals(productsOfOthers(new int[]{2}), new int[]{1}));

        assert(Arrays.equals(productOfOthersNoDivision(new int[]{1, 2, 3, 4, 5}), new int[]{120, 60, 40, 30, 24}));
        assert(Arrays.equals(productOfOthersNoDivision(new int[]{2, -1, 3}), new int[]{-3, 6, -2}));
        assert(Arrays.equals(productOfOthersNoDivision(new int[]{2}), new int[]{1}));
    }

    /**
     * Returns a new array such that each element at index i is the product
     * of all elements in the original except the element at i.
     *
     * @param original The original array
     *
     * @return A new array
     */
    public static int[] productsOfOthers(final int[] original) {

        final int product = Arrays.stream(original).reduce(1, (a, b) -> a * b);

        return Arrays.stream(original).map(x -> product / x).toArray();
    }

    /**
     * Returns a new array such that each element at index i is the product
     * of all elements in the original except the element at i.
     *
     * @param original The original array
     *
     * @return A new array
     */
    public static int[] productOfOthersNoDivision(final int[] original) {

        final int[] newArray = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            newArray[i] = productOfOthersExcept(original, i);
        }

        return newArray;
    }

    /**
     * Computes the product of all integers in an array except one at a given position.
     *
     * @param integers Array of integers
     * @param exception The position to exclude from the product
     *
     * @return The product of all integers in an array except one at the given position
     */
    private static int productOfOthersExcept(final int[] integers, final int exception) {

        int product = 1;

        for (int i = 0; i < integers.length; i++) {
            if (i != exception) {
                product *= integers[i];
            }
        }

        return product;
    }
}
