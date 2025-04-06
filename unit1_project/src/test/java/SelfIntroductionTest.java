import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class SelfIntroductionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        // Reset System.out to its original stream
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test: SelfIntroduction prints at least 4 lines of output")
    public void testAtLeast4LinesOfOutput() {
        // Call the main method of SelfIntroduction class
        SelfIntroduction.main(new String[] {});

        // Get the output as a string
        String output = outContent.toString();

        // Count the number of lines in the output
        long lineCount = output.lines().count();

        // Verify there are at least 4 lines of output
        assertTrue(lineCount >= 4, "Output does not contain at least 4 lines.");
    }
}
