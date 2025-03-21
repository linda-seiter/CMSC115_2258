import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PerformanceSummaryTest {

    @Test
    @DisplayName("Evaluate and Summarize 5 trainees")
    void summarize_5_trainees() {
        // Sample input data of 5 trainees
        String[] names = {"River", "Sky", "Quinn", "Dakota", "Rowan"};
        int[] pushUps = {60, 30, 50, 55, 20}; // Push-up scores
        int[] sitUps = {85, 70, 90, 75, 95};  // Sit-up scores
        int minPushUps = 50;  // Minimum push-ups required to pass
        int minSitUps = 80;   // Minimum sit-ups required to pass

        // Expected output
        String[] expectedOutput = {
                "River - Push-ups: 60, Sit-ups: 85 - Pass",
                "Sky - Push-ups: 30, Sit-ups: 70 - Fail",
                "Quinn - Push-ups: 50, Sit-ups: 90 - Pass",
                "Dakota - Push-ups: 55, Sit-ups: 75 - Fail",
                "Rowan - Push-ups: 20, Sit-ups: 95 - Fail"
        };

        // Call the method under test
        String[] actualOutput = PTPerformanceAnalyzer.generatePerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance evaluation results do not match expected output.");
    }

    @Test
    @DisplayName("Evaluate and Summarize 3 trainees")
    void summarize_3_trainees() {
        // New input data (array size 3)
        String[] names = {"Quinn", "Avery", "Jordan"};
        int[] pushUps = {50, 40, 55}; // Push-up scores
        int[] sitUps = {75, 80, 60};  // Sit-up scores
        int minPushUps = 40;  // Lower push-up requirement
        int minSitUps = 75;   // Adjusted sit-up requirement

        // Expected output based on new thresholds
        String[] expectedOutput = {
                "Quinn - Push-ups: 50, Sit-ups: 75 - Pass",
                "Avery - Push-ups: 40, Sit-ups: 80 - Pass",
                "Jordan - Push-ups: 55, Sit-ups: 60 - Fail"
        };

        // Call the method under test
        String[] actualOutput = PTPerformanceAnalyzer.generatePerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance evaluation results do not match expected output.");
    }
}
