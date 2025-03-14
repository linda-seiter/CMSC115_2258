import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the replaceValue method in the LandscapeService class.
 */
public class ReplaceTargetValueTest {

    @Test
    public void testReplaceSingleMatch() {
        // Arrange
        String[][] original = {
                {"A", "A", "A"},
                {"A", "A", "B"},
                {"A", "A", "A"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A"},
                {"A", "A", "X"},
                {"A", "A", "A"}
        };
        String target = "B";
        String replacement = "X";

        // Act
        LandscapeService.replaceTargetValue(matrix, target, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nReplace B with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testReplaceMultipleMatches() {
        // Arrange
        String[][] original = {
                {"A", "B", "B"},
                {"B", "B", "A"},
                {"B", "A", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"Z", "B", "B"},
                {"B", "B", "Z"},
                {"B", "Z", "B"}
        };
        String target = "A";
        String replacement = "Z";

        // Act
        LandscapeService.replaceTargetValue(matrix, target, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nReplace every A with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testReplaceNoMatch() {
        // Arrange
        String[][] original = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = Arrays.copyOf(original, original.length);
        String target = "X";  // Target that does not exist in the matrix
        String replacement = "Y";  // Replacement value

        // Act
        LandscapeService.replaceTargetValue(matrix, target, replacement);

        // Assert no changes
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nReplace X with Y should result in no changes" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testReplaceSingleCellMatrix() {
        // Arrange
        String[][] matrix = {{"A"}};  // 1x1 matrix
        String target = "A";
        String replacement = "B";

        // Act
        LandscapeService.replaceTargetValue(matrix, target, replacement);

        // Assert
        assertEquals("B", matrix[0][0], "The cell in 1x1 should be replaced with " + replacement);
    }

    @Test
    public void testReplaceEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String target = "A";
        String replacement = "B";

        // Act
        LandscapeService.replaceTargetValue(matrix, target, replacement);

        // Assert
        assertEquals(0, matrix.length, "0x0 matrix has no cells");
    }

}

