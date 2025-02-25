import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the surround method in the LandscapeService class.
 */
public class TestSurround {

    @Test
    public void testSurroundWithValidPosition() {
        // Arrange
        String[][] original = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "B", "C", "D"},
                {"X", "X", "X", "H"},
                {"X", "J", "X", "L"},
                {"X", "X", "X", "P"}
        };

        String replacement = "X";

        // Act
        LandscapeService.surround(matrix, 2, 1, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround (2,1) with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundTopLeftCorner() {
        // Arrange
        // Arrange
        String[][] original = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "X", "C", "D"},
                {"X", "X", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };

        int row = 0;
        int col = 0;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround top left corner with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundBottomLeftCorner() {
        // Arrange
        // Arrange
        String[][] original = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"X", "X", "K", "L"},
                {"M", "X", "O", "P"}
        };

        int row = 3;
        int col = 0;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround bottom left corner with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void testSurroundTopRight() {
        // Arrange
        // Arrange
        String[][] original = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "B", "X", "D"},
                {"E", "F", "X", "X"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };

        int row = 0;
        int col = 3;
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surround(matrix, row, col, s);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround top right corner with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
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
