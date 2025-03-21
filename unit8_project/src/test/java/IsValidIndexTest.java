import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the isValidIndex method in the YardPlanner class.
 */
public class IsValidIndexTest {

    @Test
    public void testValidIndex3x5() {
        // Arrange
        String[][] matrix = new String[3][5];  // 3 rows 5 columns

        // Act & Assert for 4 corners
        assertTrue(YardPlanner.isValidIndex(matrix, 0, 0), "Index (0,0) should be valid in 3x5");
        assertTrue(YardPlanner.isValidIndex(matrix, 0, 4), "Index (0,4) should be valid in 3x5");
        assertTrue(YardPlanner.isValidIndex(matrix, 2, 0), "Index (2,0) should be valid in 3x5");
        assertTrue(YardPlanner.isValidIndex(matrix, 2, 4), "Index (2,4) should be valid in 3x5");
        // Act and Assert for non-corner
        assertTrue(YardPlanner.isValidIndex(matrix, 1, 2), "Index (1,2) should be valid in 3x5");
    }

    @Test
    public void testInvalidIndex5x7() {
        // Arrange
        String[][] matrix = new String[5][7];  //5 rows 7 columns

        // Act & Assert out of bounds
        assertFalse(YardPlanner.isValidIndex(matrix, -1, 0), "Index (-1,0) should be invalid in 5x7");
        assertFalse(YardPlanner.isValidIndex(matrix, 5, 0), "Index (5,0) should be invalid in 5x7");
        assertFalse(YardPlanner.isValidIndex(matrix, 0, -1), "Index (0,-1) should be invalid in 5x7");
        assertFalse(YardPlanner.isValidIndex(matrix, 0, 7), "Index (0,7) should be invalid in 5x7");
    }

    @Test
    public void test1x1() {
        // Arrange
        String[][] matrix = new String[1][1];

        // Act & Assert
        assertTrue(YardPlanner.isValidIndex(matrix, 0, 0), "Index (0,0) should be valid in 1x1");
        assertFalse(YardPlanner.isValidIndex(matrix, -1, 0), "Index (-1,0) should be invalid in 1x1");
        assertFalse(YardPlanner.isValidIndex(matrix, 1, 0), "Index (1,0) should be invalid in 1x1");
        assertFalse(YardPlanner.isValidIndex(matrix, 0, -1), "Index (0,-1) should be invalid in 1x1");
    }

}
