import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractOperationNamesTest {


    @Test
    @DisplayName("Test: Extract operation names from the mission log")
    public void testExtractOperationNames() {
        // Sample mission log
        String missionLog = "Operation Omega: Mission successful; Personnel: Samira Patel, Alex Chen, Kai Lopez."
                + "Operation Beta: Mission failed; Personnel: Amari Jackson, Noor Al-Farsi."
                + "Operation Gamma: Mission in progress; Personnel: Riley Kim, Casey Brooks, Taylor Lee.";
        // Test extracting all operation names
        String result = MissionLogAnalyzer.extractOperationNames(missionLog);
        String expected = "Omega.Beta.Gamma.";
        assertEquals(expected, result, "The operation names should be extracted correctly from the mission log.");
    }

    @Test
    @DisplayName("Test: Extract operation names with no operations")
    public void testExtractOperationNamesNoOperations() {
        // Test when the mission log has no operations
        String emptyLog = "";
        String result = MissionLogAnalyzer.extractOperationNames(emptyLog);
        assertEquals("No missions found.", result, "When no operations are found, it should return 'No missions found.'");
    }

    @Test
    @DisplayName("Test: Extract operation names with additional spaces or newlines")
    public void testExtractOperationNamesWithExtraSpaces() {
        // Test handling of extra spaces or newlines
        String logWithExtraSpaces = "Operation    Alpha : Mission successful; Personnel: Samira Patel, Alex Chen, Kai Lopez.\n"
                + "  Operation  Beta:   Mission failed; Personnel: Amari Jackson, Noor Al-Farsi.";
        String result = MissionLogAnalyzer.extractOperationNames(logWithExtraSpaces);
        String expected = "Alpha.Beta.";
        assertEquals(expected, result, "The method should correctly extract operation names even with extra spaces or newlines.");
    }

    @Test
    @DisplayName("Test: Extract operation names with null log")
    public void testExtractOperationNamesNullLog() {
        // Test with null log input
        String result = MissionLogAnalyzer.extractOperationNames(null);
        assertEquals("No missions found.", result, "When the mission log is null, it should return 'No missions found.'");
    }
}
