import java.util.Arrays;
import java.util.List;

public class DailyCodingProblem065 {

    public static void main(String[] args) {

        // @formatter:off
        final List<int[][]> matrices = Arrays.asList(
                new int[][]{
                        {1, 2, 3, 4, 5, 6},
                },
                new int[][]{
                        {1},
                        {2},
                        {3},
                        {4},
                },
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                },
                new int[][]{
                        {1, 2},
                        {3, 4},
                        {5, 6},
                        {7, 8},
                },
                new int[][]{
                        {1,  2,  3,  4},
                        {5,  6,  7,  8},
                        {9, 10, 11, 12},
                },
                new int[][]{
                        { 1,  2,  3,  4,  5},
                        { 6,  7,  8,  9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                },
                new int[][]{
                        { 1,  2,  3,  4,  5,  6},
                        { 7,  8,  9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36},
                });
        // @formatter:on

        for (int[][] matrix : matrices) {

            printSpiralClockwise(matrix);
            System.out.println();
        }
    }

    /**
     * Prints a N x M matrix of integers in a clockwise spiral.
     *
     * @param matrix the matrix to print
     */
    public static void printSpiralClockwise(final int[][] matrix) {

        printLoop(matrix, 0);
    }

    /**
     * Prints a single clockwise spiral loop of a N x M matrix of integers.
     *
     * @param matrix    the matrix to print
     * @param loopDepth the depth of the loop to print (0 is the outermost loop)
     */
    public static void printLoop(final int[][] matrix, final int loopDepth) {

        if (2 * loopDepth > Math.max(matrix.length, matrix[0].length)) {
            return;
        }

        printRight(matrix, loopDepth);
        printDown(matrix, loopDepth);
        printLeft(matrix, loopDepth);
        printUp(matrix, loopDepth);

        printLoop(matrix, loopDepth + 1);
    }

    /**
     * Prints the right-directed "edge" of a clockwise spiral loop of a N x M matrix of integers.
     *
     * @param matrix    the matrix to print
     * @param loopDepth the depth of the loop to print (0 is the outermost loop)
     */
    private static void printRight(final int[][] matrix, final int loopDepth) {

        if (loopDepth >= matrix.length || loopDepth >= matrix.length - loopDepth) {
            return;
        }

        for (int i = loopDepth; i < matrix[loopDepth].length - loopDepth; i++) {
            System.out.println(matrix[loopDepth][i]);
        }
    }

    /**
     * Prints the down-directed "edge" of a clockwise spiral loop of a N x M matrix of integers.
     *
     * @param matrix    the matrix to print
     * @param loopDepth the depth of the loop to print (0 is the outermost loop)
     */
    private static void printDown(final int[][] matrix, final int loopDepth) {

        final int M = matrix.length;

        if (loopDepth >= M || loopDepth >= matrix[loopDepth].length - loopDepth) {
            return;
        }

        for (int i = loopDepth + 1; i < M - loopDepth; i++) {
            System.out.println(matrix[i][matrix[loopDepth].length - loopDepth - 1]);
        }
    }

    /**
     * Prints the left-directed "edge" of a clockwise spiral loop of a N x M matrix of integers.
     *
     * @param matrix    the matrix to print
     * @param loopDepth the depth of the loop to print (0 is the outermost loop)
     */
    private static void printLeft(final int[][] matrix, final int loopDepth) {

        final int M = matrix.length;
        final int N = matrix[M - 1].length;

        if (loopDepth >= M - loopDepth - 1) {
            return;
        }

        for (int i = N - loopDepth - 2; i >= loopDepth; i--) {
            System.out.println(matrix[M - loopDepth - 1][i]);
        }
    }

    /**
     * Prints the up-directed "edge" of a clockwise spiral loop of a N x M matrix of integers.
     *
     * @param matrix    the matrix to print
     * @param loopDepth the depth of the loop to print (0 is the outermost loop)
     */
    private static void printUp(final int[][] matrix, final int loopDepth) {

        final int M = matrix.length;

        if (loopDepth >= M || loopDepth >= matrix[loopDepth].length - loopDepth - 1) {
            return;
        }

        for (int i = M - loopDepth - 2; i >= loopDepth + 1; i--) {
            System.out.println(matrix[i][loopDepth]);
        }
    }
}
