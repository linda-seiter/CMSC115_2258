
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class Task5Test {

    @Test
    @DisplayName("PaintCalculator.main prints correct output for input: 12.0 15.0 10.0")
    public void mainIOTest1() throws Exception {

        String input = "12.0 15.0 10.0";
        String expectedOutput = "Enter length, width and height: " +
                "Buy 3 gallons of paint.\n";

        // Capture the output from PaintCalculator.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                PaintCalculator.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

    @Test
    @DisplayName("PaintCalculator.main prints correct output for input: 7.5 11.5 8.25")
    public void mainIOTest2() throws Exception {

        String input = "7.5 11.5 8.25";
        String expectedOutput = "Enter length, width and height: " +
                "Buy 2 gallons of paint.\n";

        // Capture the output from PaintCalculator.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                PaintCalculator.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

}
