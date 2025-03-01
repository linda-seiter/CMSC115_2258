import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FixitTest extends IOTest {

    @Test
    @DisplayName("Fixit.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "ship\n"
                + "airplane\n"
                + "tank\n";
        // Act: Call the main method of the Fixit class and capture the output
        Fixit.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Fixit.main fails to print expected outout.");
    }

}