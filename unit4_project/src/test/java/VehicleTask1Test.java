import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTask1Test {

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
    @DisplayName("Test Low Mileage Category")
    public void testLowMileage() {
        simulateUserInput("45000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Low mileage."));
    }

    @Test
    @DisplayName("Test Moderate Mileage Category")
    public void testModerateMileage() {
        simulateUserInput("75000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Moderate mileage."));
    }

    @Test
    @DisplayName("Test High Mileage Category")
    public void testHighMileage() {
        simulateUserInput("120000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("High mileage."));
    }

    @Test
    @DisplayName("Test Very High Mileage Category")
    public void testVeryHighMileage() {
        simulateUserInput("160000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Very high mileage."));
    }

    @Test
    @DisplayName("Test Boundary Case: Low to Moderate Mileage")
    public void testBoundaryLowToModerate() {
        simulateUserInput("50000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Moderate mileage."));
    }

    @Test
    @DisplayName("Test Boundary Case: Moderate to High Mileage")
    public void testBoundaryModerateToHigh() {
        simulateUserInput("100000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("High mileage."));
    }

    @Test
    @DisplayName("Test Boundary Case: High to Very High Mileage")
    public void testBoundaryHighToVeryHigh() {
        simulateUserInput("150000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Very high mileage."));
    }

    @Test
    @DisplayName("Test Negative Mileage Input")
    public void testNegativeMileage() {
        simulateUserInput("-1000");

        // Call the main method of VehicleTask1
        VehicleTask1.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Invalid mileage."));
    }

    @Test
    @DisplayName("Test No Logical Operators")
    public void testNoLogicalOperatorsUsed() throws IOException {
        // Load the source code of VehicleTask1
        Path path = Paths.get("src/main/java/VehicleTask1.java");
        String code = new String(Files.readAllBytes(path));

        // Check that logical operators "&&" and "||" are not present in the code
        assertFalse(code.contains("&&"), "Logical AND operator (&&) is used in the code.");
        assertFalse(code.contains("||"), "Logical OR operator (||) is used in the code.");
    }

    @Test
    @DisplayName("Test Else-If Usage")
    public void testElseIfUsed() throws IOException {
        // Load the source code of VehicleTask1
        Path path = Paths.get("src/main/java/VehicleTask1.java");
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match "else if" with any amount of whitespace or
        // newlines between
        String regex = "(?i)else\\s*if"; // (?i) makes the regex case-insensitive, \\s* allows for any whitespace

        // Check if "else if" is found with possible spaces or newlines between
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);

        // Assert that the regex finds at least one match for "else if"
        assertTrue(matcher.find(), "'else if' is not used in the code.");
    }
}
