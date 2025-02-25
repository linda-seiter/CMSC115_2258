import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class MathExpressionTest {

    @Test
    @DisplayName("MathExpression.main prints correct output")
    void mathExpressionOutput() throws Exception {
        // Define the expected output
        String expectedOutput = "(2 + 3) * 8 = 40\n";

        // Capture the actual output from MathExpression.main
        String actualOutput = tapSystemOutNormalized(() -> {
            MathExpression.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}