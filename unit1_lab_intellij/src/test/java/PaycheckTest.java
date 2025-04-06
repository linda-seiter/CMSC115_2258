import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PaycheckTest {

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
    @DisplayName("Test: Paycheck output for 3 weeks")
    public void testPaycheckOutput() {
        // Call the main method of Paycheck class
        Paycheck.main(new String[] {});

        // Verify the output
        String expectedOutput = "Week#1 hours: 35 rate: $18.25 pay: $638.75\n" +
                "Week#2 hours: 39 rate: $18.25 pay: $711.75\n" +
                "Week#3 hours: 27 rate: $18.75 pay: $506.25\n";
        assertEquals(expectedOutput, outContent.toString(), "Paycheck fails to produce expected output");
    }
}
