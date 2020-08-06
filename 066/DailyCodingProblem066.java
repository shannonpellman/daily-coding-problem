import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class DailyCodingProblem066 {

    private static final int REPETITIONS = 10000;

    public static void main(String[] args) {

        Arrays.asList(5, 25, 50, 75, 95).forEach(initialBias -> {
            final Supplier<Integer> toss_biased = createBiasedCoin(initialBias);

            final int calculatedBias = IntStream.range(0, REPETITIONS)
                    .map(x -> toss_unbiased(toss_biased))
                    .reduce(0, Integer::sum) / (REPETITIONS / 100);

            System.out.printf("Achieved bias of %d-%d using coin with bias of %d-%d\n",
                    calculatedBias, 100 - calculatedBias, initialBias, 100 - initialBias);
        });
    }

    /**
     * Creates a biased coin.
     *
     * @param bias the bias of the coin
     * @return A function that returns the result (0 or 1) of tossing the biased coin.
     */
    public static Supplier<Integer> createBiasedCoin(final int bias) {

        assert (bias >= 0 && bias <= 100);

        final int[] results = new int[100];

        for (int i = 0; i < results.length; i++) {
            results[i] = i < bias ? 1 : 0;
        }

        return () -> {
            final double random = Math.random();
            final int i = (int) (results.length * random);

            return results[i];
        };
    }

    /**
     * Simulates a toss of an unbiased coin using a biased coin;
     *
     * @param toss_biased a function that returns the result (0 or 1) of tossing a biased coin
     *
     * @return The result of the toss (0 or 1)
     */
    public static int toss_unbiased(final Supplier<Integer> toss_biased) {

        final int repetitions = REPETITIONS;

        final int batch1 = IntStream.range(0, repetitions)
                .map(x -> toss_biased.get())
                .reduce(0, Integer::sum);

        final int batch2 = IntStream.range(0, repetitions)
                .map(x -> toss_biased.get())
                .reduce(0, Integer::sum);

        return batch1 > batch2 ? 1 : 0;
    }
}
