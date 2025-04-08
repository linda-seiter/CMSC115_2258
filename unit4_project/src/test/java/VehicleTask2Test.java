import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTask2Test {

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
    @DisplayName("Test: Older car with an accident")
    public void testOlderWithAccident() {
        simulateUserInput("12 true");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Older, with an accident. Avoid buying."));
    }

    @Test
    @DisplayName("Test: Older car with no accident")
    public void testOlderNoAccident() {
        simulateUserInput("12 false");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Older, no accidents. Consider buying."));
    }

    @Test
    @DisplayName("Test: Newer car with an accident")
    public void testNewerWithAccident() {
        simulateUserInput("5 true");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString()
                .contains("Newer, but involved in an accident. Caution advised, think twice."));
    }

    @Test
    @DisplayName("Test: Newer car with no accident")
    public void testNewerNoAccident() {
        simulateUserInput("5 false");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Newer, no accidents! Highly recommended to buy."));
    }

    @Test
    @DisplayName("Test: Exactly 10 years old car with no accident")
    public void testExactlyTenYearsOldNoAccident() {
        simulateUserInput("10 false");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Newer, no accidents! Highly recommended to buy."));
    }

    @Test
    @DisplayName("Test: Exactly 10 years old car with an accident")
    public void testExactlyTenYearsOldWithAccident() {
        simulateUserInput("10 true");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString()
                .contains("Newer, but involved in an accident. Caution advised, think twice."));
    }

    @Test
    @DisplayName("Test: Just over 10 years old car with no accident")
    public void testJustOverTenYearsOldNoAccident() {
        simulateUserInput("11 false");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Older, no accidents. Consider buying."));
    }

    @Test
    @DisplayName("Test: Just over 10 years old car with an accident")
    public void testJustOverTenYearsOldWithAccident() {
        simulateUserInput("11 true");

        // Call the main method of VehicleTask2
        VehicleTask2.main(new String[] {});

        // Capture the output and verify
        assertTrue(outputStreamCaptor.toString().contains("Older, with an accident. Avoid buying."));
    }

    @Test
    @DisplayName("Test: Check no logical operators used in code")
    public void testNoLogicalOperatorsUsed() throws IOException {
        // Load the source code of VehicleTask2
        Path path = Paths.get("src/main/java/VehicleTask2.java");
        String code = new String(Files.readAllBytes(path));

        // Check that logical operators "&&" and "||" are not present in the code
        assertFalse(code.contains("&&"), "Logical AND operator (&&) is used in the code.");
        assertFalse(code.contains("||"), "Logical OR operator (||) is used in the code.");
    }
}
