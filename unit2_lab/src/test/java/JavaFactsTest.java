import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JavaFactsTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture the output
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out
        System.setOut(originalSystemOut);
    }

    @Test
    @DisplayName("Test the output of JavaFacts.main()")
    void testJavaFactSolutionOutput() {
        // Run the main method of JavaFacts
        JavaFacts.main(new String[] {});

        // Capture the entire output and compare to the expected result
        String expectedOutput = "Java was initially named Oak.\nJava is an object-oriented language.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
