import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaintCostReportTest {
    // Test case 1: Checking the report for a positive input
    @Test
    @DisplayName("generatePaintCostReport with non-zero values")
    public void testGeneratePaintCostReport_validInput() {
        // Given
        double surfaceArea = 500.0; // example surface area in square feet
        double paintCost = 72.5;    // example cost in dollars

        // When
        String report = RoomPaintingCostCalculator.generatePaintCostReport(surfaceArea, paintCost);

        // Then
        assertEquals("Total area: 500.00 square feet, total cost: $72.50", report);
    }

    // Test case 2: Checking the report for a zero area and cost
    @Test
    @DisplayName("generatePaintCostReport zero values")
    public void testGeneratePaintCostReport_zeroArea() {
        // Given
        double surfaceArea = 0.0; // surface area of zero
        double paintCost = 0.0;   // cost of paint is also zero

        // When
        String report = RoomPaintingCostCalculator.generatePaintCostReport(surfaceArea, paintCost);

        // Then
        assertEquals("Total area: 0.00 square feet, total cost: $0.00", report);
    }

}