import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class VariablesTest {

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
    @DisplayName("Test: Variables class output")
    public void testVariablesOutput() {
        // Call the main method of Variables class
        Variables.main(new String[] {});

        // Verify the output
        String expectedOutput = "Hello Silas\n" +
                "You are 28 years old.\n" +
                "Your gpa is 3.8\n";
        assertEquals(expectedOutput, outContent.toString(), "Variables fails to produce correct output");
    }
}
