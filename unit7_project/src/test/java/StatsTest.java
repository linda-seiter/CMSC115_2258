import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatsTest {

    @Test
    @DisplayName("Maximum value")
    void testGetMax() {
        assertEquals(100, PTPerformanceAnalyzer.getMax(new int[]{10, 20, 100, 50, 30}));
        assertEquals(5, PTPerformanceAnalyzer.getMax(new int[]{-5, -10, 0, 5, -3}));
        assertEquals(-1, PTPerformanceAnalyzer.getMax(new int[]{-5, -10, -3, -1, -20}));
        assertEquals(42, PTPerformanceAnalyzer.getMax(new int[]{42})); // Single element
    }

    @Test
    @DisplayName("Minimum value")
    void testGetMin() {
        assertEquals(10, PTPerformanceAnalyzer.getMin(new int[]{10, 20, 100, 50, 30}));
        assertEquals(-10, PTPerformanceAnalyzer.getMin(new int[]{-5, -10, 0, 5, -3}));
        assertEquals(-20, PTPerformanceAnalyzer.getMin(new int[]{-5, -10, -3, -1, -20}));
        assertEquals(42, PTPerformanceAnalyzer.getMin(new int[]{42})); // Single element
    }

    @Test
    @DisplayName("Summative value")
    void testGetSum() {
        assertEquals(210, PTPerformanceAnalyzer.computeSum(new int[]{10, 20, 100, 50, 30}));
        assertEquals(-13, PTPerformanceAnalyzer.computeSum(new int[]{-5, -10, 0, 5, -3}));
        assertEquals(-39, PTPerformanceAnalyzer.computeSum(new int[]{-5, -10, -3, -1, -20}));
        assertEquals(42, PTPerformanceAnalyzer.computeSum(new int[]{42})); // Single element
        assertEquals(0, PTPerformanceAnalyzer.computeSum(new int[]{0, 0, 0, 0})); // All zeros
    }

}
