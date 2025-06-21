import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaintQuantityTest {

    @Test
    @DisplayName("Imperial: Area of 700 sq ft should require 2 gallons")
    void testImperialStandardArea() {
        int actual = PaintEstimator.calculatePaintQuantity(700, false);
        assertEquals(2, actual, "Expected 2 gallons for 700 sq ft in imperial units");
    }

    @Test
    @DisplayName("Metric: Area of 25 sq m should require 3 liters")
    void testMetricStandardArea() {
        int actual = PaintEstimator.calculatePaintQuantity(25, true);
        assertEquals(3, actual, "Expected 3 liters for 25 sq m in metric units");
    }

    @Test
    @DisplayName("Imperial: Area of 0 sq ft should require 0 gallons")
    void testImperialZeroArea() {
        assertEquals(0, PaintEstimator.calculatePaintQuantity(0, false),
                "Expected 0 gallons for 0 sq ft");
    }

    @Test
    @DisplayName("Metric: Area of 0 sq m should require 0 liters")
    void testMetricZeroArea() {
        assertEquals(0, PaintEstimator.calculatePaintQuantity(0, true),
                "Expected 0 liters for 0 sq m");
    }

    @Test
    @DisplayName("Imperial: Area of 1 sq ft should still require 1 gallon")
    void testImperialSmallArea() {
        int actual = PaintEstimator.calculatePaintQuantity(1, false);
        assertEquals(1, actual, "Expected 1 gallon for 1 sq ft");
    }

    @Test
    @DisplayName("Metric: Area of 1 sq m should still require 1 liter")
    void testMetricSmallArea() {
        int actual = PaintEstimator.calculatePaintQuantity(1, true);
        assertEquals(1, actual, "Expected 1 liter for 1 sq m");
    }

    @Test
    @DisplayName("Imperial: Negative area of -100 sq ft should be handled")
    void testNegativeAreaImperial() {
        int actual = PaintEstimator.calculatePaintQuantity(-100, false);
        assertEquals(0, actual, "Expected 0 gallons for negative area in imperial units");
    }

    @Test
    @DisplayName("Metric: Negative area of -20 sq m should be handled")
    void testNegativeAreaMetric() {
        int actual = PaintEstimator.calculatePaintQuantity(-20, true);
        assertEquals(0, actual, "Expected 0 liters for negative area in metric units");
    }
}
