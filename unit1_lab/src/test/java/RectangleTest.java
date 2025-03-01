import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest extends IOTest {

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 4.5 3.0")
    public void testRectangleWithInput1() throws Exception {
        // Arrange
        String input = "4.5 3.0";
        String expectedOutput = "Enter length and width: " +
                "length=4.5 width=3.0 area=13.5\n";
        // Act: Call the main method of the Rectangle class with the input and capture the output
        provideInput(input);
        Rectangle.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Rectangle.main fails for input: 4.5 3.0");
    }

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 10.25 2.5")
    public void testRectangleWithInput2() throws Exception {
        // Arrange
        String input = "10.25 2.5";
        String expectedOutput = "Enter length and width: " +
                "length=10.25 width=2.5 area=25.625\n";
        // Act: Call the main method of the Rectangle class with the input and capture the output
        provideInput(input);
        Rectangle.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Rectangle.main fails for input: 10.25 2.5");
    }
}
