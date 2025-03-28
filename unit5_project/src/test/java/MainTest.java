import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class MainTest {

    @Test
    public void testMainMethod() {
        // Simulating the input for room dimensions: length = 10, width = 12, height = 8, includeCeiling = true
        String userInput = "10\n12\n8\ntrue\n"; // Input is: length=10, width=12, height=8, includeCeiling=true
        InputStream systemInBackup = System.in;  // Backup original System.in
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));  // Set the simulated input

        // Capture the output printed by the main method
        ByteArrayOutputStream systemOutBackup = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutBackup));

        // Run the main method
        RoomPaintingCostCalculator.main(new String[]{});

        // Restore System.in and System.out
        System.setIn(systemInBackup);
        System.setOut(System.out);

        // Get the output
        String output = systemOutBackup.toString().trim();

        // Hardcoded expected output based on the input
        String expectedOutput = "Enter the room length, width, and height: Include ceiling (true/false): \n" +
                "Total area: 472.00 square feet, total cost: $68.44";

        // Assert that the output matches the expected value
        assertEquals(expectedOutput, output);
    }
}
