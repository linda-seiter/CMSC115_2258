import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MetricsTest {

    @Test
    @DisplayName("Maximum value")
    void testGetMax() {
        assertEquals(100, PTPerformanceAnalyzer.findMaxValue(new int[]{10, 20, 100, 50, 30}), "findMaxValue(new int[]{10, 20, 100, 50, 30})");
        assertEquals(5, PTPerformanceAnalyzer.findMaxValue(new int[]{-5, -10, 0, 5, -3}), "findMaxValue(new int[]{-5, -10, 0, 5, -3})");
        assertEquals(-1, PTPerformanceAnalyzer.findMaxValue(new int[]{-5, -10, -3, -1, -20}),  "findMaxValue(new int[]{-5, -10, -3, -1, -20})");
        assertEquals(42, PTPerformanceAnalyzer.findMaxValue(new int[]{42}), "findMaxValue(new int[]{42})"); // Single element
    }

    @Test
    @DisplayName("Minimum value")
    void testGetMin() {
        assertEquals(10, PTPerformanceAnalyzer.findMinValue(new int[]{10, 20, 100, 50, 30}), "findMinValue(new int[]{10, 20, 100, 50, 30})");
        assertEquals(-10, PTPerformanceAnalyzer.findMinValue(new int[]{-5, -10, 0, 5, -3}), "findMinValue(new int[]{-5, -10, 0, 5, -3})");
        assertEquals(-20, PTPerformanceAnalyzer.findMinValue(new int[]{-5, -10, -3, -1, -20}), "findMinValue(new int[]{-5, -10, -3, -1, -20})");
        assertEquals(42, PTPerformanceAnalyzer.findMinValue(new int[]{42}), "findMinValue(new int[]{42})"); // Single element
    }

    @Test
    @DisplayName("Mean value")
    void testCalculateMean() {
        double delta = 0.0001;
        assertEquals(42.0, PTPerformanceAnalyzer.calculateMean(new int[]{10, 20, 100, 50, 30}), delta, "calculateMean(new int[]{10, 20, 100, 50, 30})");
        assertEquals(-2.6, PTPerformanceAnalyzer.calculateMean(new int[]{-5, -10, 0, 5, -3}), delta, "calculateMean(new int[]{-5, -10, 0, 5, -3})");
        assertEquals(2.0, PTPerformanceAnalyzer.calculateMean(new int[]{2}), delta, "calculateMean(new int[]{2})");

    }

}
