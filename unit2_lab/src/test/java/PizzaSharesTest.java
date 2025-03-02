import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class PizzaSharesTest {

    @Test
    @DisplayName("PizzaShares.main prints correct output for input: 24 10")
    public void slices_24_people_10() throws Exception {

        String input = "24 10";
        String expectedOutput = "Enter #slices and #people: "
                + "Each person gets 2 slices.\n"
                + "There are 4 slices remaining.\n";

        // Capture the output from PizzaShares.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                PizzaShares.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

    @Test
    @DisplayName("PizzaShares.main prints correct output for input: 12 4")
    public void slices_12_people_4() throws Exception {
        String input = "12 4";
        String expectedOutput = "Enter #slices and #people: "
                + "Each person gets 3 slices.\n"
                + "There are 0 slices remaining.\n";

        // Capture the output from PizzaShares.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                PizzaShares.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

}
