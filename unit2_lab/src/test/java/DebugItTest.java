import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DebugItTest {

    @Test
    @DisplayName("DebugIt.main prints correct output")
    public void mainIOTest() throws Exception {
        // Arrange
        String expectedOutput = "Planes on runway = 4\n";
        // Act: Call the main method of the DebugIt class  and capture the output
        String actualOutput = JunitHelper.captureClassOutput("DebugIt");
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "DebugIt.main fails to produce expected output.");
    }

}
