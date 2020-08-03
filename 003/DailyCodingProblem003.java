public class DailyCodingProblem003 {

    public static void main(String[] args) {

        final Node node1 = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        assert(deserialize(serialize(node1)).left.left.val.equals("left.left"));

        final Node node2 = new Node("root");
        assert(deserialize(serialize(node2)).val.equals("root"));

        assert(deserialize(serialize(null)) == null);
    }

    public static Node deserialize(final String string) {

        return Node.fromString(string);
    }

    public static String serialize(final Node node) {

        return node.toString();
    }
}
