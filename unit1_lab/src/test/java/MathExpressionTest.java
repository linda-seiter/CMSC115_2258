import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MathExpressionTest  {

    @Test
    @DisplayName("MathExpression.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "(2 + 3) * 8 = 40\n";
        // Act: Call the main method of the MathExpression class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("MathExpression");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "MathExpression.main fails to print expected outout.");
    }

}