import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GasPurchaseTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;
        private final InputStream originalIn = System.in;

        @BeforeEach
        public void setUp() {
                // Redirect System.out to capture the output
                System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void tearDown() {
                // Reset System.out to its original stream
                System.setOut(originalOut);

                // Reset System.in to its original stream
                System.setIn(originalIn);
        }

        private void simulateInput(String input) {
                // Simulate user input
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);
        }

        @Test
        @DisplayName("Test: GasPurchase 12.5 gallons at $3.50 per gallon")
        public void testCalculateTotalFor12pt5GallonsAt3pt50PerGallon() {
                // Simulate user input for 12.5 gallons at $3.50 per gallon
                simulateInput("12.5 3.5\n");

                // Call the main method
                GasPurchase.main(new String[] {});

                // Verify the output
                String expectedOutput = "Enter gallons and price per gallon: " +
                                "You owe $43.75\n";
                assertEquals(expectedOutput, outContent.toString(), "GasPurchase fails to print correct output");
        }

        @Test
        @DisplayName("Test: GasPurchase 8 gallons at $3.75 per gallon")
        public void testCalculateTotalFor8GallonsAt3pt75PerGallon() {
                // Simulate user input for 8 gallons at $3.75 per gallon
                simulateInput("8 3.75\n");

                // Call the main method
                GasPurchase.main(new String[] {});

                // Verify the output
                String expectedOutput = "Enter gallons and price per gallon: " +
                                "You owe $30.0\n";
                assertEquals(expectedOutput, outContent.toString(), "GasPurchase fails to print correct output");
        }

}
