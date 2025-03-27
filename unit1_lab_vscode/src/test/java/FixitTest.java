import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class FixitTest {

    @Test
    @DisplayName("Fixit.main prints correct output")
    void fixitOutput() throws Exception {
        String expectedOutput = "ship\n"
                + "airplane\n"
                + "tank\n";
        // Capture the output from Fixit.main
        String actualOutput = tapSystemOutNormalized(() -> {
            Fixit.main(new String[] {});
        });
        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}