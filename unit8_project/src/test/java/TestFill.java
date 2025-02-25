import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LandscapeService class, specifically the fillArray method.
 */
public class TestFill {

    @Test
    public void testFill3x4Matrix() {
        // Arrange
        String[][] matrix = new String[3][4];  // 3x4 matrix
        String val = "A";  // value to fill the matrix with
        String[][] expected = {
                {"A", "A", "A", "A"},
                {"A", "A", "A", "A"},
                {"A", "A", "A", "A"}
        };
        // Act
        LandscapeService.fillArray(matrix, val);

        // Assert
        // Assert no changes
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nFill 3x4 with A" +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testFill2x2Matrix() {
        // Arrange
        String[][] matrix = new String[2][2];  // 2x2 matrix
        String[][] expected = {
                {"B", "B"},
                {"B", "B"}
        };
        // Act
        LandscapeService.fillArray(matrix, "B");

        // Assert
        // Assert no changes
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nFill 2x2 with B" +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
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

}
