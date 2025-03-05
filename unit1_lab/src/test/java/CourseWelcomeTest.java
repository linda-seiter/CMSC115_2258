import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseWelcomeTest {

    @Test
    @DisplayName("CourseWelcome.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Welcome to CMSC 115.\n" +
                "Let's learn Java!\n";
        // Act: Call the main method of the CourseWelcome class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("CourseWelcome");
        //Assert
        assertEquals(expectedOutput, actualOutput,
                "CourseWelcome.main fails to print expected output.");
    }

}