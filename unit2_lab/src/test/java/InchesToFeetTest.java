import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class InchesToFeetTest {

    // To capture the output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // To capture the input
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpStreams() {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        // Restore System.out and System.in to original
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("Test conversion for 3 inches to feet")
    void testInchesToFeet_3Inches() {
        // Simulate user input for 3 inches
        simulateUserInput("3");

        // Run the main method of InchesToFeet
        InchesToFeet.main(new String[] {});

        // Get the captured output
        String expectedOutput = "Enter inches: " +
                "3 inches = 0.25 feet";
        assertEquals(expectedOutput, outContent.toString().trim());

    }

    @Test
    @DisplayName("Test conversion for 12 inches to feet")
    void testInchesToFeet_12Inches() {
        // Simulate user input for 12 inches
        simulateUserInput("12");

        // Run the main method of InchesToFeet
        InchesToFeet.main(new String[] {});

        // Get the captured output
        String expectedOutput = "Enter inches: 12 inches = 1.0 feet";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test conversion for 18 inches to feet")
    void testInchesToFeet_18Inches() {
        // Simulate user input for 18 inches
        simulateUserInput("18");

        // Run the main method of InchesToFeet
        InchesToFeet.main(new String[] {});

        // Get the captured output
        String expectedOutput = "Enter inches: 18 inches = 1.5 feet";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test conversion for 24 inches to feet")
    void testInchesToFeet_24Inches() {
        // Simulate user input for 24 inches
        simulateUserInput("24");

        // Run the main method of InchesToFeet
        InchesToFeet.main(new String[] {});

        // Get the captured output
        String expectedOutput = "Enter inches: 24 inches = 2.0 feet";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
