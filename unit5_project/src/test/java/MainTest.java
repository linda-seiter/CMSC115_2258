import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testMainMethod() {
        // Simulating the input for room dimensions: length = 10, width = 12, height =
        // 8, includeCeiling = true
        String userInput = "10 12 8 true"; // Input is: length=10, width=12, height=8, includeCeiling=true
        setUserInput(userInput); // Use the helper method to set input

        // Run the main method
        RoomPaintingCostCalculator.main(new String[] {});

        // Hardcoded expected output based on the input
        String expectedOutput = "Enter the room length, width, and height: Include ceiling (true/false): \n" +
                "Total area: 472.00 square feet, total cost: $68.44";

        // Assert that the output matches the expected value
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
