import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class BillSplitterTest {

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
    @DisplayName("Test: BillSplitter verify each person's share of the bill")
    public void testBillSplitter() {
        // Call the main method of BillSplitter
        BillSplitter.main(new String[] {});

        // Get the captured output as a string
        String output = outContent.toString();

        // The expected output (each person owes $56.52 after tax)
        String expectedOutput = "Each person owes: 56.52\n";

        // Verify the output
        assertEquals(expectedOutput, output, "BillSplitter class output does not match the expected result.");
    }
}
