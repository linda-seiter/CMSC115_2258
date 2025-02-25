import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the surround method in the LandscapeService class.
 */
public class TestSurround {

    // Helper method to print the matrix for debugging
    private void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testSurroundWithValidPosition() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 1;
        int col = 1;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check the surrounding cells
        assertEquals("X", matrix[0][0], "Top-left should be X");
        assertEquals("X", matrix[0][1], "Top should be X");
        assertEquals("X", matrix[0][2], "Top-right should be X");
        assertEquals("X", matrix[1][0], "Left should be X");
        assertEquals("E", matrix[1][1], "Center (should remain unchanged) should be E");
        assertEquals("X", matrix[1][2], "Right should be X");
        assertEquals("X", matrix[2][0], "Bottom-left should be X");
        assertEquals("X", matrix[2][1], "Bottom should be X");
        assertEquals("X", matrix[2][2], "Bottom-right should be X");
    }

    @Test
    public void testSurroundTopLeftCorner() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 0;
        int col = 0;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check the surrounding cells of the top-left corner
        assertEquals("X", matrix[0][1], "Top should be X");
        assertEquals("X", matrix[1][0], "Left should be X");
        assertEquals("X", matrix[1][1], "Bottom-right should be X");
    }

    @Test
    public void testSurroundBottomRightCorner() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 2;
        int col = 2;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check the surrounding cells of the bottom-right corner
        assertEquals("X", matrix[1][1], "Top-left should be X");
        assertEquals("X", matrix[1][2], "Top should be X");
        assertEquals("X", matrix[2][1], "Left should be X");
    }

    @Test
    public void testSurroundEdgeCaseFirstRow() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 0;
        int col = 1;  // Second column of the first row
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check surrounding cells for first row, second column
        assertEquals("X", matrix[0][0], "Top-left should be X");
        assertEquals("B", matrix[0][1], "Top should be B");
        assertEquals("X", matrix[0][2], "Top-right should be X");
        assertEquals("X", matrix[1][0], "Left should be X");
        assertEquals("X", matrix[1][2], "Right should be X");
    }

    @Test
    public void testSurroundEdgeCaseLastRow() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 2;
        int col = 1;  // Second column of the last row
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check surrounding cells for last row, second column
        assertEquals("X", matrix[1][0], "Left should be X");
        assertEquals("X", matrix[1][1], "Center should be X");
        assertEquals("X", matrix[1][2], "Right should be X");
        assertEquals("X", matrix[2][0], "Bottom-left should be X");
        assertEquals("X", matrix[2][2], "Bottom-right should be X");
    }

    @Test
    public void testSurroundEdgeCaseFirstColumn() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        int row = 1;
        int col = 0;  // First column, middle row
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert: Check surrounding cells for first column
        assertEquals("X", matrix[0][0], "Top-left should be X");
        assertEquals("X", matrix[0][1], "Top should be X");
        assertEquals("X", matrix[1][1], "Right should be X");
        assertEquals("X", matrix[2][0], "Bottom-left should be X");
        assertEquals("X", matrix[2][1], "Bottom-right should be X");
    }

    @Test
    public void testSurroundEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        int row = 0;
        int col = 0;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }
}
