import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class MainTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemInStream = System.in;
    private final PrintStream originalSystemOutStream = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        // Restore original System.in and System.out
        System.setIn(originalSystemInStream);
        System.setOut(originalSystemOutStream);
    }

    // Helper method to simulate user input
    private void setUserInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    // Helper method to get the last line of the captured output
    private String getLastLineOfOutput() {
        String[] lines = outputStreamCaptor.toString().split("\n");
        return lines[lines.length - 1].trim();  // Get the last line of output
    }

    @Test
    @DisplayName("Test Imperial Units (feet and gallons) with Ceiling Included")
    public void testMainMethodImperial() {
        // Simulate input for length=10, width=12, height=8, includeCeiling=true, isMetric=false (imperial)
        String userInput = "10 12 8\ntrue\nfalse\n";
        setUserInput(userInput);

        PaintEstimator.main(new String[] {});

        // Expected output for imperial system:
        String expectedOutput = "Total area: 472.00 square feet, paint: 2 gallons, total cost: $100.00";

        // Get the last line of the output
        String actualOutput = getLastLineOfOutput();

        // Compare expected and actual output directly
        assertEquals(expectedOutput, actualOutput, "Imperial test failed: The output does not match the expected result.");
    }

    @Test
    @DisplayName("Test Metric Units (meters and liters) without Ceiling Included")
    public void testMainMethodMetric() {
        // Simulate input for length=5, width=4, height=3, includeCeiling=false, isMetric=true
        String userInput = "5 4 3\nfalse\ntrue\n";
        setUserInput(userInput);

        PaintEstimator.main(new String[] {});

        // Expected output for metric system:
        String expectedOutput = "Total area: 54.00 square meters, paint: 6 liters, total cost: $120.00";

        // Get the last line of the output
        String actualOutput = getLastLineOfOutput();

        // Compare expected and actual output directly
        assertEquals(expectedOutput, actualOutput, "Metric test failed: The output does not match the expected result.");
    }

    @Test
    @DisplayName("Test Invalid Dimensions (length = 0)")
    public void testMainMethodInvalidDimensions() {
        // Test zero dimensions (length = 0) which should print the error message
        String userInput = "0 10 8\ntrue\ntrue\n";
        setUserInput(userInput);

        PaintEstimator.main(new String[] {});

        String expectedOutput = "Invalid room dimensions. No paint needed.";

        // Get the last line of the output
        String actualOutput = getLastLineOfOutput();

        // Compare expected and actual output directly
        assertEquals(expectedOutput, actualOutput, "Invalid dimensions test failed: Expected error message not displayed.");
    }

    @Test
    @DisplayName("Test Zero Length Dimension")
    public void testMainMethodZeroLength() {
        // Test zero length dimension which should print error message
        String userInput = "0 5 8\nfalse\ntrue\n";
        setUserInput(userInput);

        PaintEstimator.main(new String[] {});

        String expectedOutput = "Invalid room dimensions. No paint needed.";

        // Get the last line of the output
        String actualOutput = getLastLineOfOutput();

        // Compare expected and actual output directly
        assertEquals(expectedOutput, actualOutput, "Zero length test failed: Expected error message not displayed.");
    }

    @Test
    @DisplayName("Test Zero Height Dimension")
    public void testMainMethodZeroHeight() {
        // Test zero height dimension which should print error message
        String userInput = "5 5 0\ntrue\nfalse\n";
        setUserInput(userInput);

        PaintEstimator.main(new String[] {});

        String expectedOutput = "Invalid room dimensions. No paint needed.";

        // Get the last line of the output
        String actualOutput = getLastLineOfOutput();

        // Compare expected and actual output directly
        assertEquals(expectedOutput, actualOutput, "Zero height test failed: Expected error message not displayed.");
    }
}
