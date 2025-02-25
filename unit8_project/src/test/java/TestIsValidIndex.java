import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LandscapeService class, specifically the isValidIndex method.
 */
public class TestIsValidIndex {

    @Test
    public void testValidIndexWithinBounds() {
        // Arrange
        String[][] matrix = new String[3][5];  // 3x5 matrix

        // Act & Assert
        // Corners
        assertTrue(LandscapeService.isValidIndex(matrix, 0, 0), "Index (0,0) should be valid in a 3x5 matrix");
        assertTrue(LandscapeService.isValidIndex(matrix, 0, 4), "Index (0,4) should be valid in a 3x5 matrix");
        assertTrue(LandscapeService.isValidIndex(matrix, 2, 0), "Index (2,0) should be valid in a 3x5 matrix");
        assertTrue(LandscapeService.isValidIndex(matrix, 2, 4), "Index (2,4) should be valid in a 3x5 matrix");
        // Non-corner
        assertTrue(LandscapeService.isValidIndex(matrix, 1, 2), "Index (1,2) should be valid in a 3x5 matrix");
    }

    @Test
    public void testInvalidIndexOutOfBounds() {
        // Arrange
        String[][] matrix = new String[3][5];  // 3x5 matrix

        // Act & Assert
        assertFalse(LandscapeService.isValidIndex(matrix, -1, 0), "Index (-1,0) should be invalid in a 3x5 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, 3, 0), "Index (3,0) should be invalid in a 3x5 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, 0, -1), "Index (0,-1) should be invalid in a 3x5 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, 0, 5), "Index (0,5) should be invalid in a 3x5 matrix");
    }

    @Test
    public void test1x1Matrix() {
        // Arrange
        String[][] matrix = new String[1][1];  // 1x1 matrix

        // Act & Assert
        assertTrue(LandscapeService.isValidIndex(matrix, 0, 0), "Index (0,0) should be valid in a 1x1 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, -1, 0), "Index (-1,0) should be invalid in a 1x1 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, 1, 0), "Index (1,0) should be invalid in a 1x1 matrix");
        assertFalse(LandscapeService.isValidIndex(matrix, 0, -1), "Index (0,-1) should be invalid in a 1x1 matrix");
    }

    @Test
    public void testEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String val = "";  // value to fill the matrix with

        // Act & Assert
        assertFalse(LandscapeService.isValidIndex(matrix, 0,0), "Empty matrix has no valid indices");

    }

}
