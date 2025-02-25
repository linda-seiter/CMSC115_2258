import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the surroundTarget method in the LandscapeService class.
 */
public class TestSurroundTarget {
    @Test
    public void testSurroundSingleTargetFoundInMatrix() {
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

        String target = "A";  // target value to search for
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround A with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundMultipleTargetsEdgeCasesInMatrix() {
        // Arrange
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"A", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "A", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"Z", "Z", "B", "B", "B"},
                {"A", "Z", "B", "B", "B"},
                {"Z", "Z", "Z", "Z", "Z"},
                {"B", "B", "Z", "A", "Z"}
        };

        String target = "A";  // target value to search for
        String s = "Z";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround A with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSurroundTargetNotFound() {
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
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: No changes should occur as 'Z' is not found
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSurround Z with X should result in no replacement." +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void testSurroundTargetEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String target = "E";  // target to search for
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: No changes should occur as the matrix is empty
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }

    @Test
    public void testSurroundTargetSingleElement() {
        // Arrange
        String[][] matrix = {{"E"}};  // Matrix with a single element
        String target = "E";  // target value located at (0, 0)
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: Since there's only one element, no surrounding cells should exist
        assertEquals("E", matrix[0][0], "Center should remain E");
    }
}
