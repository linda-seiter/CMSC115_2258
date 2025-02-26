import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setSurroundingCells method in the LandscapeService class.
 */
public class TestSetSurroundingCells {

    @Test
    public void testSurroundInteriorCell() {
        // Arrange
        String[][] original = {
                {"A", "A", "A", "A"},
                {"B", "B", "B", "B"},
                {"C", "C", "C", "C"},
                {"D", "D", "D", "D"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A"},
                {"X", "X", "X", "B"},
                {"X", "C", "X", "C"},
                {"X", "X", "X", "D"}
        };
        int row=2;
        int col=1;

        String replacement = "X";

        // Act
        LandscapeService.setSurroundingCells(matrix, row, col, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround cell (2,1) with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundTopLeft() {
        // Arrange
        String[][] original = {
                {"A", "A", "A", "A"},
                {"B", "B", "B", "B"},
                {"C", "C", "C", "C"},
                {"D", "D", "D", "D"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "X", "A", "A"},
                {"X", "X", "B", "B"},
                {"C", "C", "C", "C"},
                {"D", "D", "D", "D"}
        };

        int row = 0;
        int col = 0;
        String replacement = "X";

        // Act
        LandscapeService.setSurroundingCells(matrix, row, col, replacement);

        // Assert.  No exception should be thrown.
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround top-left corner with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundBottomRightCorner() {
            // Arrange
            String[][] original = {
                    {"A", "A", "A", "A"},
                    {"B", "B", "B", "B"},
                    {"C", "C", "C", "C"}
            };
            String[][] matrix = Arrays.copyOf(original, original.length);
            String[][] expected = {
                    {"A", "A", "A", "A"},
                    {"B", "B", "Z", "Z"},
                    {"C", "C", "Z", "C"}
            };

            int row = 2;
            int col = 3;
            String replacement = "Z";

            // Act
            LandscapeService.setSurroundingCells(matrix, row, col, replacement);

            // Assert. No exception should be thrown.
            Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                    "\nSurround bottom right corner with X" +
                            "\nOriginal:" + Arrays.deepToString(original) +
                            "\nExpected:" + Arrays.deepToString(expected) +
                            "\nActual:" + Arrays.deepToString(matrix)
            );
    }

    @Test
    public void testSurround1x1() {
        // Arrange
        String[][] original = {{"A"}};
        String[][] matrix = Arrays.copyOf(original, original.length);
        String replacement = "B";

        // Act
        LandscapeService.setSurroundingCells(matrix, 0, 0, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(original, matrix),
                "\1x1 has no surrounding cells" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurround0x0() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String replacement= "X";  // value to set in surrounding cells

        // Act
        LandscapeService.setSurroundingCells(matrix, 0, 0, replacement);

        // Assert
        assertEquals(0, matrix.length, "0x0 has no cells");
    }
}
