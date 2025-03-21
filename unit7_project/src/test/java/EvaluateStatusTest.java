import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EvaluateStatusTest {

    @Test
    void testPassCondition() {
        assertEquals("Pass", PTPerformanceAnalyzer.evaluateStatus(20, 30, 15, 25), "Should return 'Pass' when both push-ups and sit-ups meet the minimum.");
    }

    @Test
    void testFailPushUps() {
        assertEquals("Fail", PTPerformanceAnalyzer.evaluateStatus(10, 30, 15, 25), "Should return 'Fail' when push-ups are below the minimum.");
    }

    @Test
    void testFailSitUps() {
        assertEquals("Fail", PTPerformanceAnalyzer.evaluateStatus(20, 20, 15, 25), "Should return 'Fail' when sit-ups are below the minimum.");
    }

    @Test
    void testFailBoth() {
        assertEquals("Fail", PTPerformanceAnalyzer.evaluateStatus(10, 20, 15, 25), "Should return 'Fail' when both push-ups and sit-ups are below the minimum.");
    }

    @Test
    void testEdgeCaseExactThreshold() {
        assertEquals("Pass", PTPerformanceAnalyzer.evaluateStatus(15, 25, 15, 25), "Should return 'Pass' when push-ups and sit-ups are exactly at the minimum.");
    }

    @Test
    void testEdgeCaseOneAboveThreshold() {
        assertEquals("Pass", PTPerformanceAnalyzer.evaluateStatus(16, 26, 15, 25), "Should return 'Pass' when push-ups and sit-ups exceed the minimum by 1.");
    }

}
