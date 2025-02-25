import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class HelloTest {

    @Test
    @DisplayName("Hello.main prints correct output")
    void helloOutput() throws Exception {

        String expectedOutput = "Hello World!\n";

        // Capture the output from Hello.main
        String actualOutput = tapSystemOutNormalized(() -> {
            Hello.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}