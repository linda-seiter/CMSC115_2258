import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

public class ExtractPersonnelTest {
    private final String missionLog = "Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel."
            + "Operation Mirage: Mission failed; Personnel: Carlos Hernandez, Mei Wong."
            + "Operation Eclipse: Mission in progress; Personnel: Akira Yamamoto, Zainab Ali, Carlos Gonzalez."
            + "Operation Vortex: Mission aborted; Personnel: Jamal Khan, Priya Gupta, Ana Silva.";

    @Test
    @DisplayName("Test: Extract personnel for operation 'Eclipse'")
    public void testExtractPersonnelForOperationEclipse() {
        // Test extracting personnel for operation "Eclipse"
        String result = MissionLogAnalyzer.extractPersonnelForOperation(missionLog, "Eclipse");
        assertEquals("Personnel for Eclipse: Akira Yamamoto, Zainab Ali, Carlos Gonzalez", result,
                "Personnel for the 'Eclipse' operation should be extracted correctly.");
    }

    @Test
    @DisplayName("Test: Extract personnel for operation 'Vortex'")
    public void testExtractPersonnelForOperationVortex() {
        // Test extracting personnel for operation "Vortex"
        String result = MissionLogAnalyzer.extractPersonnelForOperation(missionLog, "Vortex");
        assertEquals("Personnel for Vortex: Jamal Khan, Priya Gupta, Ana Silva", result,
                "Personnel for the 'Vortex' operation should be extracted correctly.");
    }

    @Test
    @DisplayName("Test: Extract personnel for non-existing operation")
    public void testExtractPersonnelForOperationNotFound() {
        // Test when operation "Alpha" doesn't exist
        String result = MissionLogAnalyzer.extractPersonnelForOperation(missionLog, "Alpha");
        assertEquals("Alpha not found.", result, "Personnel for a non-existent operation should return an error message.");
    }

    @Test
    @DisplayName("Test: Extract personnel with case insensitive operation name")
    public void testExtractPersonnelForOperationCaseInsensitive() {
        // Test case-insensitive search for the operation "thunderstorm"
        String result = MissionLogAnalyzer.extractPersonnelForOperation(missionLog, "thunderstorm");
        assertEquals("Personnel for thunderstorm: Aisha Mohammed, Wei Li, Raj Patel", result,
                "Personnel extraction should be case insensitive.");
    }

    @Test
    @DisplayName("Test: Extract personnel for operation with null name")
    public void testExtractPersonnelForNullOperation() {
        // Test when null is provided as the operation name
        String result = MissionLogAnalyzer.extractPersonnelForOperation(missionLog, null);
        assertEquals("null not found.", result, "Personnel extraction should return not found for a null operation name.");
    }

    @Test
    @DisplayName("Method extractPersonnelForOperation calls searchOperation")
    void testGetPerformanceMetrics_Calls_MinMaxMean() {
        try (MockedStatic<MissionLogAnalyzer> mockedStatic = mockStatic(MissionLogAnalyzer.class)) {
            // Stub the static methods to return dummy values
            String mission = "Operation Thunderstorm: Mission completed; Personnel: Aisha Mohammed, Wei Li, Raj Patel.";
            mockedStatic.when(() -> MissionLogAnalyzer.searchOperation(any(), any())).thenReturn(mission);
            mockedStatic.when(() -> MissionLogAnalyzer.extractPersonnelForOperation(any(), any()))
                    .thenCallRealMethod();  // Ensures the method executes while keeping mocks

            // Call the static method being tested
            MissionLogAnalyzer.extractPersonnelForOperation(mission, "Thunderstorm");

            // Verify that searchOperation() called
            mockedStatic.verify(() -> MissionLogAnalyzer.searchOperation(any(), any()), atLeastOnce());
        }
    }


}
