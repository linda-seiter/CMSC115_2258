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

    @Test
    @DisplayName("Test: Calculate total cost for 3.2 lbs at $4.99 per lb")
    public void testCalculateTotalCost_3_2_4_99() {
        // Simulate user input for pounds and price
        String input = "3.2 4.99";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "3.2 lbs at $4.99 per lb = $15.97\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 1.5 lbs at $3.5 per lb")
    public void testCalculateTotalCost_1_5_3_5() {
        String input = "1.5 3.5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "1.5 lbs at $3.5 per lb = $5.25\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 0 lbs at $5 per lb")
    public void testCalculateTotalCost_0_5() {
        String input = "0 5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "0.0 lbs at $5.0 per lb = $0.0\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Test: Calculate total cost for 5 lbs at $8.99 per lb")
    public void testCalculateTotalCost_5_8_99() {
        String input = "5 8.99";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                "5.0 lbs at $8.99 per lb = $44.95\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
