import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloTestV2 {

    @Test
    @DisplayName("Hello.main prints correct output")
    void helloOutput() {

        String expectedOutput = "Hello World!\n";

        // Capture the output from Hello.main
        String actualOutput = JunitHelper.mainOutput("Hello");

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}