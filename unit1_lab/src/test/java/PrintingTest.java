import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class PrintingTest {

    @Test
    @DisplayName("Printing.main prints correct output")
    void printingOutput() throws Exception {
        String expectedOutput = "red \n"
                + "green blue \n"
                + "pink \n"
                + "yellow\n";

        // Capture the output from Printing.main
        String actualOutput = tapSystemOutNormalized(() -> {
            Printing.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}