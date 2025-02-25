import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class DebugItTest {

    @Test
    @DisplayName("DebugIt.main prints correct output")
    public void mainIOTest() throws Exception {
        String expectedOutput = "Planes on runway = 4\n";
        // Capture the output from DebugIt.main
        String actualOutput = tapSystemOutNormalized(() -> {
            DebugIt.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

    // @Test
    // @DisplayName("DebugIt.main uses += once")
    // public void plusEqualOperator() {
    // String pattern = "\\+=";
    // int expectedCount = 1;
    // int actualCount = JunitHelper.countOccurrences("DebugIt", "main", pattern);
    // assertEquals(expectedCount, actualCount);
    // }

    // @Test
    // @DisplayName("DebugIt.main uses -= once")
    // public void minusEqualOperator() {
    // String pattern = "-=";
    // int expectedCount = 1;
    // int actualCount = JunitHelper.countOccurrences("DebugIt", "main", pattern);
    // assertEquals(expectedCount, actualCount);
    // }

}
