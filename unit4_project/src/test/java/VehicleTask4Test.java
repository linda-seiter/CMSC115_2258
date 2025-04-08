import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTask4Test {

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
    @DisplayName("Test Eco-Friendly Electric with Small Engine")
    public void testEcoFriendlyElectric() {
        // Simulate input for an electric with engine size 1.8L (space-separated
        // input)
        simulateUserInput("electric 1.8");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Eco-Friendly vehicle."));
    }

    @Test
    @DisplayName("Test Eco-Friendly Hybrid  with Engine Size 2.0L")
    public void testEcoFriendlyHybrid() {
        // Simulate input for a hybrid with engine size 2.0L (space-separated input)
        simulateUserInput("hybrid 2.0");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Eco-Friendly vehicle."));
    }

    @Test
    @DisplayName("Test Not Eco-Friendly Gas  with Large Engine")
    public void testNotEcoFriendlyGas() {
        // Simulate input for a gas with engine size 3.0L (space-separated input)
        simulateUserInput("gas 3.0");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the not eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Not eco-friendly vehicle."));
    }

    @Test
    @DisplayName("Test Not Eco-Friendly Diesel with Engine Size 2.5L")
    public void testNotEcoFriendlyDiesel() {
        // Simulate input for a diesel with engine size 2.5L (space-separated input)
        simulateUserInput("diesel 2.5");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the not eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Not eco-friendly vehicle."));
    }

    @Test
    @DisplayName("Test Not Eco-Friendly Electric  with Large Engine")
    public void testNotEcoFriendlyElectricLargeEngine() {
        // Simulate input for an electric with engine size 2.5L (space-separated
        // input)
        simulateUserInput("electric 2.5");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the not eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Not eco-friendly vehicle."));
    }

    @Test
    @DisplayName("Test Not Eco-Friendly Hybrid with Large Engine")
    public void testNotEcoFriendlyHybridLargeEngine() {
        // Simulate input for a hybrid with engine size 2.5L (space-separated input)
        simulateUserInput("hybrid 2.5");

        // Call the main method of VehicleTask4
        VehicleTask4.main(new String[] {});

        // Capture the output and verify it contains the not eco-friendly message
        assertTrue(outputStreamCaptor.toString().contains("Not eco-friendly vehicle."));
    }

    @Test
    @DisplayName("Test: Ternary operator used in assign variable named message")
    public void testTernaryOperatorAssignmentToMessage() throws IOException {
        // Load the source code of VehicleTask4
        Path path = Paths.get("src/main/java/VehicleTask4.java"); // Update the path if needed
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match the ternary operator that assigns to the
        // variable 'message', allowing extra spaces
        String regex = "String\\s+message\\s*=\\s*\\(.*\\?\\s*.*:\\s*.*\\);";

        // Create a pattern and matcher to find the match in the code
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); // DOTALL allows matching across newlines
        Matcher matcher = pattern.matcher(code);

        // Assert that the regular expression finds at least one match
        assertTrue(matcher.find(), "Ternary operator assigning to message variable not found.");
    }

}
