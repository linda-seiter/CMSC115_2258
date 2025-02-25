import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class JavaFactsTest {

    @Test
    @DisplayName("JavaFacts.main prints correct output")
    void javaFactsOutput() throws Exception {

        String expectedOutput = "Java was initially named Oak.\n"
                + "Java is an object-oriented language.\n";

        // Capture the output from JavaFacts.main
        String actualOutput = tapSystemOutNormalized(() -> {
            JavaFacts.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}