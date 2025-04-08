import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class NearestIntTest {

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
    @DisplayName("Test NearestInt with input 19 4")
    void testNearestInt_19_4() {
        // Set the input stream to simulate user input
        String input = "19 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of NearestInt
        NearestInt.main(new String[] {});

        // Expected output for the inputs 19 and 4
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 19/4\n"
                + "Double Value: 4.75\n"
                + "Cast as Int: 4\n"
                + "Rounded to nearest int: 5\n"
                + "Negative Value: -4.75\n"
                + "Negative Value rounded to nearest int: -5\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test NearestInt with input 11 8")
    void testNearestInt_11_8() {
        // Set the input stream to simulate user input
        String input = "11 8";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of NearestInt
        NearestInt.main(new String[] {});

        // Expected output for the inputs 11 and 8
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 11/8\n"
                + "Double Value: 1.375\n"
                + "Cast as Int: 1\n"
                + "Rounded to nearest int: 1\n"
                + "Negative Value: -1.375\n"
                + "Negative Value rounded to nearest int: -1\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test NearestInt with input 7 10")
    void testNearestInt_7_10() {
        // Set the input stream to simulate user input
        String input = "7 10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main method of NearestInt
        NearestInt.main(new String[] {});

        // Expected output for the inputs 7 and 10
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 7/10\n"
                + "Double Value: 0.7\n"
                + "Cast as Int: 0\n"
                + "Rounded to nearest int: 1\n"
                + "Negative Value: -0.7\n"
                + "Negative Value rounded to nearest int: -1\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }
}
