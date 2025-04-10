import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class SalesAssistantTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // Restore original System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // Helper method for setting the input
    private void setInput(String input) {
        // Replace newline characters with spaces
        System.setIn(new ByteArrayInputStream(input.replace("\n", " ").getBytes()));
    }

    @Test
    @DisplayName("Test: Target Exceeded with Varying Sales Over 4 Days")
    void testTargetSlightlyExceededWithVaryingSales4Days() {
        // Provide user input
        setInput("1000 4 250 150 300 400");

        // Run the main method which should print to System.out
        SalesAssistant.main(new String[] {});

        // Capture the output and verify the exact output
        String expectedOutput = "Enter your sales target: $" +
                "Enter the number of days: " +
                "\n" +
                "Enter sales for day 1: $" +
                "Current Total: $250.00 | Daily Avg: $250.00 | Days Left: 3 | Predicted Total: $1000.00\n" +
                "PREDICTION: TARGET ACHIEVABLE.\n\n" +
                "Enter sales for day 2: $" +
                "Current Total: $400.00 | Daily Avg: $200.00 | Days Left: 2 | Predicted Total: $800.00\n" +
                "PREDICTION: TARGET AT RISK.\n\n" +
                "Enter sales for day 3: $" +
                "Current Total: $700.00 | Daily Avg: $233.33 | Days Left: 1 | Predicted Total: $933.33\n" +
                "PREDICTION: TARGET AT RISK.\n\n" +
                "Enter sales for day 4: $" +
                "Current Total: $1100.00 | Daily Avg: $275.00 | Days Left: 0 | Predicted Total: $1100.00\n" +
                "PREDICTION: TARGET ACHIEVABLE.\n\n" +
                "Target: $1000.00 | Total: $1100.00 | Congratulations! You met your target.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test: Target Not Met with Varying Sales Over 3 Days")
    void testTargetNotMetWithVaryingSales3Days() {
        // Provide user input (space-separated)
        setInput("1200 3 150 100 200");

        // Run the main method which should print to System.out
        SalesAssistant.main(new String[] {});

        // Capture the output and verify the exact output
        String expectedOutput = "Enter your sales target: $" +
                "Enter the number of days: " +
                "\n" +
                "Enter sales for day 1: $" +
                "Current Total: $150.00 | Daily Avg: $150.00 | Days Left: 2 | Predicted Total: $450.00\n" +
                "PREDICTION: TARGET AT RISK.\n\n" +
                "Enter sales for day 2: $" +
                "Current Total: $250.00 | Daily Avg: $125.00 | Days Left: 1 | Predicted Total: $375.00\n" +
                "PREDICTION: TARGET AT RISK.\n\n" +
                "Enter sales for day 3: $" +
                "Current Total: $450.00 | Daily Avg: $150.00 | Days Left: 0 | Predicted Total: $450.00\n" +
                "PREDICTION: TARGET AT RISK.\n\n" +
                "Target: $1200.00 | Total: $450.00 | Target not met. Focus on high-value sales or expanding your outreach.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test: Target Achieved with Exact Sales Over 3 Days")
    void testTargetAchievedWithExactSales3Days() {
        // Provide user input (space-separated)
        setInput("900 3 300 300 300");

        // Run the main method which should print to System.out
        SalesAssistant.main(new String[] {});

        // Capture the output and verify the exact output
        String expectedOutput = "Enter your sales target: $" +
                "Enter the number of days: " +
                "\n" +
                "Enter sales for day 1: $" +
                "Current Total: $300.00 | Daily Avg: $300.00 | Days Left: 2 | Predicted Total: $900.00\n" +
                "PREDICTION: TARGET ACHIEVABLE.\n\n" +
                "Enter sales for day 2: $" +
                "Current Total: $600.00 | Daily Avg: $300.00 | Days Left: 1 | Predicted Total: $900.00\n" +
                "PREDICTION: TARGET ACHIEVABLE.\n\n" +
                "Enter sales for day 3: $" +
                "Current Total: $900.00 | Daily Avg: $300.00 | Days Left: 0 | Predicted Total: $900.00\n" +
                "PREDICTION: TARGET ACHIEVABLE.\n\n" +
                "Target: $900.00 | Total: $900.00 | Congratulations! You met your target.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test: SalesAssistant has a for loop")
    void testForLoopPresence() throws IOException {
        Path path = Paths.get("src/main/java/SalesAssistant.java"); // Update the path if needed
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match the ternary operator that assigns to the
        // variable 'message', allowing extra spaces
        String regex = "for\\s*\\(";

        // Create a pattern and matcher to find the match in the code
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); // DOTALL allows matching across newlines
        Matcher matcher = pattern.matcher(code);

        // Assert that the regular expression finds at least one match
        assertTrue(matcher.find(), "For loop not found in main method.");

    }
}
