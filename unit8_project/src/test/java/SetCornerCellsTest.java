import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setCornerCells method in the YardPlanner class.
 */
public class SetCornerCellsTest {

    @Test
    public void testSetCorners3x4() {
        // Arrange 3x4
        String[][] original = {
                {"A", "A", "A", "A"},
                {"B", "B", "B", "B"},
                {"C", "C", "C", "C"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"X", "A", "A", "X"},
                {"B", "B", "B", "B"},
                {"X", "C", "C", "X"}
        };

        String replacement = "X";

        // Act
        YardPlanner.setCornerCells(matrix, replacement);

        // Assert
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),
                "\nSet corners of 3x4 with X" +
                        "\nOriginal:" + Arrays.deepToString(original) +
                        "\nExpected:" + Arrays.deepToString(expected) +
                        "\nActual:" + Arrays.deepToString(matrix)
        );
    }


    @Test
    public void testSetCorners1x1() {
        // Arrange
        String[][] matrix = new String[1][1];
        String replacement = "A";

        // Act
        YardPlanner.setCornerCells(matrix, replacement);

        // Assert
        assertEquals(replacement, matrix[0][0], "1x1 cell (0,0) should be " + replacement);
    }


    @Test
    public void testSetCornersOneRow() {
        // Arrange
        String[][] matrix = new String[1][3];  // 1x3
        String replacement = "B";  // value to set in the corners

        // Act
        YardPlanner.setCornerCells(matrix, replacement);

        // Assert
        assertEquals(replacement, matrix[0][0], "1x3 left corner should be " + replacement);
        assertEquals(replacement, matrix[0][2], "1x3 right corner should be " + replacement);
    }

    @Test
    public void testSetCornersMatrixOneColumn() {
        // Arrange
        String[][] matrix = new String[3][1];  // 3x1
        String replacement = "C";  // value to set in the corners

        // Act
        YardPlanner.setCornerCells(matrix, replacement);

        // Assert
        assertEquals(replacement, matrix[0][0], "3x1 top corner should be " + replacement);
        assertEquals(replacement, matrix[2][0], "3x1 bottom corner should be " + replacement);
    }

}

