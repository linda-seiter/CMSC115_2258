import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsValidRectangularPrismTest {

    /**
     * Test the isValidRectangularPrism method with valid inputs.
     */
    @Test
    @DisplayName("Test isValidRectangularPrism with valid length, width, and height")
    public void testIsValidRectangularPrismWithValidInputs() {
        // Test with valid rectangular prism dimensions
        double length = 5.0;
        double width = 10.0;
        double height = 8.0;
        assertTrue(PaintCalculator.isValidRectangularPrism(length, width, height),
                "The rectangular prism should be valid when all dimensions are greater than zero.");
    }

    /**
     * Test the isValidRectangularPrism method with edge cases.
     */
    @Test
    @DisplayName("Test isValidRectangularPrism with edge case inputs")
    public void testIsValidRectangularPrismWithEdgeCases() {
        // Test with zero length (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(0.0, 10.0, 8.0),
                "The rectangular prism should be invalid when length is zero.");

        // Test with zero width (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(5.0, 0.0, 8.0),
                "The rectangular prism should be invalid when width is zero.");

        // Test with zero height (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(5.0, 10.0, 0.0),
                "The rectangular prism should be invalid when height is zero.");

        // Test with negative length (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(-5.0, 10.0, 8.0),
                "The rectangular prism should be invalid when length is negative.");

        // Test with negative width (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(5.0, -10.0, 8.0),
                "The rectangular prism should be invalid when width is negative.");

        // Test with negative height (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(5.0, 10.0, -8.0),
                "The rectangular prism should be invalid when height is negative.");

        // Test with all negative dimensions (should return false)
        assertFalse(PaintCalculator.isValidRectangularPrism(-5.0, -10.0, -8.0),
                "The rectangular prism should be invalid when all dimensions are negative.");
    }

    /**
     * Test the isValidRectangularPrism method with boundary inputs.
     */
    @Test
    @DisplayName("Test isValidRectangularPrism with boundary inputs")
    public void testIsValidRectangularPrismWithBoundaryInputs() {
        // Test with small positive values for dimensions
        assertTrue(PaintCalculator.isValidRectangularPrism(0.0001, 0.0001, 0.0001),
                "The rectangular prism should be valid when all dimensions are greater than zero but small.");
    }
}
