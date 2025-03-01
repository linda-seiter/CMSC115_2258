import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaycheckTest extends IOTest {

    @Test
    @DisplayName("Paycheck.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Week#1 hours: 35 rate: $18.25 pay: $638.75\n"
                + "Week#2 hours: 39 rate: $18.25 pay: $711.75\n"
                + "Week#3 hours: 27 rate: $18.75 pay: $506.25\n";
        // Act: Call the main method of the Paycheck class and capture the output
        Paycheck.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Paycheck.main fails to print expected outout.");
    }

}
