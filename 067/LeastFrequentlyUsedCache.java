import java.util.HashMap;
import java.util.Map;

/**
 * A cache that removes the least frequently used object when full.
 */
public class LeastFrequentlyUsedCache {

    /**
     * An object stored in the {@link LeastFrequentlyUsedCache}.
     */
    static class CacheObject {

        /**
         * The key associated with the value.
         */
        public String key;

        /**
         * The value associated with the key.
         */
        public Object value;

        /**
         * The number of times this value has been retrieved from the cache.
         */
        public int counter;

        /**
         * The next most frequently used object in the cache (left.counter >= this.counter).
         */
        public CacheObject left;

        /**
         * The next least frequently used object in the cache (right.counter <= this.counter).
         */
        public CacheObject right;

        /**
         * Constructor.
         *
         * @param key the key with which the specified value is to be associated
         * @param value the value to be associated with the specified key
         */
        public CacheObject(final String key, final Object value) {

            this.key = key;
            this.value = value;
            this.counter = 0;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * A linked list for sorting cache objects access frequency.
     */
    static class LinkedList {

        public CacheObject tail = null;

        /**
         * Appends an item to the list.
         *
         * @param cacheObject The cache object to append.
         */
        public void append(final CacheObject cacheObject) {

            if (tail != null) {
                tail.right = cacheObject;
                cacheObject.left = tail;
            }

            tail = cacheObject;
        }

        /**
         * Removes the least frequently used object from the list.
         *
         * @return The least frequently used object in the cache.
         */
        public CacheObject removeTail() {

            final CacheObject leastFrequentlyUsedObject = tail;

            tail = leastFrequentlyUsedObject.left;
            tail.right = null;
            leastFrequentlyUsedObject.left = null;

            return leastFrequentlyUsedObject;
        }

        /**
         * Swaps the positions of two objects in the list.
         *
         * @param a the first object to swap
         * @param b the second object to swap
         */
        public void swap(final CacheObject a, final CacheObject b) {

            final CacheObject leftest = a.left;
            final CacheObject rightest = b.right;

            a.left = b;
            a.right = rightest;
            b.left = leftest;
            b.right = a;
            leftest.right = b;
            rightest.left = a;
        }
    }

    /**
     * The current size of the cache.
     */
    private int currentSize;

    /**
     * The maximum size of the cache.
     */
    private final int maximumSize;

    /**
     * A map used for storing cache objects.
     */
    private final Map<String, CacheObject> map;

    /**
     * A linked list containing cache objects sorted by access frequency.
     */
    private final LinkedList list;

    /**
     * Constructor.
     *
     * @param maximumSize the maximum cache size
     */
    public LeastFrequentlyUsedCache(final int maximumSize) {

        this.currentSize = 0;
        this.maximumSize = maximumSize;
        this.map = new HashMap<>();
        this.list = new LinkedList();
    }

    /**
     * Gets a value by its key.
     *
     * @param key the key whose associated value is to be returned
     *
     * @return The value associated with the key, or null if no such key exists.
     */
    public Object get(final String key) {

        if (!map.containsKey(key)) {
            return null;
        }

        final CacheObject cacheObject = map.get(key);
        cacheObject.counter++;

        if (cacheObject.left != null && cacheObject.counter >= cacheObject.left.counter) {
            list.swap(cacheObject.left, cacheObject);
        }

        return cacheObject.value;
    }

    /**
     * Adds a value to the cache. If the cache is full, the least frequently used value
     * is removed. If there is a tie, the least recently used value is removed.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void set(final String key, final Object value) {

        if (this.currentSize >= this.maximumSize) {
            removeLeastFrequentlyUsedObject();
        }

        final CacheObject cacheObject = new CacheObject(key, value);
        map.put(key, cacheObject);
        list.append(cacheObject);

        currentSize++;
    }

    /**
     * Removes the least frequently used object from the cache.
     */
    private void removeLeastFrequentlyUsedObject() {

        final CacheObject leastFrequentlyUsedObject = list.removeTail();
        map.remove(leastFrequentlyUsedObject.key);

        currentSize--;
    }
}
