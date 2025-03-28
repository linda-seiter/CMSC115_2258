import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CalculateTotalAreaTest {

    /**
     * Test the calculateTotalArea method with valid inputs.
     */
    @Test
    @DisplayName("Test calculateTotalArea with valid length, width, and height")
    public void testCalculateTotalAreaWithValidInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double height = 8.0;
        double expectedArea = 352.0 + 120.0; // Pre-calculated result (ceiling area + wall area)
        assertEquals(expectedArea, PaintCalculator.calculateTotalArea(length, width, height), delta,
                "The calculated total area to be painted should be correct.");
    }

    /**
     * Test the calculateTotalArea method with edge cases where one dimension is zero.
     */
    @Test
    @DisplayName("Test calculateTotalArea with edge case inputs (zero dimensions)")
    public void testCalculateTotalAreaWithEdgeCases() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with zero dimensions (should return 0)
        assertEquals(0.0, PaintCalculator.calculateTotalArea(0.0, 10.0, 8.0), delta,
                "The total area to be painted should be 0 when length is 0.");

        assertEquals(0.0, PaintCalculator.calculateTotalArea(10.0, 0.0, 8.0), delta,
                "The total area to be painted should be 0 when width is 0.");

        assertEquals(0.0, PaintCalculator.calculateTotalArea(10.0, 12.0, 0.0), delta,
                "The total area to be painted should be 0 when height is 0.");

    }

    /**
     * Test the calculateTotalArea method with negative dimensions (should return 0 for negative inputs).
     */
    @Test
    @DisplayName("Test calculateTotalArea with negative dimensions")
    public void testCalculateTotalAreaWithNegativeDimensions() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with negative dimensions (should return 0 for negative values)
        assertEquals(0.0, PaintCalculator.calculateTotalArea(-10.0, 12.0, 8.0), delta,
                "The total area to be painted should be 0 when length is negative.");

        assertEquals(0.0, PaintCalculator.calculateTotalArea(10.0, -12.0, 8.0), delta,
                "The total area to be painted should be 0 when width is negative.");

        assertEquals(0.0, PaintCalculator.calculateTotalArea(10.0, 12.0, -8.0), delta,
                "The total area to be painted should be 0 when height is negative.");
    }

    /**
     * Test the calculateTotalArea method with fractional inputs.
     */
    @Test
    @DisplayName("Test calculateTotalArea with fractional length, width, and height")
    public void testCalculateTotalAreaWithFractionalInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with fractional values for all dimensions
        double length = 5.75;
        double width = 8.25;
        double height = 10.5;
        double expectedArea = 47.4375 + 294.0; // Pre-calculated result (ceiling area + wall area)
        assertEquals(expectedArea, PaintCalculator.calculateTotalArea(length, width, height), delta,
                "The calculated total area to be painted should be correct for fractional inputs.");

        // Test with fractional width and height, whole number length
        double length2 = 6.0;
        double width2 = 9.25;
        double height2 = 8.75;
        double expectedArea2 = 55.5 + 266.875; // Pre-calculated result (ceiling area + wall area)
        assertEquals(expectedArea2, PaintCalculator.calculateTotalArea(length2, width2, height2), delta,
                "The calculated total area to be painted should be correct for fractional width and height.");
    }

    @Test
    @DisplayName("Method calculateTotalAreaTest calls isValidRectangularPrism, calculateCeilingArea, calculateWallArea")
    void testCalculateTotalArea_Calls_isValidRectangularPrism() {
        try (MockedStatic<PaintCalculator> mockedStatic = mockStatic(PaintCalculator.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
            mockedStatic.when(() -> PaintCalculator.calculateWallArea(anyDouble(), anyDouble(), anyDouble())).thenReturn(10.0);
            mockedStatic.when(() -> PaintCalculator.calculateCeilingArea(anyDouble(), anyDouble())).thenReturn(20.0);
            mockedStatic.when(() -> PaintCalculator.calculateTotalArea(anyDouble(), anyDouble(), anyDouble()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PaintCalculator.calculateTotalArea(12.0, 8.5, 10.0);

            // Verify that isValidRectangularPrism() called
            mockedStatic.verify(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble()), atLeastOnce());
            mockedStatic.verify(() -> PaintCalculator.calculateWallArea(anyDouble(), anyDouble(), anyDouble()), atLeastOnce());
            mockedStatic.verify(() -> PaintCalculator.calculateCeilingArea(anyDouble(), anyDouble()), atLeastOnce());
        }
    }
}
