import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatStatsTest {

    @Test
    @DisplayName("Generate Formatted Statistics")
    void testCalculateAndFormatStatistics() {
        int[] scores = {10, 8, 30, 68, 50};
        String expectedOutput = "--- Push-ups ---\nMax: 68, Min: 8, Avg: 33.20";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.calculateAndFormatStatistics(scores, "Push-ups"));

        int[] singleValue = {42};
        expectedOutput = "--- Sit-ups ---\nMax: 42, Min: 42, Avg: 42.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.calculateAndFormatStatistics(singleValue, "Sit-ups"));

        int[] allSame = {25, 25, 25, 25};
        expectedOutput = "--- Push-ups ---\nMax: 25, Min: 25, Avg: 25.00";
        assertEquals(expectedOutput, PTPerformanceAnalyzer.calculateAndFormatStatistics(allSame, "Push-ups"));
    }

    @Test
    @DisplayName("Statistics Methods Are Called")
    void testCalculateAndFormatStatisticsMethodCalls() throws IOException {
        // Load source code as a string
        String filePath = "src/main/java/PTPerformanceAnalyzer.java"; // Update path as needed
        String sourceCode = Files.readString(Paths.get(filePath));

        // Regex pattern to extract the calculateAndFormatStatistics method body
        Pattern methodPattern = Pattern.compile(
                "public\\s+static\\s+String\\s+calculateAndFormatStatistics\\s*\\(.*?\\)\\s*\\{(.*?)\\}",
                Pattern.DOTALL);
        Matcher methodMatcher = methodPattern.matcher(sourceCode);

        assertTrue(methodMatcher.find(), "Method calculateAndFormatStatistics not found in source code.");
        String methodBody = methodMatcher.group(1);

        // Check for method calls using regex
        assertTrue(methodBody.contains("getMax("), "Method getMax() is not called.");
        assertTrue(methodBody.contains("getMin("), "Method getMin() is not called.");
        assertTrue(methodBody.contains("computeSum("), "Method computeSum() is not called.");
    }

}
