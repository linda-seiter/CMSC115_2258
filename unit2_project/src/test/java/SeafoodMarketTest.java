import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    private void simulateInput(String input) {
        // Simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest
    @CsvSource({
            "3.2, 4.99, 15.97", // 3.2 lbs at $4.99 per lb = $15.97
            "1.5, 3.5, 5.25", // 1.5 lbs at $3.5 per lb = $5.25
            "0, 5, 0.0", // 0 lbs at $5 per lb = $0.00
            "5, 8.99, 44.95" // 5 lbs at $8.00 per lb = $44.95
    })
    @DisplayName("Test: Calculate total cost for various pounds and prices")
    public void testCalculateTotalCost(double pounds, double price, double expectedCost) {
        // Simulate user input for pounds and price
        simulateInput(pounds + "\n" + price + "\n");

        // Call the main method of SeafoodMarket
        SeafoodMarket.main(new String[] {});

        // Verify the output
        String expectedOutput = "Enter pounds of fish and price per pound: " +
                pounds + " lbs at $" + price + " per lb = $" + expectedCost + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
