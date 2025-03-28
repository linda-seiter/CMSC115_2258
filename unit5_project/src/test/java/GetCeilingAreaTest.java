import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GetCeilingAreaTest {

    /**
     * Test the getCeilingArea method with valid inputs.
     */
    @Test
    @DisplayName("Test getCeilingArea with valid length and width")
    public void testCeilingAreaWithValidInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double expectedArea = 120.0; // Pre-calculated expected result
        assertEquals(expectedArea, PaintCalculator.getCeilingArea(length, width), delta,
                "The ceiling area should be 120.0 square units.");
    }

    /**
     * Test the getCeilingArea method with edge cases.
     */
    @Test
    @DisplayName("Test getCeilingArea with edge case inputs")
    public void testCeilingAreaWithEdgeCases() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with 0 length (should return 0)
        assertEquals(0.0, PaintCalculator.getCeilingArea(0.0, 10.0), delta,
                "The ceiling area should be 0 when length is 0.");

        // Test with 0 width (should return 0)
        assertEquals(0.0, PaintCalculator.getCeilingArea(10.0, 0.0), delta,
                "The ceiling area should be 0 when width is 0.");

        // Test with negative length (should return 0)
        assertEquals(0.0, PaintCalculator.getCeilingArea(-10.0, 12.0), delta,
                "The ceiling area should be 0 when length is negative.");

        // Test with negative width (should return 0)
        assertEquals(0.0, PaintCalculator.getCeilingArea(10.0, -12.0), delta,
                "The ceiling area should be 0 when width is negative.");

        // Test with very large values
        double largeLength = 1_000_000;
        double largeWidth = 1_000_000;
        double largeExpectedArea = 1_000_000_000_000.0; // Pre-calculated expected result
        assertEquals(largeExpectedArea, PaintCalculator.getCeilingArea(largeLength, largeWidth), delta,
                "The ceiling area for large dimensions should be correct.");
    }

    /**
     * Test the getCeilingArea method with fractional inputs.
     */
    @Test
    @DisplayName("Test getCeilingArea with fractional length and width")
    public void testCeilingAreaWithFractionalInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with fractional values for both length and width
        double length = 5.75;
        double width = 8.25;
        double expectedArea = 47.4375; // Pre-calculated expected result
        assertEquals(expectedArea, PaintCalculator.getCeilingArea(length, width), delta,
                "The ceiling area should be 47.4375 square units for fractional inputs.");

        // Test with fractional values where one dimension is a whole number
        double length2 = 6.0;
        double width2 = 9.25;
        double expectedArea2 = 55.5; // Pre-calculated expected result
        assertEquals(expectedArea2, PaintCalculator.getCeilingArea(length2, width2), delta,
                "The ceiling area should be 55.5 square units for fractional width.");

    }

    @Test
    @DisplayName("Method getCeilingAreaTest calls isValidRectangle")
    void testCeilingArea_Calls_isValidRectangle() {
        try (MockedStatic<PaintCalculator> mockedStatic = mockStatic(PaintCalculator.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PaintCalculator.isValidRectangle(anyDouble(), anyDouble())).thenReturn(true);
            mockedStatic.when(() -> PaintCalculator.getCeilingArea(anyDouble(), anyDouble()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PaintCalculator.getCeilingArea(12.0, 8.5);

            // Verify that isValidRectangle() called
            mockedStatic.verify(() -> PaintCalculator.isValidRectangle(anyDouble(), anyDouble()), atLeastOnce());
        }
    }
}
