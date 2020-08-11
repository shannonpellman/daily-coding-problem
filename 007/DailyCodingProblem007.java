public class DailyCodingProblem007 {

    public static void main(String[] args) {

        assert(3 == countPossibleDecodings("111".toCharArray()));
        assert(1 == countPossibleDecodings("999".toCharArray()));
        assert(1 == countPossibleDecodings("110".toCharArray()));
        assert(1 == countPossibleDecodings("101".toCharArray()));
        assert(2 == countPossibleDecodings("911".toCharArray()));
        assert(2 == countPossibleDecodings("11011".toCharArray()));
        assert(1 == countPossibleDecodings("101010".toCharArray()));
        assert(8 == countPossibleDecodings("11111".toCharArray()));
    }

    /**
     * Counts the number of possible ways to decode a message encoded using the mapping
     * a = 1, b = 2, ... z = 26.
     *
     * @param message the encoded message
     *
     * @return The number of possible ways to decode the message.
     */
    public static int countPossibleDecodings(final char[] message) {

        // contains the number of possible translations at the current token,
        // the previous token, and the token before the previous one
        int[] counts = {1, 1, 1};

        for (int i = 1; i < message.length; i++) {

            if (message[i] == '0') {
                counts[0] = counts[2];
            } else if (message[i - 1] == '1' || (message[i - 1] == '2' && message[i] < '7')) {
                counts[0] = counts[2] + counts[1];
            }

            counts[2] = counts[1];
            counts[1] = counts[0];
        }

        return counts[0];
    }
}
