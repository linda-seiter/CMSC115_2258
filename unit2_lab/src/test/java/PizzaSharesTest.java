import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaSharesTest {

        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        private final PrintStream printStream = new PrintStream(outputStream);
        private final PrintStream originalSystemOut = System.out;
        private final InputStream originalSystemIn = System.in;

        @BeforeEach
        void setUp() {
                // Redirect System.out to capture the output
                System.setOut(printStream);
        }

        @AfterEach
        void tearDown() {
                // Restore the original System.out and System.in
                System.setOut(originalSystemOut);
                System.setIn(originalSystemIn);
        }

        @Test
        @DisplayName("Test PizzaShares with inputs 24 and 10")
        void testPizzaSharesWith24and10() {
                // Set the input stream to simulate user input for the first test case
                String input = "24 10";
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                // Run the main method of PizzaShares
                PizzaShares.main(new String[] {});

                // Expected output for the inputs 24 and 10
                String expectedOutput1 = "Enter #slices and #people: " +
                                "Each person gets 2 slices.\nThere are 4 slices remaining.\n";

                // Check if the captured output matches the expected output
                assertEquals(expectedOutput1, outputStream.toString());
        }

        @Test
        @DisplayName("Test PizzaShares with inputs 12 and 4")
        void testPizzaSharesWith12and4() {
                // Set the input stream to simulate user input for the second test case
                String input = "12 4";
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                // Run the main method of PizzaShares
                PizzaShares.main(new String[] {});

                // Expected output for the inputs 12 and 4
                String expectedOutput2 = "Enter #slices and #people: " +
                                "Each person gets 3 slices.\nThere are 0 slices remaining.\n";

                // Check if the captured output matches the expected output
                assertEquals(expectedOutput2, outputStream.toString());
        }
}
