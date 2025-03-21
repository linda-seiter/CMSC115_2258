import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverallPerformanceMetricsTest {

    @Test
    @DisplayName("Overall Performance Metrics")
    void testGetOverallPerformanceMetrics() {
        int[] scores = {10, 8, 30, 68, 50};
        String expectedOutput = "*** Push-ups *** Max: 68, Min: 8, Avg: 33.20";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(scores, "Push-ups"));

        int[] singleValue = {42};
        expectedOutput = "*** Sit-ups *** Max: 42, Min: 42, Avg: 42.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(singleValue, "Sit-ups"));

        int[] allSame = {25, 25, 25, 25};
        expectedOutput = "*** Lunges *** Max: 25, Min: 25, Avg: 25.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.getOverallPerformanceMetrics(allSame, "Lunges"));
    }

    @Test
    @DisplayName("Metrics Methods Are Called from getOverallPerformanceMetrics()")
    void testMetricsMethodCalls() throws IOException {
        // Load source code as a string
        String filePath = "src/main/java/PTPerformanceAnalyzer.java"; // Update path as needed
        String sourceCode = Files.readString(Paths.get(filePath));

        // Regex pattern to extract the getPerformanceMetrics method body
        Pattern methodPattern = Pattern.compile(
                "public\\s+static\\s+String\\s+getOverallPerformanceMetrics\\s*\\(.*?\\)\\s*\\{(.*?)\\}",
                Pattern.DOTALL);
        Matcher methodMatcher = methodPattern.matcher(sourceCode);

        assertTrue(methodMatcher.find(), "Method getOverallPerformanceMetrics not found in source code.");
        String methodBody = methodMatcher.group(1);

        // Check for method calls using regex
        assertTrue(methodBody.contains("findMaxValue("), "Method findMaxValue() is not called.");
        assertTrue(methodBody.contains("findMinValue("), "Method findMinValue() is not called.");
        assertTrue(methodBody.contains("calculateSum("), "Method calculateSum() is not called.");
    }

}
