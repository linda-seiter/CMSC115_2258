import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class PerformanceSummariesTest {

    @Test
    @DisplayName("Performance Summaries for 5 trainees")
    void summarize_5_trainees() {
        // Sample input data of 5 trainees
        String[] names = { "River", "Sky", "Quinn", "Dakota", "Rowan" };
        int[] pushUps = { 60, 30, 50, 55, 20 }; // Push-up scores
        int[] sitUps = { 85, 70, 90, 75, 95 }; // Sit-up scores
        int minPushUps = 50; // Minimum push-ups required to pass
        int minSitUps = 80; // Minimum sit-ups required to pass

        // Expected output
        String[] expectedOutput = {
                "River - Push-ups: 60, Sit-ups: 85 - Pass",
                "Sky - Push-ups: 30, Sit-ups: 70 - Fail",
                "Quinn - Push-ups: 50, Sit-ups: 90 - Pass",
                "Dakota - Push-ups: 55, Sit-ups: 75 - Fail",
                "Rowan - Push-ups: 20, Sit-ups: 95 - Fail"
        };

        // Call the method under test
        String[] actualOutput = PTPerformanceAnalyzer.getPerformanceSummaries(names, pushUps, sitUps, minPushUps,
                minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance summaries do not match expected output.");
    }

    @Test
    @DisplayName("Performance Summaries for 3 trainees")
    void summarize_3_trainees() {
        // New input data (array size 3)
        String[] names = { "Quinn", "Avery", "Jordan" };
        int[] pushUps = { 50, 40, 55 }; // Push-up scores
        int[] sitUps = { 75, 80, 60 }; // Sit-up scores
        int minPushUps = 40; // Lower push-up requirement
        int minSitUps = 75; // Adjusted sit-up requirement

        // Expected output based on new thresholds
        String[] expectedOutput = {
                "Quinn - Push-ups: 50, Sit-ups: 75 - Pass",
                "Avery - Push-ups: 40, Sit-ups: 80 - Pass",
                "Jordan - Push-ups: 55, Sit-ups: 60 - Fail"
        };

        // Call the method under test
        String[] actualOutput = PTPerformanceAnalyzer.getPerformanceSummaries(names, pushUps, sitUps, minPushUps,
                minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance summaries do not match expected output.");
    }

    @Test
    @DisplayName("getPerformanceSummary() called from getPerformanceSummaries()")
    void testGetPerformanceMetrics_Calls_MinMaxMean() {
        try (MockedStatic<PTPerformanceAnalyzer> mockedStatic = mockStatic(PTPerformanceAnalyzer.class)) {
            // Stub the static methods to return dummy value
            mockedStatic.when(
                    () -> PTPerformanceAnalyzer.getPerformanceSummary(any(), anyInt(), anyInt(), anyInt(), anyInt()))
                    .thenReturn("");
            mockedStatic
                    .when(() -> PTPerformanceAnalyzer.getPerformanceSummaries(any(), any(), any(), anyInt(), anyInt()))
                    .thenCallRealMethod(); // Ensures the method executes while keeping mocks

            // Call the static method being tested
            PTPerformanceAnalyzer.getPerformanceSummaries(new String[] { "ABC" }, new int[] { 10 }, new int[] { 10 },
                    10, 10);

            // Verify that getPerformanceSummary() called
            mockedStatic.verify(
                    () -> PTPerformanceAnalyzer.getPerformanceSummary(any(), anyInt(), anyInt(), anyInt(), anyInt()),
                    atLeastOnce());
        }
    }

}
