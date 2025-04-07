import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DebugItTest {

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
    @DisplayName("Test DebugIt Output")
    void testDebugIt() {
        // Run the main method of DebugIt
        DebugIt.main(new String[] {});

        // Expected output after the program runs
        String expectedOutput = "Planes on runway = 4\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }
}
