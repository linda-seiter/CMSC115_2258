import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setCorners method in the LandscapeService class.
 */
public class TestSetCorners {

    @Test
    public void testSetCorners3x4Matrix() {
        // Arrange
        String[][] matrix = new String[5][4];  // 5x4 matrix
        String fillValue = "X";  //value to set in non-corners
        String setValue = "Y";  // value to set in the corners
        LandscapeService.fillArray(matrix, fillValue);

        // Act
        LandscapeService.setCorners(matrix, setValue);

        // Assert
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i == 0 || i == 4)  && (j == 0 || j == 3))
                        assertEquals(setValue, matrix[i][j], "Element at (" + i + "," + j + ") should be " + setValue);
                    else
                        assertEquals(fillValue, matrix[i][j], "Element at (" + i + "," + j + ") should not have changed");
            }
        }
    }

    @Test
    public void testSetCorners2x2Matrix() {
        // Arrange
        String[][] matrix = new String[2][2];  // 2x2 matrix
        String val = "O";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[0][1], "Top-right corner should be " + val);
        assertEquals(val, matrix[1][0], "Bottom-left corner should be " + val);
        assertEquals(val, matrix[1][1], "Bottom-right corner should be " + val);
    }

    @Test
    public void testSetCorners1x1Matrix() {
        // Arrange
        String[][] matrix = new String[1][1];  // 1x1 matrix
        String val = "A";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "The only cell (0,0) should be " + val);
    }

    @Test
    public void testSetCornersEmptyMatrix() {
        // Arrange
        String[][] matrix = new String[0][0];  // Empty matrix
        String val = "X";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(0, matrix.length, "Matrix should have no rows");
    }

    @Test
    public void testSetCornersMatrixWithOneRow() {
        // Arrange
        String[][] matrix = new String[1][3];  // Matrix with one row
        String val = "B";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[0][2], "Top-right corner should be " + val);
    }

    @Test
    public void testSetCornersMatrixWithOneColumn() {
        // Arrange
        String[][] matrix = new String[3][1];  // Matrix with one column
        String val = "C";  // value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[2][0], "Bottom-left corner should be " + val);
    }

    @Test
    public void testSetCornersMatrixWithNullValue() {
        // Arrange
        String[][] matrix = new String[3][3];  // 3x3 matrix
        String val = null;  // null value to set in the corners

        // Act
        LandscapeService.setCorners(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "Top-left corner should be " + val);
        assertEquals(val, matrix[0][2], "Top-right corner should be " + val);
        assertEquals(val, matrix[2][0], "Bottom-left corner should be " + val);
        assertEquals(val, matrix[2][2], "Bottom-right corner should be " + val);
    }
}

