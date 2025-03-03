import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaFactsTest {

    @Test
    @DisplayName("JavaFacts.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Java was initially named Oak.\n"
                + "Java is an object-oriented language.\n";
        // Act: Call the main method of the JavaFacts class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("JavaFacts");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "JavaFacts.main fails to print expected outout.");
    }

}