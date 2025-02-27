import java.util.Scanner;

/**
 * The LandscapeService class provides functionality to manipulate a 2D array that represents a rectangular yard.
 * The main method simulates adding a house, trees, squirrels, flowers, and grass to a yard.
 * Array dimensions are given as rows x columns.
 * All methods assume a non-empty, rectangular 2D array is passed as a parameter.
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
     * Assign the middle cell to a given string.
     * For even columns, set the cell with the larger column index in the central region.
     * For even rows, set the cell with the larger row index in the central region.
     *
     * @param matrix The 2D array.
     * @param value The string to assign the middle cell to.
     */
    public static void setMiddleCell(String[][] matrix, String value) {

        // Calculate center indices. For even dimensions, set lower-right center element
        int row = matrix.length / 2;
        int col = matrix[0].length / 2;

        // Assuming rectangular, assign the center value
        matrix[row][col] = value;
    }

    /**
     * Sets the four corners of the array to a given string.
     *
     * @param matrix The 2D array.
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
        System.out.println("Enter rows and columns:");
        int rows = in.nextInt();
        int cols = in.nextInt();

        //Create rows X cols sized yard
        String[][] myYard = new String[rows][cols];


        //Fill the yard with dirt
        fillMatrix(myYard, BROWN_SQUARE);

        //Add a house in the middle
        setMiddleCell(myYard, HOUSE);

        //Add trees in corners
        setCornerCells(myYard, TREE);

        //Replace dirt with grass
        replaceTargetValue(myYard, BROWN_SQUARE, GREEN_SQUARE);

        //Surround house with flowers
        findAndUpdateAdjacentCells(myYard, HOUSE, FLOWER);

        //Surround trees with squirrels
        findAndUpdateAdjacentCells(myYard, TREE, SQUIRREL);

        //Print final result
        printMatrix(myYard);

    }
}
