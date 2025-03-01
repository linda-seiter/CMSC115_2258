import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VariablesTest extends IOTest {

    @Test
    @DisplayName("Variables.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Hello Silas\n" +
                "You are 28 years old.\n" +
                "Your gpa is 3.8\n";
        // Act: Call the main method of the Variables class and capture the output
        Variables.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Variables.main fails to print expected outout.");
    }

}