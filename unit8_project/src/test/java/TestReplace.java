import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the replace method in the LandscapeService class.
 */
public class TestReplace {

    @Test
    public void testReplace3x3Matrix() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "A", "E"},
                {"F", "G", "A"}
        };
        String target = "A";
        String replacement = "X";

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertEquals("X", matrix[0][0], "Position (0,0) should be replaced with " + replacement);
        assertEquals("X", matrix[1][1], "Position (1,1) should be replaced with " + replacement);
        assertEquals("X", matrix[2][2], "Position (2,2) should be replaced with " + replacement);
        assertEquals("B", matrix[0][1], "Position (0,1) should remain " + "B");
        assertEquals("D", matrix[1][0], "Position (1,0) should remain " + "D");
    }

    @Test
    public void testReplaceWithNoMatch() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String target = "X";  // Target that does not exist in the matrix
        String replacement = "Y";  // Replacement value

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertEquals("A", matrix[0][0], "Position (0,0) should remain A");
        assertEquals("B", matrix[0][1], "Position (0,1) should remain B");
        assertEquals("C", matrix[0][2], "Position (0,2) should remain C");
        assertEquals("D", matrix[1][0], "Position (1,0) should remain D");
        assertEquals("E", matrix[1][1], "Position (1,1) should remain E");
        assertEquals("F", matrix[1][2], "Position (1,2) should remain F");
        assertEquals("G", matrix[2][0], "Position (2,0) should remain G");
        assertEquals("H", matrix[2][1], "Position (2,1) should remain H");
        assertEquals("I", matrix[2][2], "Position (2,2) should remain I");
    }

    @Test
    public void testReplaceSingleElementMatrix() {
        // Arrange
        String[][] matrix = {{"A"}};  // 1x1 matrix
        String target = "A";
        String replacement = "B";

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertEquals("B", matrix[0][0], "The single element should be replaced with " + replacement);
    }

    @Test
    public void testReplaceEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String target = "A";
        String replacement = "B";

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }

    @Test
    public void testReplaceWithNullTarget() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String target = null;  // Null target value
        String replacement = "X";

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertEquals("X", matrix[0][0], "Position (0,0) should be replaced with X");
        assertEquals("B", matrix[0][1], "Position (0,1) should remain B");
        assertEquals("C", matrix[0][2], "Position (0,2) should remain C");
        assertEquals("D", matrix[1][0], "Position (1,0) should remain D");
        assertEquals("E", matrix[1][1], "Position (1,1) should remain E");
        assertEquals("F", matrix[1][2], "Position (1,2) should remain F");
        assertEquals("G", matrix[2][0], "Position (2,0) should remain G");
        assertEquals("H", matrix[2][1], "Position (2,1) should remain H");
        assertEquals("I", matrix[2][2], "Position (2,2) should remain I");
    }

    @Test
    public void testReplaceWithNullReplacement() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"A", "E", "F"},
                {"G", "H", "A"}
        };
        String target = "A";
        String replacement = null;  // Null replacement value

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        assertNull(matrix[0][0], "Position (0,0) should be replaced with null");
        assertNull(matrix[1][0], "Position (1,0) should be replaced with null");
        assertNull(matrix[2][2], "Position (2,2) should be replaced with null");
        assertEquals("B", matrix[0][1], "Position (0,1) should remain B");
        assertEquals("C", matrix[0][2], "Position (0,2) should remain C");
    }
}

