import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransmissionRateTest {

    @Test
    @DisplayName("TransmissionRate.main prints correct output for input: 2")
    public void commonCold() {
        String input = "2";
        String expectedOutput = "Enter r0: "
                + "New cases on 4th iteration: 16\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("TransmissionRate", input);
        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("TransmissionRate.main prints correct output for input: 10")
    public void chickenPox() throws Exception {
        //Arrange
        String input = "10";
        String expectedOutput = "Enter r0: "
                + "New cases on 4th iteration: 10000\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("TransmissionRate", input);
        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("TransmissionRate.main prints correct output for input: 18")
    public void measles() throws Exception {
        //Arrange
        String input = "18";
        String expectedOutput = "Enter r0: "
                + "New cases on 4th iteration: 104976\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("TransmissionRate", input);
        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    // @Test
    // @DisplayName("TransmissionRate.main calls Math.pow")
    // public void powerFunctionCalled() {
    // String pattern = "Math[.]pow\\(.*?\\)";
    // int expectedCount = 1;
    // int actualCount = JunitHelper.countOccurrences("TransmissionRate", "main",
    // pattern);
    // assertEquals(expectedCount, actualCount);
    // }

    // @Test
    // @DisplayName("TransmissionRate.main int cast")
    // public void intCast() {
    // String pattern = "\\(int\\)";
    // int expectedCount = 1;
    // int actualCount = JunitHelper.countOccurrences("TransmissionRate", "main",
    // pattern);
    // assertEquals(expectedCount, actualCount);
    // }

}
