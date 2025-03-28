import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PrintNewlineTest {

    @Test
    @DisplayName("PrintNewline.main prints correct output")
    void main_prints_correct_output() {
        // Arrange
        String expectedOutput = "red \n"
                + "green blue \n"
                + "pink \n"
                + "yellow\n";
        // Act: Call the main method of the PrintNewline class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("PrintNewline");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "PrintNewline.main fails to print expected output.");
    }

}