import java.util.Scanner;

/**
 * The LandscapeService class provides functionality to manipulate a yard represented as a 2D array.
 * It allows for adding elements like houses, trees, squirrels, flowers, and grass to a yard.
 * Methods assume rectangular 2D array.
 */
public class LandscapeService {
    static final String TREE = "🌳";      // \uD83C\uDF33
    static final String HOUSE = "🏠";     // \uD83C\uDFE0
    static final String FLOWER = "🌸";    // \uD83C\uDF38
    static final String SQUIRREL = "🐿️";    // \uD83E\uDDBF
    static final String GREEN_SQUARE =  "🟩"; //\uD83D\uDFE9
    static final String BROWN_SQUARE = "🟫"; //\uD83D\uDFAB

    /**
     * Prints a 2D array.
     *
     * @param matrix The 2D array to be printed.
     */
    public static void printArray(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * Fills a 2D array with a given value.
     *
     * @param matrix The 2D array to be filled.
     * @param val The value to fill the array with.
     */
    public static void fillArray(String[][] matrix, String val) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = val;
            }
        }
    }

    /**
     * Checks if a given index is valid within the bounds of the array.
     *
     * @param matrix The 2D array.
     * @param row The row index.
     * @param col The column index.
     * @return True if the indices are valid, false otherwise.
     */
    public static boolean isValidIndex(String[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

    /**
     * Sets the middle cell of the array to a given string.
     * For even dimensions, it sets the lower-right middle element.
     *
     * @param matrix The 2D array.
     * @param s The string to set in the middle.
     */
    public static void setMiddle(String[][] matrix, String s) {
        //Check for empty array
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        // Calculate middle indices. For even dimensions, set lower-right middle element
        int middleRow = matrix.length / 2;
        int middleCol = matrix[0].length / 2;
        // Guard for non-rectangular shape
        if (isValidIndex(matrix, middleRow, middleCol)) {
            matrix[middleRow][middleCol] = s;
        }
    }

    /**
     * Sets the four corners of the array to a given string.
     *
     * @param matrix The 2D array.
     * @param s The string to set in the corners.
     */
    public static void setCorners(String[][] matrix, String s) {
        //Check for empty array
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        matrix[0][0] = s;  //Top-left
        matrix[0][cols - 1] = s;  //Top-right
        matrix[rows - 1][0] = s;  //Bottom-left
        matrix[rows - 1][cols - 1] = s;  //Bottom-right
    }

    /**
     * Replaces all occurrences of a target string in the array with a replacement string.
     *
     * @param matrix The 2D array.
     * @param target The string to replace.
     * @param replacement The string to replace the target with.
     */
    public static void replace(String[][] matrix, String target, String replacement) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (target.equals(matrix[row][col])){
                    matrix[row][col]  = replacement;
                }
            }
        }
    }

    /**
     * Surrounds a given cell with a specified string in all 8 directions (diagonals and straight directions).
     *
     * @param matrix The 2D array.
     * @param row The row index of the target cell.
     * @param col The column index of the target cell.
     * @param s The string to surround the target cell with.
     */
    public static void surround(String[][] matrix, int row, int col, String s) {
        // Directions for surrounding cells (row and column offsets)
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Loop through all 8 surrounding directions
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (isValidIndex(matrix, newRow, newCol)) {
                matrix[newRow][newCol] = s;
            }
        }
    }

    /**
     * Loops through the entire array and surrounds all occurrences of a target string with a specified string.
     *
     * @param matrix The 2D array.
     * @param target The string to find and surround.
     * @param s The string to surround the target with.
     */
    public static void surroundTarget(String[][] matrix, String target, String s) {
        // Loop through the entire array and find the target, then surround
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (target.equals(matrix[row][col])) {
                    surround(matrix, row, col, s);
                }
            }
        }
    }





    /**
     * The main method where the program starts.
     * It creates a yard based on the user specified height and width, adds objects to it, and prints the changes.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter yard height and width:");
        int height = in.nextInt();
        int width = in.nextInt();

        System.out.println("Creating yard filled with dirt");
        String[][] myYard = new String[height][width];
        fillArray(myYard, BROWN_SQUARE);
        printArray(myYard);

        System.out.println("Adding a house in the middle of the yard");
        setMiddle(myYard, HOUSE);
        printArray(myYard);

        System.out.println("Add trees in corners");
        setCorners(myYard, TREE);
        printArray(myYard);

        System.out.println("Surround house with flowers");
        surroundTarget(myYard, HOUSE, FLOWER);
        printArray(myYard);

        System.out.println("Surround trees with squirrels");
        surroundTarget(myYard, TREE, SQUIRREL);
        printArray(myYard);

        System.out.println("Replace dirt with grass");
        replace(myYard, BROWN_SQUARE, GREEN_SQUARE);
        printArray(myYard);
    }
}
