import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LandscapeService class, specifically the fillArray method.
 */
public class TestFill {

    // Helper method to validate matrix filling
    private void validateMatrixFill(String[][] matrix, String val) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                assertEquals(val, matrix[row][col], "Matrix value at position (" + row + "," + col + ") should be " + val);
            }
        }
    }

    @Test
    public void testFill3x4Matrix() {
        // Arrange
        String[][] matrix = new String[3][4];  // 3x4 matrix
        String val = "A";  // value to fill the matrix with

        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        validateMatrixFill(matrix, val);
    }

    @Test
    public void testFill2x2Matrix() {
        // Arrange
        String[][] matrix = new String[2][2];  // 2x2 matrix
        String val = "B";  // value to fill the matrix with

        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        validateMatrixFill(matrix, val);
    }

    @Test
    public void testFill1x1Matrix() {
        // Arrange
        String[][] matrix = new String[1][1];  // 1x1 matrix
        String val = "C";  // value to fill the matrix with

        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Matrix value at position (0,0) should be " + val);
    }

    @Test
    public void testFillEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String val = "";  // value to fill the matrix with

        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }

    @Test
    public void testFillMatrixWithNullValue() {
        // Arrange
        String[][] matrix = new String[3][3];  // 3x3 matrix
        String val = null;  // null value to fill the matrix with

        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        validateMatrixFill(matrix, val);
    }
}
