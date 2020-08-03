public class DailyCodingProblem063 {

    public static void main(String[] args) {

        final char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'},
        };

        final String[] words = {"FOAM", "NOB", "MASS", "JAVA"};

        for (final String word : words) {
            System.out.printf("\"%s\" %s in character matrix\n", word,
                    doesMatrixContainWord(matrix, word.toCharArray()) ? "exists" : "does not exist");
        }
    }

    /**
     * Checks if a given word exists in a character matrix.
     *
     * @param matrix the character matrix to check
     * @param word the word to search for
     *
     * @return True if the word exists in the character matrix, otherwise false.
     */
    public static boolean doesMatrixContainWord(final char[][] matrix, final char[] word) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (doesWordExistAtPosition(matrix, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if a given word exists at a given position in a character matrix.
     *
     * @param matrix the character matrix to check
     * @param word the word to search for
     * @param row the row to check
     * @param column the column to check
     *
     * @return True if the word exists at the given position in the character matrix, otherwise false.
     */
    private static boolean doesWordExistAtPosition(final char[][] matrix, final char[] word, final int row, final int column) {

        return doesWordExistHorizontallyAtPosition(matrix, word, row, column)
                || doesWordExistVerticallyAtPosition(matrix, word, row, column);
    }

    /**
     * Checks if a given word exists horizontally at a given position in a character matrix.
     *
     * @param matrix the character matrix to check
     * @param word the word to search for
     * @param row the row to check
     * @param column the column to check
     *
     * @return True if the word exists horizontally at the given position in the character matrix, otherwise false.
     */
    private static boolean doesWordExistHorizontallyAtPosition(final char[][] matrix, final char[] word, final int row, final int column) {

        int w = 0;

        for (int c = column; c < matrix[row].length; c++, w++) {
            if (matrix[row][c] != word[w]) {
                return false;
            }
        }

        return w == word.length;
    }

    /**
     * Checks if a given word exists vertically at a given position in a character matrix.
     *
     * @param matrix the character matrix to check
     * @param word the word to search for
     * @param row the row to check
     * @param column the column to check
     *
     * @return True if the word exists vertically at the given position in the character matrix, otherwise false.
     */
    private static boolean doesWordExistVerticallyAtPosition(final char[][] matrix, final char[] word, final int row, final int column) {

        int w = 0;

        for (int r = row; r < matrix.length && w < word.length; r++, w++) {
            if (matrix[r][column] != word[w]) {
                return false;
            }
        }

        return w == word.length;
    }
}
