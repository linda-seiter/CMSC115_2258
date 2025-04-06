import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TransmissionRateTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        // Reset System.out to its original stream
        System.setOut(originalOut);

        // Reset System.in to its original stream
        System.setIn(originalIn);
    }

    private void simulateInput(String input) {
        // Simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 16",
            "3, 81",
            "10, 10000",
            "0, 0",
            "1, 1"
    })
    @DisplayName("Test: Calculate new cases for various r0 values")
    public void testCalculateNewCases(int r0, int expectedNewCases) {
        // Simulate user input for each r0 value
        simulateInput(r0 + "\n");

        // Call the main method of TransmissionRate
        TransmissionRate.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter r0: " +
                "New cases on 4th iteration: " + expectedNewCases + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
