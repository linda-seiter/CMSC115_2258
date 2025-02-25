import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LandscapeService class, specifically the setMiddle method.
 */
public class TestSetMiddle {

    @Test
    public void testSetMiddleOddDimensions() {
        // Arrange
        String[][] original = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };  //5x7
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "Z", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };  //5x7

        // Act
        LandscapeService.setMiddle(matrix, "Z");

        // Assert: Check that the middle element is set
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nsetMiddle 5x7 assigns element (2,3) with Z" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSetMiddleEvenDimensions() {
        // Arrange
        String[][] original = {
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",}
        };  //6x8
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "Y", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",},
                {"A", "A", "A", "A", "A", "A", "A", "A",}
        };
        // Act
        LandscapeService.setMiddle(matrix, "D");

        // Assert: Check that the bottom right middle element is set
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nsetMiddle 6x8 assigns element (3,4) with Y" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }

    @Test
    public void testSetMiddleSingleElement() {
        // Arrange
        String[][] matrix = new String[1][1];  // 1x1 matrix
        String value = "E";  // value to set in the middle

        // Act
        LandscapeService.setMiddle(matrix, value);

        // Assert
        assertEquals(value, matrix[0][0], "Middle element of the 1x1 matrix should be set to " + value);
    }

    @Test
    public void testSetMiddleEmpty() {
        // Arrange
        String[][] matrix = new String[0][0];  // 0x0 matrix
        String value = "E";  // value to set in the middle

        // Act & Assert
        // No middle element should be set, matrix has no elements, so nothing happens
        try {
            LandscapeService.setMiddle(matrix, value);
            // Nothing should happen, no exception should be thrown
            assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("Exception should not be thrown for an empty matrix");
        }
    }

}
