import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                "Departing stop#4 with 9 passengers\n";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("BusRoute.main uses /= once")
    public void mainDivOpTest() {
        // Arrange
        String pattern = "passengers\s*/=\s*2";
        // Act
        int actualCount = JunitHelper.countOccurrences("BusRoute", "main", pattern);
        // Assert
        assertEquals(1, actualCount, "BusRoute uses /= once");
    }

    @Test
    @DisplayName("BusRoute.main uses *= once")
    public void mainMultOpTest() {
        // Arrange
        String pattern = "passengers\s*\\*=\s*3";
        // Act
        int actualCount = JunitHelper.countOccurrences("BusRoute", "main", pattern);
        // Assert
        assertEquals(1, actualCount, "BusRoute uses *= once");
    }
}
