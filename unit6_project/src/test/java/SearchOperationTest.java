import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchOperationTest {

    private final String missionLog = "Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel."
            + "Operation Mirage: Mission failed; Personnel: Carlos Hernandez, Mei Wong."
            + "Operation Eclipse: Mission in progress; Personnel: Akira Yamamoto, Zainab Ali, Carlos Gonzalez."
            + "Operation Vortex: Mission aborted; Personnel: Jamal Khan, Priya Gupta, Ana Silva.";

    @Test
    @DisplayName("Test: Search for operation 'Thunderstorm' found")
    public void testSearchOperationFound() {
        // Test when operation "Thunderstorm" is found
        String result = MissionLogAnalyzer.searchOperation(missionLog, "Thunderstorm");
        assertEquals("Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel.", result,
                "The operation should be found in the log.");
    }

    @Test
    @DisplayName("Test: Search for operation 'Mirage' found")
    public void testSearchOperationMirage() {
        // Test when operation "Mirage" is found
        String result = MissionLogAnalyzer.searchOperation(missionLog, "Mirage");
        assertEquals("Operation Mirage: Mission failed; Personnel: Carlos Hernandez, Mei Wong.", result,
                "The operation 'Mirage' should be found.");
    }

    @Test
    @DisplayName("Test: Search for non-existing operation")
    public void testSearchOperationNotFound() {
        // Test when an operation is not found
        String result = MissionLogAnalyzer.searchOperation(missionLog, "Alpha");
        assertEquals("Alpha not found.", result, "The operation 'Alpha' should not be found in the log.");
    }

    @Test
    @DisplayName("Test: Search for operation with mixed case")
    public void testSearchOperationCaseInsensitive() {
        // Test case-insensitivity when searching for the operation
        String result = MissionLogAnalyzer.searchOperation(missionLog, "thunderstorm");
        assertEquals("Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel.", result,
                "The search should be case-insensitive.");
    }

    @Test
    @DisplayName("Test: Null operation name search")
    public void testSearchOperationNullName() {
        // Test when null is provided as the operation name
        String result = MissionLogAnalyzer.searchOperation(missionLog, null);
        assertEquals("null not found.", result, "The search should return a not found message for a null operation name.");
    }
}
