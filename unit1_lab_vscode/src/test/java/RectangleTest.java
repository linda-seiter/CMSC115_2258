import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class RectangleTest {

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 4.5 3.0")
    public void length_4pt5_width_3() throws Exception {

        String input = "4.5 3.0";
        String expectedOutput = "Enter length and width: " +
                "length=4.5 width=3.0 area=13.5\n";

        // Capture the output from Rectangle.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                Rectangle.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 10.25 2.5")
    public void length_10pt25_width_2pt5() throws Exception {

        String input = "10.25 2.5";
        String expectedOutput = "Enter length and width: " +
                "length=10.25 width=2.5 area=25.625\n";

        // Capture the output from Rectangle.main using the provided input.
        withTextFromSystemIn(input).execute(() -> {
            String actualOutput = tapSystemOutNormalized(() -> {
                Rectangle.main(new String[] {});
            });

            // Compare expected vs actual output
            assertEquals(expectedOutput, actualOutput);
        });
    }

}
