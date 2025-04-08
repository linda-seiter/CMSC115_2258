import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TransmissionRateTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);
    private final PrintStream originalSystemOut = System.out;
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture the output
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out and System.in
        System.setOut(originalSystemOut);
        System.setIn(originalSystemIn);
    }

    @Test
    @DisplayName("Test TransmissionRate with r0 3 and 5 iterations")
    void testTransmissionRate_3_5() {
        // Set the input stream to simulate user input
        String input = "3 5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of TransmissionRate
        TransmissionRate.main(new String[] {});

        // Expected output for the inputs 3 and 5
        String expectedOutput = "Enter r0: " + "Enter iterations: " +
                "New cases after 5 iterations: 243\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test TransmissionRate with r0 2 and 4 iterations")
    void testTransmissionRate_2_4() {
        // Set the input stream to simulate user input
        String input = "2 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of TransmissionRate
        TransmissionRate.main(new String[] {});

        // Expected output for the inputs 2 and 4
        String expectedOutput = "Enter r0: " + "Enter iterations: " +
                "New cases after 4 iterations: 16\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test TransmissionRate with r0 10 and 4 iterations")
    void testTransmissionRate_10_4() {
        // Set the input stream to simulate user input
        String input = "10 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of TransmissionRate
        TransmissionRate.main(new String[] {});

        // Expected output for the inputs 10 and 4
        String expectedOutput = "Enter r0: " + "Enter iterations: " +
                "New cases after 4 iterations: 10000\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }
}
