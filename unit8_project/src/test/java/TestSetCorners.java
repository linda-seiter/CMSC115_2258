import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setCorners method in the LandscapeService class.
 */
public class TestSetCorners {

    @Test
    public void testSetCorners3x4Matrix() {
        // Arrange
        String[][] original = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"}
        };
        String[][] matrix = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"}
        };
        String[][] expected = {
                {"X", "B", "C", "X"},
                {"E", "F", "G", "H"},
                {"X", "J", "K", "X"}
        };

        String replacement = "X";

        // Act
        LandscapeService.setCorners(matrix, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSet Corners with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void testSetCorners1x1Matrix() {
        // Arrange
        String[][] matrix = new String[1][1];  // 1x1 matrix
        String val = "A";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "The only cell (0,0) should be " + val);
    }

    @Test
    public void testSetCornersEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String val = "X";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }

    @Test
    public void testSetCornersMatrixWithOneRow() {
        // Arrange
        String[][] matrix = new String[1][3];  // Matrix with one row
        String val = "B";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[0][2], "Top-right corner should be " + val);
    }

    @Test
    public void testSetCornersMatrixWithOneColumn() {
        // Arrange
        String[][] matrix = new String[3][1];  // Matrix with one column
        String val = "C";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[2][0], "Bottom-left corner should be " + val);
    }

}

