import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the surroundMatchingCells method in the LandscapeService class.
 */
public class TestFindAndUpdateAdjacentCells {
    @Test
    public void testFind1Match() {
        // Arrange
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "A", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "X", "X", "X", "B"},
                {"B", "X", "A", "X", "B"},
                {"B", "X", "X", "X", "B"},
                {"B", "B", "B", "B", "B"}
        };

        String targetValue = "A";  // target value to search for
        String surroundValue = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.findAndUpdateAdjacentCells(matrix, targetValue, surroundValue);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround A with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testFind2Matches() {
        // Arrange
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"B", "A", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "A", "B"},
                {"B", "B", "B", "B", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"Z", "Z", "Z", "B", "B"},
                {"Z", "A", "Z", "B", "B"},
                {"Z", "Z", "Z", "B", "B"},
                {"B", "B", "Z", "Z", "Z"},
                {"B", "B", "Z", "A", "Z"},
                {"B", "B", "Z", "Z", "Z"}
        };

        String targetValue = "A";  // target value to search for
        String surroundValue = "Z";  // value to set in surrounding cells

        // Act
        LandscapeService.findAndUpdateAdjacentCells(matrix, targetValue, surroundValue);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround every A with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void testFindEdgeCases() {
        // Arrange
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"C", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "C", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"Z", "Z", "B", "B", "B"},
                {"C", "Z", "B", "B", "B"},
                {"Z", "Z", "Z", "Z", "Z"},
                {"B", "B", "Z", "C", "Z"}
        };

        String targetValue = "C";  // target value to search for
        String surroundValue = "Z";  // value to set in surrounding cells

        // Act
        LandscapeService.findAndUpdateAdjacentCells(matrix, targetValue, surroundValue);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround C with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testFindNoMatch() {
        // Arrange
        String[][] original = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);

        String[][] expected = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String target = "Z";  // target not found in the matrix
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.findAndUpdateAdjacentCells(matrix, target, s);

        // Assert: No changes should occur as 'Z' is not found
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround Z with X should result in no replacement." +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void test1x1() {
        // Arrange
        String[][] matrix = {{"E"}};  // Matrix with a single cell
        String target = "E";  // target value located at (0, 0)
        String surroundValue = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.findAndUpdateAdjacentCells(matrix, target, surroundValue);

        // Assert: Since there's only one element, no surrounding cells should exist
        assertEquals(target, matrix[0][0], "Cell should remain " + target);
    }
}
