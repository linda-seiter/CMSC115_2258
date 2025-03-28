import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CalculateWallAreaTest {

    /**
     * Test the calculateWallArea method with valid inputs.
     */
    @Test
    @DisplayName("Test calculateWallArea with valid length, width, and height")
    public void testCalculateWallAreaWithValidInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double height = 8.0;
        double expectedArea = 352.0; // Pre-calculated result
        assertEquals(expectedArea, PaintCalculator.calculateWallArea(length, width, height), delta,
                "The calculated wall area should be 352.0 square units.");
    }

    /**
     * Test the calculateWallArea method with edge cases.
     */
    @Test
    @DisplayName("Test calculateWallArea with edge case inputs")
    public void testCalculateWallAreaWithEdgeCases() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with zero dimensions (should return 0)
        assertEquals(0.0, PaintCalculator.calculateWallArea(0.0, 10.0, 8.0), delta,
                "The wall area should be 0 when length is 0.");

        assertEquals(0.0, PaintCalculator.calculateWallArea(10.0, 0.0, 8.0), delta,
                "The wall area should be 0 when width is 0.");

        assertEquals(0.0, PaintCalculator.calculateWallArea(10.0, 12.0, 0.0), delta,
                "The wall area should be 0 when height is 0.");

        // Test with negative length (should return 0)
        assertEquals(0.0, PaintCalculator.calculateWallArea(-10.0, 12.0, 8.0), delta,
                "The wall area should be 0 when length is negative.");

        // Test with negative width (should return 0)
        assertEquals(0.0, PaintCalculator.calculateWallArea(10.0, -12.0, 8.0), delta,
                "The wall area should be 0 when width is negative.");

        // Test with negative height (should return 0)
        assertEquals(0.0, PaintCalculator.calculateWallArea(10.0, 12.0,- 8.0), delta,
                "The wall area should be 0 when height is negative.");
    }

    /**
     * Test the calculateWallArea method with fractional inputs.
     */
    @Test
    @DisplayName("Test calculateWallArea with fractional length, width, and height")
    public void testCalculateWallAreaWithFractionalInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with fractional values for all dimensions
        double length = 5.75;
        double width = 8.25;
        double height = 10.5;
        double expectedArea = 294.0; // Pre-calculated result
        assertEquals(expectedArea, PaintCalculator.calculateWallArea(length, width, height), delta,
                "The calculated wall area should be 294.0 square units for fractional inputs.");

        // Test with fractional width and height, whole number length
        double length2 = 6.0;
        double width2 = 9.25;
        double height2 = 8.75;
        double expectedArea2 = 266.875; // Pre-calculated result
        assertEquals(expectedArea2, PaintCalculator.calculateWallArea(length2, width2, height2), delta,
                "The calculated wall area should be 266.9375 square units for fractional width and height.");
    }

    @Test
    @DisplayName("Method calculateWallAreaTest calls isValidRectangularPrism")
    void testCalculateWallArea_Calls_isValidRectangularPrism() {
        try (MockedStatic<PaintCalculator> mockedStatic = mockStatic(PaintCalculator.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
            mockedStatic.when(() -> PaintCalculator.calculateWallArea(anyDouble(), anyDouble(), anyDouble()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PaintCalculator.calculateWallArea(12.0, 8.5, 10.0);

            // Verify that isValidRectangularPrism() called
            mockedStatic.verify(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble()), atLeastOnce());
        }
    }
}
