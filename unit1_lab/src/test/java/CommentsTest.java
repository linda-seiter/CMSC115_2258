import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CommentsTest extends IOTest {

    @Test
    @DisplayName("Comments.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "apple\n"
                + "pear\n"
                + "watermelon\n";
        // Act: Call the main method of the Comments class and capture the output
        Comments.main(new String[]{});
        String actualOutput = getOutput();
        //Assert
        assertEquals(expectedOutput, actualOutput,
                "Comments.main fails to print expected outout.");
    }

}