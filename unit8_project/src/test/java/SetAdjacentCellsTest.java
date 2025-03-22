import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the setAdjacentCells method in the YardPlanner class.
 */
public class SetAdjacentCellsTest {

    @Test
    public void testInteriorCell() {
        // Arrange
        String[][] original = {
                {"A", "A", "A", "A"},
                {"B", "B", "B", "B"},
                {"C", "C", "C", "C"},
                {"D", "D", "D", "D"},
                {"E", "E", "E", "E"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A"},
                {"X", "X", "X", "B"},
                {"X", "C", "X", "C"},
                {"X", "X", "X", "D"},
                {"E", "E", "E", "E"}
        };
        int row=2;
        int col=1;

        String replacement = "X";

        // Act
        YardPlanner.setAdjacentCells(matrix, row, col, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround cell (2,1) with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testTopLeft() {
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
        YardPlanner.setAdjacentCells(matrix, row, col, replacement);

        // Assert.  No exception should be thrown.
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround top-left corner with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testBottomRight() {
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
            YardPlanner.setAdjacentCells(matrix, row, col, replacement);

            // Assert. No exception should be thrown.
            Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                    "\nSurround bottom right corner with X" +
                            "\nOriginal:" + Arrays.deepToString(original) +
                            "\nExpected:" + Arrays.deepToString(expected) +
                            "\nActual:" + Arrays.deepToString(matrix)
            );
    }

    @Test
    public void test1x1() {
        // Arrange
        String[][] original = {{"A"}};
        String[][] matrix = Arrays.copyOf(original, original.length);
        String replacement = "B";

        // Act
        YardPlanner.setAdjacentCells(matrix, 0, 0, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(original, matrix),
                "\1x1 has no adjacent cells" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

}
