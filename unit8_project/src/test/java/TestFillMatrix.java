import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the fillMatrix method in the LandscapeService class.
 */

public class TestFillMatrix {

    @Test
    public void testFill3x4() {
        // Arrange
        String[][] matrix = new String[3][4]; //null values
        String val = "A";  // value to fill the matrix with
        String[][] expected = {
                {"A", "A", "A", "A"},
                {"A", "A", "A", "A"},
                {"A", "A", "A", "A"}
        };
        // Act
        LandscapeService.fillMatrix(matrix, val);

        //Testing reflection approach
        /*
        try {
            final Class<?> clazz = LandscapeService.class;
            final Method method = clazz.getMethod("fillMatrix", String[][].class, String.class);
            final Object[] args =  {matrix,val};
            method.invoke(null, args);
        } catch (Exception e) { e.printStackTrace();}
         */

        // Assert
        String message = "\nFill 3x4 with A" +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), message);
    }

    @Test
    public void testFill2x2() {
        // Arrange
        String[][] matrix = new String[2][2];
        String[][] expected = {
                {"B", "B"},
                {"B", "B"}
        };
        String val = "B";

        // Act
        LandscapeService.fillMatrix(matrix, val);

        // Assert
        String message = "\nFill 2x2 with B" +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), message);
    }

    @Test
    public void testFill1x1() {
        // Arrange
        String[][] matrix = new String[1][1];
        String val = "C";

        // Act
        LandscapeService.fillMatrix(matrix, val);

        // Assert
        assertEquals(val, matrix[0][0], "1x1 value at position (0,0) should be " + val);
    }


}
