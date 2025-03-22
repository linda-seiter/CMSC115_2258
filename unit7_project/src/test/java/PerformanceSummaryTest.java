import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerformanceSummaryTest {

    @Test
    @DisplayName("Push-ups and sit-ups meet threshold")
    void testPassScenario() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("John", 20, 30, 15, 25);
        assertEquals("John - Push-ups: 20, Sit-ups: 30 - Pass", expected);
    }

    @Test
    @DisplayName("Push-ups do not meet threshold")
    void testFailScenarioPushUps() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("Alice", 10, 30, 15, 25);
        assertEquals("Alice - Push-ups: 10, Sit-ups: 30 - Fail", expected);
    }

    @Test
    @DisplayName("Sit-ups do not meet threshold")
    void testFailScenarioSitUps() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("Bob", 20, 20, 15, 25);
        assertEquals("Bob - Push-ups: 20, Sit-ups: 20 - Fail", expected);
    }

    @Test
    @DisplayName("Push-ups and Sit-ups do not meet threshold")
    void testFailScenarioBoth() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("Alpha", 10, 10, 15, 25);
        assertEquals("Alpha - Push-ups: 10, Sit-ups: 10 - Fail", expected);
    }

    @Test
    @DisplayName("Edge case push-ups and sit-ups meet threshold")
    void testEdgeCaseExactThreshold() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("Beta", 15, 25, 15, 25);
        assertEquals("Beta - Push-ups: 15, Sit-ups: 25 - Pass", expected);
    }

    @Test
    @DisplayName("Edge case one below push-ups and sit-ups do not meet threshold")
    void testEdgeCaseOneBelowThreshold() {
        String expected = PTPerformanceAnalyzer.getPerformanceSummary("Gamma", 14, 24, 15, 25);
        assertEquals("Gamma - Push-ups: 14, Sit-ups: 24 - Fail", expected);
    }

}
