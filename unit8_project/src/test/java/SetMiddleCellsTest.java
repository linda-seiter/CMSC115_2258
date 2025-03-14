import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the setMiddleCell method in the LandscapeService class.
 */
public class SetMiddleCellsTest {

    @Test
    public void testOddRow_OddCol_SetMiddleCells() {
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
                {"B", "B", "?", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"},
                {"B", "B", "B", "B", "B"}
        };
        String replacement = "?";

        // Act
        LandscapeService.setMiddleCells(matrix, replacement);

        // Assert
        String message = "\nOdd X Odd single middle cell to" + replacement +
                "\nOriginal:" + Arrays.deepToString(original) +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),message);
    }

    @Test
    public void testEvenRow_EvenCol_SetMiddleCells() {
        // Arrange 4x6
        String[][] original = {
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "#", "#", "A", "A"},
                {"A", "A", "#", "#", "A", "A"},
                {"A", "A", "A", "A", "A", "A"}
        };
        String replacement = "#";

        // Act
        LandscapeService.setMiddleCells(matrix, replacement);

        // Assert: Check that the bottom right center element is set
        String message =   "\nEven x Even sets 4 middle cells to " + replacement +
                "\nOriginal:" + Arrays.deepToString(original) +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), message);
    }

    @Test
    public void testEvenRow_OddCol_SetMiddleCells() {
        // Arrange 4x5
        String[][] original = {
                {"A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A", "A"},
                {"A", "A", "@", "A", "A"},
                {"A", "A", "@", "A", "A"},
                {"A", "A", "A", "A", "A"}
        };
        String replacement = "@";

        // Act
        LandscapeService.setMiddleCells(matrix, replacement);

        // Assert: Check that the bottom right center element is set
        String message = "\nEven x Odd sets 2 middle cells to " + replacement +
                "\nOriginal:" + Arrays.deepToString(original) +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix),message);
    }

    @Test
    public void testOddnRow_EvenCol_SetMiddleCells() {
        // Arrange 5x6
        String[][] original = {
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"}
        };
        String[][] matrix = Arrays.copyOf(original, original.length);
        String[][] expected = {
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "*", "*", "A", "A"},
                {"A", "A", "A", "A", "A", "A"},
                {"A", "A", "A", "A", "A", "A"}
        };
        String replacement = "*";

        // Act
        LandscapeService.setMiddleCells(matrix, replacement);

        // Assert: Check that the bottom right center element is set
        String message =  "\nEven x Odd sets 2 middle cells to " + replacement +
                "\nOriginal:" + Arrays.deepToString(original) +
                "\nExpected:" + Arrays.deepToString(expected) +
                "\nActual:" + Arrays.deepToString(matrix);
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), message);
    }

    @Test
    public void testSetCenter1x1() {
        // Arrange
        String[][] matrix = new String[1][1];
        String replacement = "E";

        // Act
        LandscapeService.setMiddleCells(matrix, replacement);

        // Assert
        assertEquals(replacement, matrix[0][0], "Center element of 1x1 should be set to " + replacement);
    }

}
