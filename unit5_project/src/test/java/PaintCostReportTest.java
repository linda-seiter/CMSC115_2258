import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaintCostReportTest {

    /**
     * Test paintCostReport with a valid imperial measurement system.
     */
    @Test
    @DisplayName("Test paintCostReport with imperial measurement system")
    public void testPaintCostReportWithImperial() {
        double totalArea = 200.0;
        double paintRequired = 15.0;
        double paintCost = 120.0;
        String measurementSystem = "imperial"; // Valid measurement system

        String expectedReport = String.format("Total area: %.2f square feet\n", totalArea) +
                String.format("Amount of paint required: %.2f gallons\n", paintRequired) +
                String.format("Total paint cost: $%.2f", paintCost);

        String actualReport = PaintCalculator.paintCostReport(totalArea, paintRequired, paintCost, measurementSystem);

        assertEquals(expectedReport, actualReport, "The report should be correctly formatted for imperial measurement system.");
    }

    /**
     * Test paintCostReport with a valid metric measurement system.
     */
    @Test
    @DisplayName("Test paintCostReport with metric measurement system")
    public void testPaintCostReportWithMetric() {
        double totalArea = 200.0;
        double paintRequired = 15.0;
        double paintCost = 120.0;
        String measurementSystem = "metric"; // Valid measurement system

        String expectedReport = String.format("Total area: %.2f square meters\n", totalArea) +
                String.format("Amount of paint required: %.2f liters\n", paintRequired) +
                String.format("Total paint cost: $%.2f", paintCost);

        String actualReport = PaintCalculator.paintCostReport(totalArea, paintRequired, paintCost, measurementSystem);

        assertEquals(expectedReport, actualReport, "The report should be correctly formatted for metric measurement system.");
    }

    /**
     * Test paintCostReport with an invalid measurement system.
     */
    @Test
    @DisplayName("Test paintCostReport with invalid measurement system")
    public void testPaintCostReportWithInvalidMeasurementSystem() {
        double totalArea = 200.0;
        double paintRequired = 15.0;
        double paintCost = 120.0;
        String measurementSystem = "unknown"; // Invalid measurement system

        String expectedReport = "Invalid Measurement System";

        String actualReport = PaintCalculator.paintCostReport(totalArea, paintRequired, paintCost, measurementSystem);

        assertEquals(expectedReport, actualReport, "The report should return 'Invalid Measurement System' for an invalid measurement system.");
    }

    /**
     * Test paintCostReport with an empty measurement system.
     */
    @Test
    @DisplayName("Test paintCostReport with empty measurement system")
    public void testPaintCostReportWithEmptyMeasurementSystem() {
        double totalArea = 200.0;
        double paintRequired = 15.0;
        double paintCost = 120.0;
        String measurementSystem = ""; // Invalid measurement system (empty string)

        String expectedReport = "Invalid Measurement System";

        String actualReport = PaintCalculator.paintCostReport(totalArea, paintRequired, paintCost, measurementSystem);

        assertEquals(expectedReport, actualReport, "The report should return 'Invalid Measurement System' for a null measurement system.");
    }
}