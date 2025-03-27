import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class GasPurchaseTest {

    @Test
    @DisplayName("GasPurchase.main prints correct output for input: 12.5 3.50")
    public void gallons_12pt5_price_3pt5() throws Exception {

        String input = "12.5 3.50";
        String expectedOutput = "Enter gallons and price per gallon: " +
                "You owe $43.75\n";

        // Capture the output from GasPurchase.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                GasPurchase.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

    @Test
    @DisplayName("GasFillup.main prints correct output for input: 8.0 3.75")
    public void gallons_8_price_3pt75() throws Exception {

        String input = "8.0 3.75";
        String expectedOutput = "Enter gallons and price per gallon: " +
                "You owe $30.0\n";

        // Capture the output from GasFillup.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                GasPurchase.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

}
