import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LandscapeService class, specifically the setMiddle method.
 */
public class TestSetMiddle {

    @Test
    public void testSetMiddleOddDimensions() {
        // Arrange
        String[][] matrix = new String[5][7]; // 5x7 matrix
        String fillValue = "A";
        String setValue = "B";  // value to set in the middle
        LandscapeService.fillArray(matrix, fillValue);

        // Act
        LandscapeService.setMiddle(matrix, setValue);

        // Assert: Check that the middle element is set
        assertEquals(setValue, matrix[2][3], "Middle element of the 5x7 matrix should be set to " + setValue);

        // Assert: Ensure all other elements are unchanged
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != 2 || j != 3) {
                    assertEquals(fillValue, matrix[i][j], "Element at (" + i + "," + j + ") should not have changed");
                }
            }
        }
    }

    @Test
    public void testSetMiddleEvenDimensions() {
        // Arrange
        String[][] matrix = new String[4][10];  // 4x10 matrix
        String fillValue = "C";
        String setValue = "D";  // value to set in the middle
        LandscapeService.fillArray(matrix, fillValue);

        // Act
        LandscapeService.setMiddle(matrix, setValue);

        // Assert: Check that the middle element is set
        assertEquals(setValue, matrix[2][5], "Middle element of the 4x10 matrix should be set to " + setValue);

        // Assert: Ensure all other elements are unchanged
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != 2 || j != 5) {
                    assertEquals(fillValue, matrix[i][j], "Element at (" + i + "," + j + ") should not have changed");
                }
            }
        }
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
