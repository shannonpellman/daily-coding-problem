import java.util.Arrays;

public class DailyCodingProblem067 {

    public static void main(String[] args) {

        final LeastFrequentlyUsedCache lfuCache = new LeastFrequentlyUsedCache(5);
        lfuCache.set("foo", "foo");
        lfuCache.set("bar", "bar");
        lfuCache.set("baz", "baz");
        lfuCache.set("qux", "qux");
        lfuCache.set("tux", "tux");

        Arrays.asList("foo", "foo", "bar", "baz", "foo", "bar", "baz").forEach(key -> {
            lfuCache.get(key);
        });

        lfuCache.set("oops", "oops");

        assert(lfuCache.get("tux") == null);
    }
}
