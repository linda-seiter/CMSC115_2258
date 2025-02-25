import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the surroundTarget method in the LandscapeService class.
 */
public class TestSurroundTarget {

    @Test
    public void testSurroundTargetFoundInMatrix() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String target = "E";  // target value to search for
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: Check that surrounding cells of 'E' are updated
        assertEquals("X", matrix[0][0], "Top-left should be X");
        assertEquals("X", matrix[0][1], "Top should be X");
        assertEquals("X", matrix[0][2], "Top-right should be X");
        assertEquals("X", matrix[1][0], "Left should be X");
        assertEquals("E", matrix[1][1], "Center should be E"); // target 'E' remains unchanged
        assertEquals("X", matrix[1][2], "Right should be X");
        assertEquals("X", matrix[2][0], "Bottom-left should be X");
        assertEquals("X", matrix[2][1], "Bottom should be X");
        assertEquals("X", matrix[2][2], "Bottom-right should be X");
    }

    @Test
    public void testSurroundTargetNotFound() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String target = "Z";  // target not found in the matrix
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: No changes should occur as 'Z' is not found
        assertEquals("A", matrix[0][0], "Top-left should remain A");
        assertEquals("B", matrix[0][1], "Top should remain B");
        assertEquals("C", matrix[0][2], "Top-right should remain C");
        assertEquals("D", matrix[1][0], "Left should remain D");
        assertEquals("E", matrix[1][1], "Center should remain E");
        assertEquals("F", matrix[1][2], "Right should remain F");
        assertEquals("G", matrix[2][0], "Bottom-left should remain G");
        assertEquals("H", matrix[2][1], "Bottom should remain H");
        assertEquals("I", matrix[2][2], "Bottom-right should remain I");
    }

    @Test
    public void testSurroundTargetOnEdge() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        String[][] expected = {
                {"X", "B", "X"},
                {"X", "X", "X"},
                {"G", "H", "I"}
        };

        String target = "B";  // target value located at (0,1)
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: Check the surrounding cells of 'B' at (0, 1)
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), "The two 2D arrays are not equal");

    }

    @Test
    public void testSurroundTargetMultipleOccurrences() {
        // Arrange
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"},
                {"C", "J", "K"}
        };
        String[][] expected = {
                {"A", "X", "C"},
                {"D", "X", "X"},
                {"X", "X", "I"},
                {"C", "X", "K"}
        };
        String target = "C";  // target value to search for
        String s = "X";  // value to set in surrounding cells

        // Act
        LandscapeService.surroundTarget(matrix, target, s);

        // Assert: Check that both occurrences of 'C' are surrounded
        Assertions.assertTrue(Arrays.deepEquals(expected, matrix), "The two 2D arrays are not equal");
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
