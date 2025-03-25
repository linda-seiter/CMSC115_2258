import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonnelSearchTest {

    private final String missionLog = "Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel."
            + "Operation Mirage: Mission failed; Personnel: Carlos Hernandez, Mei Wong."
            + "Operation Eclipse: Mission in progress; Personnel: Akira Yamamoto, Zainab Ali, Carlos Gonzalez."
            + "Operation Vortex: Mission aborted; Personnel: Jamal Khan, Priya Gupta, Ana Silva.";

    @Test
    @DisplayName("Test: Personnel found in mission log")
    public void testSearchPersonnelFound() {
        // Test when personnel is found in the mission log
        String result = MissionLogAnalyzer.searchPersonnel(missionLog, "Aisha Mohammed");
        assertEquals("Found: Aisha Mohammed", result, "The personnel should be found in the log.");
    }

    @Test
    @DisplayName("Test: Personnel not found in mission log")
    public void testSearchPersonnelNotFound() {
        // Test when personnel is not found in the mission log
        String result = MissionLogAnalyzer.searchPersonnel(missionLog, "Alice Cooper");
        assertEquals("Alice Cooper not found.", result, "The personnel should not be found in the log.");
    }

    @Test
    @DisplayName("Test: Personnel search is case-insensitive")
    public void testSearchPersonnelCaseInsensitive() {
        // Test case-insensitivity when searching for personnel
        String result = MissionLogAnalyzer.searchPersonnel(missionLog, "wei li");
        assertEquals("Found: wei li", result, "The search should be case-insensitive.");
    }


    @Test
    @DisplayName("Test: Personnel not found when name is null")
    public void testSearchPersonnelNullName() {
        // Test when null is provided as the personnel name
        String result = MissionLogAnalyzer.searchPersonnel(missionLog, null);
        assertEquals("null not found.", result, "The search should return a not found message for a null name.");
    }
}
