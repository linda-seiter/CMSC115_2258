import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class PaycheckTest {

    @Test
    @DisplayName("Paycheck.main prints correct output")
    public void paycheckOutput() throws Exception {
        String expectedOutput = "Week#1 hours: 35 rate: $18.25 pay: $638.75\n"
                + "Week#2 hours: 39 rate: $18.25 pay: $711.75\n"
                + "Week#3 hours: 27 rate: $18.75 pay: $506.25\n";

        // Capture the output from BillSplitter.main
        String actualOutput = tapSystemOutNormalized(() -> {
            Paycheck.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}
