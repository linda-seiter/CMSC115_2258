import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTask3Test {

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

    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("Test: Sedan - Great for commuting")
    public void testSedan() {
        simulateUserInput("Sedan");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Define the expected output
        String expectedOutput = "Enter the vehicle type (Sedan, SUV, Truck): " +
                "Sedan: Great for commuting.";

        // Compare expected and actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test: SUV - Perfect for off-road trips")
    public void testSUV() {
        simulateUserInput("SUV");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Define the expected output
        String expectedOutput = "Enter the vehicle type (Sedan, SUV, Truck): " +
                "SUV: Perfect for off-road trips.";

        // Compare expected and actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test: Truck - Great for heavy loads")
    public void testTruck() {
        simulateUserInput("Truck");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Define the expected output
        String expectedOutput = "Enter the vehicle type (Sedan, SUV, Truck): " +
                "Truck: Great for heavy loads.";

        // Compare expected and actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test: Uncommon - Custom model input")
    public void testUncommon() {
        simulateUserInput("Coupe");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Define the expected output
        String expectedOutput = "Enter the vehicle type (Sedan, SUV, Truck): " +
                "Uncommon: Coupe";

        // Compare expected and actual output
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test: Switch expression assigning to variable named message")
    public void testSwitchExpressionAssignmentToMessage() throws IOException {
        // Load the source code of VehicleTask3
        Path path = Paths.get("src/main/java/VehicleTask3.java"); // Update the path if needed
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match the switch expression that assigns to the
        // variable 'message', allowing extra spaces
        String regex = "String\\s+message\\s*=\\s*switch";

        // Create a pattern and matcher to find the match in the code
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); // DOTALL allows matching across newlines
        Matcher matcher = pattern.matcher(code);

        // Assert that the regular expression finds at least one match
        assertTrue(matcher.find(), "Switch expression assigning to message variable not found.");
    }
}
