import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerformanceStatusTest {

    @Test
    void testPassCondition() {
        assertEquals("Pass", PTPerformanceAnalyzer.getPerformanceStatus(20, 30, 15, 25), "Should return 'Pass' when both push-ups and sit-ups meet the minimum.");
    }

    @Test
    void testFailPushUps() {
        assertEquals("Fail", PTPerformanceAnalyzer.getPerformanceStatus(10, 30, 15, 25), "Should return 'Fail' when push-ups are below the minimum.");
    }

    @Test
    void testFailSitUps() {
        assertEquals("Fail", PTPerformanceAnalyzer.getPerformanceStatus(20, 20, 15, 25), "Should return 'Fail' when sit-ups are below the minimum.");
    }

    @Test
    void testFailBoth() {
        assertEquals("Fail", PTPerformanceAnalyzer.getPerformanceStatus(10, 20, 15, 25), "Should return 'Fail' when both push-ups and sit-ups are below the minimum.");
    }

    @Test
    void testEdgeCaseExactThreshold() {
        assertEquals("Pass", PTPerformanceAnalyzer.getPerformanceStatus(15, 25, 15, 25), "Should return 'Pass' when push-ups and sit-ups are exactly at the minimum.");
    }

    @Test
    void testEdgeCaseOneAboveThreshold() {
        assertEquals("Pass", PTPerformanceAnalyzer.getPerformanceStatus(16, 26, 15, 25), "Should return 'Pass' when push-ups and sit-ups exceed the minimum by 1.");
    }

}
