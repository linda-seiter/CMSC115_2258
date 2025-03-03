import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentInfoTest {

    @Test
    @DisplayName("StudentInfo.main prints correct output")
    public void mainIOTest() throws Exception {
        // Arrange
        String expectedOutput = "Age: 28 gpa: 3.8\n"
                + "Age: 29 gpa: 4.0\n";
        // Act: Call the main method of the StudentInfo class with the input and capture the output
        String actualOutput = JunitHelper.captureClassOutput("StudentInfo");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "StudentInfo.main fails to produce expected output.");
    }

}
