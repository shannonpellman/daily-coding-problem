import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;

class DailyCodingProblem061 {

    private static final int NUM_EXECUTIONS = 1000000;

    public static void main(String[] args) {

        assert(args.length == 2);

        final int x = Integer.parseInt(args[0]);
        final int y = Integer.parseInt(args[1]);

        assert(x >= 0);
        assert(y >= 0);

        System.out.printf("powNaive (%d executions): %dms\n", NUM_EXECUTIONS,
                profile(() -> powNaive(x, y), NUM_EXECUTIONS));

        System.out.printf("pow (%d executions): %dms\n", NUM_EXECUTIONS,
                profile(() -> pow(x, y), NUM_EXECUTIONS));
    }

    /**
     * Naive (O(n)) implementation of integer exponentiation.
     *
     * @param x Base
     * @param y Exponent
     *
     * @return x^y
     */
    public static int powNaive(final int x, final int y) {

        int product = 1;

        for (int i = 0; i < y; i++) {
            product *= x;
        }

        return product;
    }

    /**
     * Awesome (O(log n)) implementation of integer exponentiation.
     *
     * @param x Base
     * @param y Exponent
     *
     * @return x^y
     */
    public static int pow(final int x, final int y) {

        if (y == 0) {
            return 1;
        }

        if (y == 1) {
            return x;
        }

        final int p = pow(x, y / 2);

        return p * p * ((y % 2) == 0 ? 1 : x);
    }

    /**
     * Profiles the execution time of a {@link Runnable}.
     *
     * @param r The {@link Runnable} to profile.
     * @param numExecutions The number of times to execute the runnable.
     *
     * @return The time (in ms) it took to execute the {@link Runnable} the specified number of times.
     */
    public static long profile(final Runnable r, final int numExecutions) {

        final long start = System.currentTimeMillis();

        for (int i = 0; i < numExecutions; i++) {
            r.run();
        }

        final long end = System.currentTimeMillis();

        return end - start;
    }
}