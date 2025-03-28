import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CalculateCeilingAreaTest {

    /**
     * Test the calculateCeilingArea method with valid inputs.
     */
    @Test
    @DisplayName("Test calculateCeilingArea with valid length and width")
    public void testCalculateCeilingAreaWithValidInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double expectedArea = 120.0; // Pre-calculated expected result
        assertEquals(expectedArea, PaintCalculator.calculateCeilingArea(length, width), delta,
                "The calculated ceiling area should be 120.0 square units.");
    }

    /**
     * Test the calculateCeilingArea method with edge cases.
     */
    @Test
    @DisplayName("Test calculateCeilingArea with edge case inputs")
    public void testCalculateCeilingAreaWithEdgeCases() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with 0 length (should return 0)
        assertEquals(0.0, PaintCalculator.calculateCeilingArea(0.0, 10.0), delta,
                "The ceiling area should be 0 when length is 0.");

        // Test with 0 width (should return 0)
        assertEquals(0.0, PaintCalculator.calculateCeilingArea(10.0, 0.0), delta,
                "The ceiling area should be 0 when width is 0.");

        // Test with negative length (should return 0)
        assertEquals(0.0, PaintCalculator.calculateCeilingArea(-10.0, 12.0), delta,
                "The ceiling area should be negative when length is negative.");

        // Test with negative width (should return 0)
        assertEquals(0.0, PaintCalculator.calculateCeilingArea(10.0, -12.0), delta,
                "The ceiling area should be negative when width is negative.");

        // Test with very large values
        double largeLength = 1_000_000;
        double largeWidth = 1_000_000;
        double largeExpectedArea = 1_000_000_000_000.0; // Pre-calculated expected result
        assertEquals(largeExpectedArea, PaintCalculator.calculateCeilingArea(largeLength, largeWidth), delta,
                "The calculated ceiling area for large dimensions should be correct.");
    }

    /**
     * Test the calculateCeilingArea method with fractional inputs.
     */
    @Test
    @DisplayName("Test calculateCeilingArea with fractional length and width")
    public void testCalculateCeilingAreaWithFractionalInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with fractional values for both length and width
        double length = 5.75;
        double width = 8.25;
        double expectedArea = 47.4375; // Pre-calculated expected result
        assertEquals(expectedArea, PaintCalculator.calculateCeilingArea(length, width), delta,
                "The calculated ceiling area should be 47.4375 square units for fractional inputs.");

        // Test with fractional values where one dimension is a whole number
        double length2 = 6.0;
        double width2 = 9.25;
        double expectedArea2 = 55.5; // Pre-calculated expected result
        assertEquals(expectedArea2, PaintCalculator.calculateCeilingArea(length2, width2), delta,
                "The calculated ceiling area should be 55.5 square units for fractional width.");

    }

    @Test
    @DisplayName("Method calculateCeilingAreaTest calls isValidRectangle")
    void testCalculateCeilingArea_Calls_isValidRectangle() {
        try (MockedStatic<PaintCalculator> mockedStatic = mockStatic(PaintCalculator.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PaintCalculator.isValidRectangle(anyDouble(), anyDouble())).thenReturn(true);
            mockedStatic.when(() -> PaintCalculator.calculateCeilingArea(anyDouble(), anyDouble()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PaintCalculator.calculateCeilingArea(12.0, 8.5);

            // Verify that isValidRectangle() called
            mockedStatic.verify(() -> PaintCalculator.isValidRectangle(anyDouble(), anyDouble()), atLeastOnce());
        }
    }
}
