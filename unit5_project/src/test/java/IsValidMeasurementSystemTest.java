
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsValidMeasurementSystemTest {

    /**
     * Test the isValidMeasurementSystem method with valid inputs ("imperial" and "metric").
     */
    @Test
    @DisplayName("Test valid measurement systems (imperial and metric)")
    public void testValidMeasurementSystems() {
        // Test for "imperial"
        assertTrue(PaintCalculator.isValidMeasurementSystem("imperial"),
                "Expected 'imperial' to be a valid measurement system.");

        // Test for "metric"
        assertTrue(PaintCalculator.isValidMeasurementSystem("metric"),
                "Expected 'metric' to be a valid measurement system.");
    }

    /**
     * Test the isValidMeasurementSystem method with invalid inputs.
     */
    @Test
    @DisplayName("Test invalid measurement systems (non-existing, null, empty string)")
    public void testInvalidMeasurementSystems() {
        // Test for a non-valid measurement system
        assertFalse(PaintCalculator.isValidMeasurementSystem("imperial1"),
                "Expected 'imperial1' to be an invalid measurement system.");

        // Test for another non-valid measurement system
        assertFalse(PaintCalculator.isValidMeasurementSystem("metric123"),
                "Expected 'metric123' to be an invalid measurement system.");

        // Test for a null input (null should be invalid)
        assertFalse(PaintCalculator.isValidMeasurementSystem(null),
                "Expected 'null' to be an invalid measurement system.");

        // Test for an empty string (should be invalid)
        assertFalse(PaintCalculator.isValidMeasurementSystem(""),
                "Expected an empty string to be an invalid measurement system.");
    }
}

