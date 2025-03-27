import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VariablesTest  {

    @Test
    @DisplayName("Variables.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Hello Silas\n" +
                "You are 28 years old.\n" +
                "Your gpa is 3.8\n";
        // Act: Call the main method of the Variables class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("Variables");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Variables.main fails to print expected output.");
    }

}