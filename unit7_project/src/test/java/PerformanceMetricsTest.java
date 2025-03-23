import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.MockedStatic;

public class PerformanceMetricsTest {

    @Test
    @DisplayName("Method getPerformanceMetrics returns correct result")
    void testGetPerformanceMetrics() {
        int[] scores = {10, 8, 30, 68, 50};
        String expectedOutput = "*** Push-ups *** Max: 68, Min: 8, Mean: 33.20";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getPerformanceMetrics(scores, "Push-ups"));

        int[] singleValue = {42};
        expectedOutput = "*** Sit-ups *** Max: 42, Min: 42, Mean: 42.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getPerformanceMetrics(singleValue, "Sit-ups"));

        int[] allSame = {25, 25, 25, 25};
        expectedOutput = "*** Lunges *** Max: 25, Min: 25, Mean: 25.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getPerformanceMetrics(allSame, "Lunges"));
    }

    @Test
    @DisplayName("Method getPerformanceMetrics calls findMinValue, findMaxValue, calculateMean")
    void testGetPerformanceMetrics_Calls_MinMaxMean() {
        try (MockedStatic<PTPerformanceAnalyzer> mockedStatic = mockStatic(PTPerformanceAnalyzer.class)) {
            // Stub the static methods to return dummy values
            mockedStatic.when(() -> PTPerformanceAnalyzer.findMinValue(any())).thenReturn(0);
            mockedStatic.when(() -> PTPerformanceAnalyzer.findMaxValue(any())).thenReturn(0);
            mockedStatic.when(() -> PTPerformanceAnalyzer.calculateMean(any())).thenReturn(0.0);
            mockedStatic.when(() -> PTPerformanceAnalyzer.getPerformanceMetrics(any(), any()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PTPerformanceAnalyzer.getPerformanceMetrics(new int[]{10, 20, 5, 30, 25}, "Exercise");

            // Verify that findMinValue, findMaxValue, calculateMeanValue() called
            mockedStatic.verify(() -> PTPerformanceAnalyzer.findMinValue(any()), atLeastOnce());
            mockedStatic.verify(() -> PTPerformanceAnalyzer.findMaxValue(any()), atLeastOnce());
            mockedStatic.verify(() -> PTPerformanceAnalyzer.calculateMean(any()), atLeastOnce());
        }
    }

}
