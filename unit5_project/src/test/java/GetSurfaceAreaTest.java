import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GetSurfaceAreaTest {

    /**
     * Test the getSurfaceArea method with valid inputs.
     */
    @Test
    @DisplayName("Test getSurfaceArea with valid length, width, and height and include ceiling")
    public void testSurfaceAreaWithValidInputsIncludeCeiling() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double height = 8.0;
        double expectedArea = 352.0 + 120.0; // Pre-calculated result (ceiling area + wall area)
        assertEquals(expectedArea, PaintCalculator.getSurfaceArea(length, width, height, true), delta,
                "The surface area including ceiling should be correct.");
    }

    /**
     * Test the getSurfaceArea method with valid inputs.
     */
    @Test
    @DisplayName("Test getSurfaceArea with valid length, width, and height and exclude ceiling")
    public void testSurfaceAreaWithValidInputsExcludeCeiling() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with typical room dimensions
        double length = 10.0;
        double width = 12.0;
        double height = 8.0;
        double expectedArea = 352.0; // Pre-calculated result ( wall area)
        assertEquals(expectedArea, PaintCalculator.getSurfaceArea(length, width, height, false), delta,
                "The surface area excluding ceiling should be correct.");
    }

    /**
     * Test the getSurfaceArea method with edge cases where one dimension is zero or negative.
     */
    @Test
    @DisplayName("Test getSurfaceArea with edge case inputs (zero or negative)")
    public void testCalculateTotalAreaWithEdgeCases() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with zero dimensions (should return 0)
        assertEquals(0.0, PaintCalculator.getSurfaceArea(0.0, 10.0, 8.0, true), delta,
                "The total area to be painted should be 0 when length is 0.");

        assertEquals(0.0, PaintCalculator.getSurfaceArea(10.0, 0.0, 8.0, true), delta,
                "The total area to be painted should be 0 when width is 0.");

        assertEquals(0.0, PaintCalculator.getSurfaceArea(10.0, 12.0, 0.0, true), delta,
                "The total area to be painted should be 0 when height is 0.");

        // Test with negative dimensions (should return 0 for negative values)
        assertEquals(0.0, PaintCalculator.getSurfaceArea(-10.0, 12.0, 8.0, true), delta,
                "The total area to be painted should be 0 when length is negative.");

        assertEquals(0.0, PaintCalculator.getSurfaceArea(10.0, -12.0, 8.0, true), delta,
                "The total area to be painted should be 0 when width is negative.");

        assertEquals(0.0, PaintCalculator.getSurfaceArea(10.0, 12.0, -8.0, true), delta,
                "The total area to be painted should be 0 when height is negative.");
    }

    /**
     * Test the calculateTotalArea method with fractional inputs.
     */
    @Test
    @DisplayName("Test getSurfaceArea with fractional length, width, and height")
    public void testSurfaceAreaWithFractionalInputs() {
        double delta = 0.0001; // Small tolerance for floating-point comparison

        // Test with fractional values for all dimensions
        double length = 5.75;
        double width = 8.25;
        double height = 10.5;
        double expectedArea = 47.4375 + 294.0; // Pre-calculated result (ceiling area + wall area)
        assertEquals(expectedArea, PaintCalculator.getSurfaceArea(length, width, height, true), delta,
                "The surface area to be painted should be correct for fractional inputs.");

    }

    @Test
    @DisplayName("Method calculateTotalAreaTest calls isValidRectangularPrism, calculateCeilingArea, calculateWallArea")
    void testCalculateTotalArea_Calls_isValidRectangularPrism() {
        try (MockedStatic<PaintCalculator> mockedStatic = mockStatic(PaintCalculator.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
            mockedStatic.when(() -> PaintCalculator.getWallArea(anyDouble(), anyDouble(), anyDouble())).thenReturn(10.0);
            mockedStatic.when(() -> PaintCalculator.getCeilingArea(anyDouble(), anyDouble())).thenReturn(20.0);
            mockedStatic.when(() -> PaintCalculator.getSurfaceArea(anyDouble(), anyDouble(), anyDouble(), anyBoolean()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PaintCalculator.getSurfaceArea(12.0, 8.5, 10.0, true);

            // Verify that isValidRectangularPrism() called
            mockedStatic.verify(() -> PaintCalculator.isValidRectangularPrism(anyDouble(), anyDouble(), anyDouble()), atLeastOnce());
            mockedStatic.verify(() -> PaintCalculator.getWallArea(anyDouble(), anyDouble(), anyDouble()), atLeastOnce());
            mockedStatic.verify(() -> PaintCalculator.getCeilingArea(anyDouble(), anyDouble()), atLeastOnce());
        }
    }
}
