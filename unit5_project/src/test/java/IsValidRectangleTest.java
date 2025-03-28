import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsValidRectangleTest {

    /**
     * Test the isValidRectangle method with valid inputs.
     */
    @Test
    @DisplayName("Test isValidRectangle with valid length and width")
    public void testIsValidRectangleWithValidInputs() {
        // Test with valid rectangle dimensions
        double length = 5.0;
        double width = 10.0;
        assertTrue(PaintCalculator.isValidRectangle(length, width),
                "The rectangle should be valid when both length and width are greater than zero.");
    }

    /**
     * Test the isValidRectangle method with edge cases.
     */
    @Test
    @DisplayName("Test isValidRectangle with edge cases")
    public void testIsValidRectangleWithEdgeCases() {
        // Test with zero length (should return false)
        assertFalse(PaintCalculator.isValidRectangle(0.0, 10.0),
                "The rectangle should be invalid when length is zero.");

        // Test with zero width (should return false)
        assertFalse(PaintCalculator.isValidRectangle(5.0, 0.0),
                "The rectangle should be invalid when width is zero.");

        // Test with negative length (should return false)
        assertFalse(PaintCalculator.isValidRectangle(-5.0, 10.0),
                "The rectangle should be invalid when length is negative.");

        // Test with negative width (should return false)
        assertFalse(PaintCalculator.isValidRectangle(5.0, -10.0),
                "The rectangle should be invalid when width is negative.");

        // Test with both negative dimensions (should return false)
        assertFalse(PaintCalculator.isValidRectangle(-5.0, -10.0),
                "The rectangle should be invalid when both dimensions are negative.");
    }

    /**
     * Test the isValidRectangle method with boundary inputs.
     */
    @Test
    @DisplayName("Test isValidRectangle with boundary inputs")
    public void testIsValidRectangleWithBoundaryInputs() {
        // Test with both dimensions being a very small positive value (close to zero)
        assertTrue(PaintCalculator.isValidRectangle(0.0001, 0.0001),
                "The rectangle should be valid when both length and width are greater than zero but small.");
    }
}
