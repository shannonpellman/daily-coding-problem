import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * An abstract node.
 */
class Node implements Serializable {

    private static final String DELIMITER = " ";

    /**
     * This node's value.
     */
    public String val;

    /**
     * This node's left node.
     */
    public Node left;

    /**
     * This node's right node.
     */
    public Node right;

    /**
     * Value-only constructor.
     *
     * @param val The node's value
     */
    public Node(final String val) {

        this(val, null, null);
    }

    /**
     * All-parameter constructor.
     *
     * @param val The node's value
     * @param left  The left node
     * @param right The right node
     */
    public Node(final String val, final Node left, final Node right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Creates a new {@link Node} from a string.
     *
     * @param string A serialized {@link Node}
     *
     * @return A {@link Node} object
     */
    public static Node fromString(final String string) {

        DeserializationState state = fromStringRecursive(new LinkedList<>(Arrays.asList(string.split(DELIMITER))), 0);

        return state.node;
    }

    /**
     * Serializes this {@link Node}.
     *
     * @return A string representing this {@link Node}
     */
    public String toString() {

        return String.format("%1$s%4$s%2$s%4$s%3$s", this.val, this.left, this.right, DELIMITER);
    }

    /**
     * Recursive deserialization helper method.
     *
     * @param strings List of strings to be deserialized
     * @param start The list index to begin deserialization
     *
     * @return A {@link DeserializationState} representing the current deserialization state
     */
    private static DeserializationState fromStringRecursive(final List<String> strings, final int start) {

        final String value = strings.get(start);

        if (value.equals("null")) {
            return new DeserializationState(null, start + 1);
        }

        final DeserializationState left = fromStringRecursive(strings, start + 1);
        final DeserializationState right = fromStringRecursive(strings, left.nextIndex);

        return new DeserializationState(new Node(value, left.node, right.node), right.nextIndex);
    }

    /**
     * Represents the deserialization state.
     */
    private final static class DeserializationState {

        /**
         * The {@link Node} being deserialized
         */
        private final Node node;

        /**
         * The index of the next list item to deserialize
         */
        private final int nextIndex;

        /**
         * Constructor.
         *
         * @param node The {@link Node} being deserialized
         * @param nextIndex The index of the next list item to deserialize
         */
        private DeserializationState(Node node, int nextIndex) {

            this.node = node;
            this.nextIndex = nextIndex;
        }
    }
}