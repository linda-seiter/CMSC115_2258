import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class SeafoodMarketTest {

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

    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("Test: Calculate total cost for 3.2 lbs at $4.99 per lb")
    public void testCalculateTotalCost_3_2_4_99() {
        // Simulate user input for pounds and price
        simulateUserInput("3.2 4.99");

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "3.2 lbs at $4.99 per lb = $15.97";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 1.5 lbs at $3.5 per lb")
    public void testCalculateTotalCost_1_5_3_5() {
        simulateUserInput("1.5 3.5");

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "1.5 lbs at $3.5 per lb = $5.25";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 0 lbs at $5 per lb")
    public void testCalculateTotalCost_0_5() {
        simulateUserInput("0 5");

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "0.0 lbs at $5.0 per lb = $0.0";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 5 lbs at $8.99 per lb")
    public void testCalculateTotalCost_5_8_99() {
        simulateUserInput("5 8.99");

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "5.0 lbs at $8.99 per lb = $44.95";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
