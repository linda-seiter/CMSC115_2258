import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerformanceSummariesTest {

    @Test
    @DisplayName("Performance Summaries for 5 trainees")
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
        String[] actualOutput = PTPerformanceAnalyzer.getPerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance summaries do not match expected output.");
    }

    @Test
    @DisplayName("Performance Summaries for 3 trainees")
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
        String[] actualOutput = PTPerformanceAnalyzer.getPerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);

        // Verify that the actual output matches the expected output
        assertArrayEquals(expectedOutput, actualOutput, "Performance summaries do not match expected output.");
    }

    @Test
    @DisplayName("getPerformanceStatus called from getPerformanceSummaries()")
    void testMethodCall() throws IOException {
        // Load source code as a string
        String filePath = "src/main/java/PTPerformanceAnalyzer.java"; // Update path as needed
        String sourceCode = Files.readString(Paths.get(filePath));

        // Regex pattern to extract the getPerformanceSummaries method body
        Pattern methodPattern = Pattern.compile(
                "public\\s+static\\s+String\\[\\]\\s+getPerformanceSummaries\\s*\\(.*?\\)\\s*\\{(.*?)\\}",
                Pattern.DOTALL);
        Matcher methodMatcher = methodPattern.matcher(sourceCode);

        assertTrue(methodMatcher.find(), "Method getPerformanceSummaries not found in source code.");
        String methodBody = methodMatcher.group(1);

        // Check for method call using regex
        assertTrue(methodBody.contains("getPerformanceStatus("), "Method getPerformanceStatus is not called.");
    }

}
