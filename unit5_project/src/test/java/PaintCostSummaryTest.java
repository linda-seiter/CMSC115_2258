import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaintCostSummaryTest {
    @Test
    @DisplayName("Generate summary with metric units")
    void testGeneratePaintCostSummary_Metric() {
        double surfaceArea = 25.0;
        int volume = 3;
        boolean isMetric = true;

        String expected = "Total area: 25.00 square meters, paint: 3 liters, total cost: $60.00";
        String actual = PaintEstimator.generatePaintCostSummary(surfaceArea, volume, isMetric);

        assertEquals(expected, actual, "Summary with metric units should match expected format and values.");
    }

    @Test
    @DisplayName("Generate summary with imperial units")
    void testGeneratePaintCostSummary_Imperial() {
        double surfaceArea = 350.0;
        int volume = 2;
        boolean isMetric = false;

        String expected = "Total area: 350.00 square feet, paint: 2 gallons, total cost: $100.00";
        String actual = PaintEstimator.generatePaintCostSummary(surfaceArea, volume, isMetric);

        assertEquals(expected, actual, "Summary with imperial units should match expected format and values.");
    }

    @Test
    @DisplayName("Generate summary with zero volume")
    void testGeneratePaintCostSummary_ZeroVolume() {
        double surfaceArea = 100.0;
        int volume = 0;
        boolean isMetric = true;

        String expected = "Total area: 100.00 square meters, paint: 0 liters, total cost: $0.00";
        String actual = PaintEstimator.generatePaintCostSummary(surfaceArea, volume, isMetric);

        assertEquals(expected, actual, "Summary with zero paint volume should report zero total cost.");
    }

}