import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class BillSplitterTest {

    @Test
    @DisplayName("BillSplitter.main prints correct output")
    void billSplitterOutput() throws Exception {

        String expectedOutput = "Each person owes: 56.52\n";

        // Capture the output from BillSplitter.main
        String actualOutput = tapSystemOutNormalized(() -> {
            BillSplitter.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }
}