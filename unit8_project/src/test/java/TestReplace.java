import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the replace method in the LandscapeService class.
 */
public class TestReplace {

    @Test
    public void testReplaceMultipleOccurrencesMatrix() {
        // Arrange
        String[][] original = {
                {"A", "B", "C"},
                {"D", "E", "A"},
                {"F", "A", "G"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"X", "B", "C"},
                {"D", "E", "X"},
                {"F", "X", "G"}
        };
        String target = "A";
        String replacement = "X";

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nReplace A with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testReplaceWithNoMatch() {
        // Arrange
        String[][] original = {
                {"A", "B", "C"},
                {"D", "E", "A"},
                {"F", "A", "G"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "B", "C"},
                {"D", "E", "A"},
                {"F", "A", "G"}
        };
        String target = "X";  // Target that does not exist in the matrix
        String replacement = "Y";  // Replacement value

        // Act
        LandscapeService.replace(matrix, target, replacement);

        // Assert no changes
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nReplace X with Y should result in no changes" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
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
        assertEquals("B", matrix[0][0], "The single element in 1x1 matrix should be replaced with " + replacement);
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
        assertEquals(0, matrix.length, "0x0 matrix should have no rows");
    }

}

