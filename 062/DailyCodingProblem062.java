public class DailyCodingProblem062 {

    public static void main(String[] args) {

        assert(countPaths(5, 5) == 70);
        assert(countPaths(2, 2) == 2);
        assert(countPaths(1, 1) == 1);
        assert(countPaths(3, 2) == 5);
    }

    /**
     * Counts the numbers of ways to move from the top-left corner of a
     * N x M matrix to the bottom-right corner moving only right or down.
     *
     * @param n The number of rows in the matrix
     * @param m THe number of columns in the matrix
     *
     * @return The number of ways to move move from the top-left corner of a
     *         N x M matrix to the bottom-right corner moving only right or down.
     */
    public static int countPaths(final int n, final int m) {

        return factorial(n + m - 2) / (factorial(n - 1) * factorial(m - 1));
    }

    /**
     * Calculates the factorial of an integer.
     *
     * @param n The integer to calculate the factorial for.
     *
     * @return n!
     */
    private static int factorial(final int n) {

        int factorial = 1;

        for (int i = n; i > 0; i--) {
            factorial *= i;
        }

        return factorial;
    }
}
