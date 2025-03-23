import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class OverallPerformanceMetricsTest {

    @Test
    @DisplayName("Method getOverallPerformanceMetrics returns correct result")
    void testGetOverallPerformanceMetrics() {
        int[] scores = {10, 8, 30, 68, 50};
        String expectedOutput = "*** Push-ups *** Max: 68, Min: 8, Mean: 33.20";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(scores, "Push-ups"));

        int[] singleValue = {42};
        expectedOutput = "*** Sit-ups *** Max: 42, Min: 42, Mean: 42.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(singleValue, "Sit-ups"));

        int[] allSame = {25, 25, 25, 25};
        expectedOutput = "*** Lunges *** Max: 25, Min: 25, Mean: 25.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(allSame, "Lunges"));
    }

    @Test
    @DisplayName("Method getOverallPerformanceMetrics calls findMinValue, findMaxValue, calculateMean")
    void testGetOverallPerformanceMetrics_Calls_MinMaxMean() {
        try (MockedStatic<PTPerformanceAnalyzer> mockedStatic = mockStatic(PTPerformanceAnalyzer.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PTPerformanceAnalyzer.findMinValue(any())).thenReturn(5);
            mockedStatic.when(() -> PTPerformanceAnalyzer.findMaxValue(any())).thenReturn(30);
            mockedStatic.when(() -> PTPerformanceAnalyzer.calculateMean(any())).thenReturn(20.0);
            mockedStatic.when(() -> PTPerformanceAnalyzer.getOverallPerformanceMetrics(any(), any()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PTPerformanceAnalyzer.getOverallPerformanceMetrics(new int[]{10, 20, 5, 30, 25}, "Exercise");

            // Verify that findMinValue, findMaxValue, calculateMeanValue() called
            mockedStatic.verify(() -> PTPerformanceAnalyzer.findMinValue(any()), times(1));
            mockedStatic.verify(() -> PTPerformanceAnalyzer.findMaxValue(any()), times(1));
            mockedStatic.verify(() -> PTPerformanceAnalyzer.calculateMean(any()), times(1));
        }
    }

}
