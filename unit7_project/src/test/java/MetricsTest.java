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
    @DisplayName("Summative value")
    void testGetSum() {
        assertEquals(210, PTPerformanceAnalyzer.calculateSum(new int[]{10, 20, 100, 50, 30}), "calculateSum(new int[]{10, 20, 100, 50, 30})");
        assertEquals(-13, PTPerformanceAnalyzer.calculateSum(new int[]{-5, -10, 0, 5, -3}), "calculateSum(new int[]{-5, -10, 0, 5, -3})");
        assertEquals(-39, PTPerformanceAnalyzer.calculateSum(new int[]{-5, -10, -3, -1, -20}), "calculateSum(new int[]{-5, -10, -3, -1, -20})");
        assertEquals(42, PTPerformanceAnalyzer.calculateSum(new int[]{42}), "calculateSum(new int[]{42})"); // Single element
        assertEquals(0, PTPerformanceAnalyzer.calculateSum(new int[]{0, 0, 0, 0}), "calculateSum(new int[]{0, 0, 0, 0})"); // All zeros
    }

}
