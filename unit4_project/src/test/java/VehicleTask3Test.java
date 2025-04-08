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

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Sedan: Great for commuting."));
    }

    @Test
    @DisplayName("Test: SUV - Perfect for off-road trips")
    public void testSUV() {
        simulateUserInput("SUV");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("SUV: Perfect for off-road trips."));
    }

    @Test
    @DisplayName("Test: Truck - Great for heavy loads")
    public void testTruck() {
        simulateUserInput("Truck");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Truck: Great for heavy loads."));
    }

    @Test
    @DisplayName("Test: Uncommon - Custom model input")
    public void testUncommon() {
        simulateUserInput("Coupe");

        // Call the main method of VehicleTask3
        VehicleTask3.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Uncommon: Coupe"));
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
