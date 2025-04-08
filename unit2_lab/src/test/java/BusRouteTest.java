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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BusRouteTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture the output
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out
        System.setOut(originalSystemOut);
    }

    @Test
    @DisplayName("Test BusRoute Output")
    void testBusRouteOutput() {
        // Run the main method of BusRoute
        BusRoute.main(new String[] {});

        // Expected output after the program runs
        String expectedOutput = "Bus begins its route\n" +
                "8 passengers get on at stop#1\n" +
                "Departing stop#1 with 8 passengers\n" +
                "2 passengers get off at stop#2\n" +
                "Departing stop#2 with 6 passengers\n" +
                "Half the passengers get off at stop#3\n" +
                "Departing stop#3 with 3 passengers\n" +
                "The number of passengers triples at stop#4\n" +
                "Departing stop#4 with 9 passengers";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    @DisplayName("BusRoute.main uses multiplication assignment operator")
    public void multiplicationOperatorTest() throws IOException {
        // Load the source code of BusRoute
        Path path = Paths.get("src/main/java/BusRoute.java"); // Adjust path if needed
        String code = new String(Files.readAllBytes(path));

        // Define a regular expression to find multiplication assignment"
        String pattern = "passengers\\s*\\*=";

        // Create a pattern and matcher to find occurrences of the pattern in the code
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(code);

        // Assert that the pattern is found at least once
        assertTrue(matcher.find(), "BusRoute must use multiplication assignment operator.");
    }

    @Test
    @DisplayName("BusRoute.main uses division assignment operator")
    public void divisionAssignmentTest() throws IOException {
        // Load the source code of BusRoute
        Path path = Paths.get("src/main/java/BusRoute.java"); // Adjust path if needed
        String code = new String(Files.readAllBytes(path));

        // Define a regular expression to find division assignment
        String pattern = "passengers\\s*\\/=";

        // Create a pattern and matcher to find occurrences of the pattern in the code
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(code);

        // Assert that the pattern is found at least once
        assertTrue(matcher.find(), "BusRoute must use division assignment operator.");
    }
}
