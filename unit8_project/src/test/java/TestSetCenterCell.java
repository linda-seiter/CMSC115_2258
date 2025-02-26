import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setCenterCell method in the LandscapeService class.
 */
public class TestSetCenterCell {

    @Test
    public void testSetCenterOddDimensions() {
        // Arrange 7x5
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "C", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };
        String replacement = "C";

        // Act
        LandscapeService.setCenterCell(matrix, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nsetMiddleCell 7x5 assigns cell at (3, 2) to " + replacement +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSetCenterEvenDimensions() {
        // Arrange 4x8
        String[][] original = {
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "D", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",}
        };
        String replacement = "D";

        // Act
        LandscapeService.setCenterCell(matrix, replacement);

        // Assert: Check that the bottom right center element is set
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nsetMiddleCell 4 rows 8 cols assigns cell at (2, 4) to " + replacement +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSetCenter1x1() {
        // Arrange
        String[][] matrix = new String[1][1];
        String replacement = "E";

        // Act
        LandscapeService.setCenterCell(matrix, replacement);

        // Assert
        assertEquals(replacement, matrix[0][0], "Center element of 1x1 should be set to " + replacement);
    }

    @Test
    public void testSetCenter0x0() {
        // Arrange
        String[][] matrix = new String[0][0];  // 0x0 matrix
        String replacement = "E";  // value to set in the middle

        // Act & Assert
        // No middle element should be set, matrix has no elements, so nothing happens
        try {
            LandscapeService.setCenterCell(matrix, replacement);
            // Nothing should happen, no exception should be thrown
            assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("Exception should not be thrown for an empty matrix");
        }
    }

}
