import java.util.function.BiFunction;
import java.util.function.Function;

public class DailyCodingProblem005 {

    public static void main(String[] args) {

        assert(car(cons(3, 4)) == 3);
        assert(cdr(cons(3, 4)) == 4);
        assert(car(cons('a', 'b')) == 'a');
        assert(cdr(cons(null, true)));
    }

    /**
     * Constructs a pair.
     *
     * @param a first item in the pair
     * @param b second item in the pair
     * @param <T> the type of a and b
     *
     * @return A {@link Function} that accepts a {@link BiFunction} and returns an item from the pair.
     */
    public static <T> Function<BiFunction<T, T, T>, T> cons(final T a, final T b) {

        return (f) -> f.apply(a, b);
    }

    /**
     * Retrieves the first item from a pair.
     *
     * @param pair the pair containing items to retrieve
     * @param <T> the type of the items in the pair
     *
     * @return The first item in the pair.
     */
    public static <T> T car(final Function<BiFunction<T, T, T>, T> pair) {

        return pair.apply((a, b) -> a);
    }

    /**
     * Retrieves the second item from a pair.
     *
     * @param pair the pair containing items to retrieve
     * @param <T> the type of the items in the pair
     *
     * @return The second item in the pair.
     */
    public static <T> T cdr(final Function<BiFunction<T, T, T>, T> pair) {

        return pair.apply((a, b) -> b);
    }
}
