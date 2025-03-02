import java.util.Scanner;

/**
 * The LandscapeService class provides functionality to manipulate a 2D array that represents a rectangular yard.
 * The main method simulates adding a house, trees, squirrels, and grass to a yard.
 * Array dimensions are given as rows x columns.
 * All methods assume a non-empty, rectangular 2D array is passed as a parameter.
 */
public class LandscapeServiceSolution {
    static final String TREE = "🌳";      // \uD83C\uDF33
    static final String HOUSE = "🏠";     // \uD83C\uDFE0
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
     * @param matrix The 2D array to be filled with new values.
     * @param fillValue A string that will replace the current value of each cell in the matrix.
     */
    public static void fillMatrix(String[][] matrix, String fillValue) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = fillValue;
            }
        }
    }



    /**
     * Sets the middle cell(s) of a given 2D matrix to a specified value.
     *
     * This method calculates the center of the matrix. If the matrix has even dimensions, it sets
     * the two middle cells (horizontally and vertically) in the center. For odd dimensions,
     * it sets the single middle cell in the center.
     *
     * @param matrix The 2D array (matrix) in which to set the middle cell(s).
     *               It must be a non-empty matrix with at least one row and one column.
     * @param value The value to set the middle cell(s) to. This value will be placed in the calculated
     *              middle(s) of the matrix.
     *
     */
    public static void setMiddleCells(String[][] matrix, String value) {

        // Calculate center indices.
        int row = matrix.length / 2;
        int col = matrix[0].length / 2;

        //Determine which cells in a matrix should be considered the "middle" cells
        //based on whether the dimensions of the matrix are odd or even.
        int[] rowOffsets, colOffsets;
        if (matrix.length % 2 == 0) {
            rowOffsets = new int[] {-1, 0}; // Two vertical middle cells
        } else {
            rowOffsets = new int[] {0}; // Single vertical middle cell
        }
        if (matrix[0].length % 2 == 0) {
            colOffsets = new int[] {-1, 0}; // Two horizontal middle cells
        } else {
            colOffsets = new int[] {0}; // Single horizontal middle cell
        }

        // Assign 1, 2, or 4 center cells based on matrix dimensions
        for (int r : rowOffsets) {
            for (int c : colOffsets) {
                matrix[row + r][col + c] = value;
            }
        }
    }


    /**
     * Sets the four corners of the array to a given string.
     *
     * @param matrix The 2D array (matrix) in which to set the middle cell(s).
     *               It must be a non-empty matrix with at least one row and one column.
     * @paramvalue The string to set in the corners.
     */
    public static void setCornerCells(String[][] matrix, String value) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        matrix[0][0] = value;  // Top-left
        matrix[0][cols - 1] = value;  // Top-right
        matrix[rows - 1][0] = value;  // Bottom-left
        matrix[rows - 1][cols - 1] = value;  // Bottom-right
    }


    /**
     * Replaces all occurrences of a target string in the matrix with the specified new value.
     *
     * @param matrix The 2D array.
     * @param targetValue The string to be replaced.
     * @param newValue The string to replace the target with.
     */
    public static void replaceTargetValue(String[][] matrix, String targetValue, String newValue) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (targetValue.equals(matrix[row][col])){
                    matrix[row][col]  = newValue;
                }
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
     * Assigns a new value to the cells adjacent to the given cell in all 8 directions
     * (top-left, top, top-right, left, right, bottom-left, bottom, and bottom-right).
     * The method checks the validity of the indices before updating an adjacent cell.
     *
     * @param matrix The 2D array representing the matrix.
     * @param row The row index of the given cell.
     * @param col The column index of the given cell.
     * @param newValue The string value to assign to the adjacent cells.
     */
    public static void setAdjacentCells(String[][] matrix, int row, int col, String newValue) {
        // Directions for adjacent cells (row and column offsets)
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Loop through all 8 adjacent directions
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (isValidIndex(matrix, newRow, newCol)) {
                matrix[newRow][newCol] = newValue;
            }
        }
    }

    /**
     * Finds each cell in the matrix that matches the specified target value
     * and updates its adjacent cells to the specified new value.
     *
     * The method iterates through the entire matrix and, when a cell containing
     * the target value is found, updates the adjacent cells by calling the
     * setAdjacentCells(String[][], int, int, String) method.
     *
     * @param matrix The 2D array representing the matrix to search through.
     * @param targetValue The string value to search for in the matrix.
     * @param newValue The string value to assign to the adjacent cells of the matching target cells.
     */
    public static void findAndUpdateAdjacentCells(String[][] matrix, String targetValue, String newValue) {
        // Loop through the entire matrix to find cells that match the target value
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                // If the current cell matches the target value, update the adjacent cells
                if (targetValue.equals(matrix[row][col])) {
                    // Call the existing method to update adjacent cells
                    setAdjacentCells(matrix, row, col, newValue);
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
        System.out.print("Enter rows and columns: ");
        int rows = in.nextInt();
        int cols = in.nextInt();

        //Create rows X cols sized yard
        String[][] myYard = new String[rows][cols];

        //Fill the yard with dirt
        fillMatrix(myYard, BROWN_SQUARE);

        //Add a house
        setMiddleCells(myYard, HOUSE);

        //Add trees in corners
        setCornerCells(myYard, TREE);

        //Replace dirt with grass
        replaceTargetValue(myYard, BROWN_SQUARE, GREEN_SQUARE);

        //Surround trees with squirrels
        findAndUpdateAdjacentCells(myYard, TREE, SQUIRREL);

        //Print final result
        printMatrix(myYard);

    }
}
