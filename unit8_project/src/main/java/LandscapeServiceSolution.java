import java.util.Scanner;

/**
 * The LandscapeService class provides functionality to manipulate a 2D array that represents a rectangular yard.
 * The allows for adding elements like houses, trees, squirrels, flowers, and grass to a yard.
 * 2D array dimensions are given as rows x columns
 */
public class LandscapeServiceSolution {
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
    public static void printMatrix(String[][] matrix) {
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
     * @param fillValue The value to fill the array with.
     */
    public static void fillMatrix(String[][] matrix, String fillValue) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = fillValue;
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
     * Assign the central cell to a given string.
     * For even dimensions, it sets the lower-right central element.
     *
     * @param matrix The 2D array.
     * @param value The string to assign the central cell to.
     */
    public static void setCenterCell(String[][] matrix, String value) {
        // Check for empty matrix
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        // Calculate center indices. For even dimensions, set lower-right center element
        int row = matrix.length / 2;
        int col = matrix[0].length / 2;

        // Assuming a rectangular shape, directly assign the center value
        matrix[row][col] = value;
    }

    /**
     * Sets the four corners of the array to a given string.
     *
     * @param matrix The 2D array.
     * @paramvalue The string to set in the corners.
     */
    public static void setCornerCells(String[][] matrix, String value) {
        // Check for empty array
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        matrix[0][0] = value;  // Top-left
        matrix[0][cols - 1] = value;  // Top-right
        matrix[rows - 1][0] = value;  // Bottom-left
        matrix[rows - 1][cols - 1] = value;  // Bottom-right
    }


    /**
     * Replaces all occurrences of the oldValue string in the matrix with the newValue string.
     *
     * @param matrix The 2D array.
     * @param oldValue The string to replace.
     * @param newValue The string to replace the oldValue with.
     */
    public static void replaceValue(String[][] matrix, String oldValue, String newValue) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (oldValue.equals(matrix[row][col])){
                    matrix[row][col]  = newValue;
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
     * @param surroundingValue The string to surround the target cell with.
     */
    public static void setSurroundingCells(String[][] matrix, int row, int col, String surroundingValue) {
        // Directions for surrounding cells (row and column offsets)
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Loop through all 8 surrounding directions
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (isValidIndex(matrix, newRow, newCol)) {
                matrix[newRow][newCol] = surroundingValue;
            }
        }
    }

    /**
     * Loops through the entire array and surrounds all occurrences of a target string with a specified string.
     *
     * @param matrix The 2D array.
     * @param targetValue The string to find and surround.
     * @param newValue The string to surround the target with.
     */
    public static void surroundMatchingCells(String[][] matrix, String targetValue, String newValue) {
        // Find each cell matching the target value and update the surrounding cells
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (targetValue.equals(matrix[row][col])) {
                    setSurroundingCells(matrix, row, col, newValue);
                }
            }
        }
    }

    /**
     * The main method creates a landscaped yard based on the specified rows and columns.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int rows = in.nextInt();
        int cols = in.nextInt();

        System.out.println(String.format("Creating new %dx%d yard", rows, cols));
        String[][] myYard = new String[rows][cols];  //rows x cols
        printMatrix(myYard);

        System.out.println("Filling the yard with dirt");
        fillMatrix(myYard, BROWN_SQUARE);
        printMatrix(myYard);

        System.out.println("Adding a house in the middle of the yard");
        setCenterCell(myYard, HOUSE);
        printMatrix(myYard);

        System.out.println("Add trees in corners");
        setCornerCells(myYard, TREE);
        printMatrix(myYard);

        System.out.println("Surround house with flowers");
        surroundMatchingCells(myYard, HOUSE, FLOWER);
        printMatrix(myYard);

        System.out.println("Surround trees with squirrels");
        surroundMatchingCells(myYard, TREE, SQUIRREL);
        printMatrix(myYard);

        System.out.println("Replace dirt with grass");
        replaceValue(myYard, BROWN_SQUARE, GREEN_SQUARE);
        printMatrix(myYard);
    }
}
