import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PaintCalculatorTest {

    @Test
    void testMainImperial() {
        String input = "imperial\n10 15 8\n"; // Simulate input: "imperial", followed by room dimensions
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        PaintCalculator.main(new String[]{});

        // Get the printed output
        String output = outputStream.toString();

        // Validate the output (you can adjust the expected output based on the room size)
        assertTrue(output.contains("Total area:"));
        assertTrue(output.contains("Amount of paint required:"));
        assertTrue(output.contains("Total paint cost:"));
    }

    @Test
    void testMainMetric() {
        String input = "metric\n5 10 3\n"; // Simulate input: "metric", followed by room dimensions
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        PaintCalculator.main(new String[]{});

        // Get the printed output
        String output = outputStream.toString();

        // Validate the output
        assertTrue(output.contains("Total area:"));
        assertTrue(output.contains("Amount of paint required:"));
        assertTrue(output.contains("Total paint cost:"));
    }

    @Test
    void testMainInvalidMeasurementSystem() {
        // Simulate an invalid measurement system input
        String input = "unknown\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        PaintCalculator.main(new String[]{});

        // Get the printed output and check for error message
        String output = outputStream.toString();

        // Validate that the program prompts again after invalid input
        assertTrue(output.contains("Invalid input."));
    }
}
