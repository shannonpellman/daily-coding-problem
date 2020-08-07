public class DailyCodingProblem008 {

    /**
     * Binary tree node.
     */
    static class Node {

        final int value;
        final Node left;
        final Node right;

        /**
         * Value-only constructor.
         *
         * @param value the node value
         */
        Node(final int value) {

            this(value, null, null);
        }

        /**
         * All-arguments constructor.
         *
         * @param value the node value
         * @param left the left node
         * @param right the right node
         */
        Node(final int value, final Node left, final Node right) {

            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        assert (1 == countUnivalTrees(new Node(0)));

        assert (1 == countUnivalTrees(new Node(0, new Node(1), null)));

        assert (1 == countUnivalTrees(new Node(1, new Node(1), null)));

        assert (3 == countUnivalTrees(new Node(1, new Node(1), new Node(1))));

        assert (5 == countUnivalTrees(new Node(0,
                new Node(1, null, null),
                new Node(0,
                        new Node(
                                1,
                                new Node(1, null, null),
                                new Node(1, null, null)
                        ),
                        new Node(0, null, null)))));

        assert (5 == countUnivalTrees(new Node(0,
                new Node(1, null, null),
                new Node(0,
                        new Node(
                                1,
                                new Node(1, null, null),
                                new Node(1, null, null)
                        ),
                        new Node(0, null, new Node(1))))));
    }

    /**
     * Counts the number of unival subtrees in a given binary tree.
     *
     * @param node the root node to a binary tree
     *
     * @return The number of unival subtrees in the binary tree.
     */
    public static int countUnivalTrees(final Node node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        final int numUnivalSubtreesLeft = countUnivalTrees(node.left);
        final int numUnivalSubtreesRight = countUnivalTrees(node.right);

        final boolean isUnivalLeft = node.left != null
                && node.value == node.left.value
                && numUnivalSubtreesLeft > 0;

        final boolean isUnivalRight = node.right != null
                && node.value == node.right.value
                && numUnivalSubtreesRight > 0;

        return (isUnivalLeft && isUnivalRight ? 1 : 0) + numUnivalSubtreesLeft + numUnivalSubtreesRight;
    }
}
