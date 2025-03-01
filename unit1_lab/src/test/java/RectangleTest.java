import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Utility to provide simulated input
    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture the output
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn); // Restore standard input
        System.setOut(standardOut); // Restore standard output
    }

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 4.5 3.0")
    public void testRectangleWithInput1() throws Exception {
        // Arrange
        String input = "4.5 3.0";
        String expectedOutput = "Enter length and width: " +
                "length=4.5 width=3.0 area=13.5\n";

        // Simulate the user input
        provideInput(input);

        // Act: Call the main method of the Rectangle class
        Rectangle.main(new String[]{});

        // Assert: Check the captured output
        String actualOutput = outputStreamCaptor.toString();
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

        // Simulate the user input
        provideInput(input);

        // Act: Call the main method of the Rectangle class
        Rectangle.main(new String[]{});

        // Assert: Check the captured output
        String actualOutput = outputStreamCaptor.toString();
        assertEquals(expectedOutput, actualOutput,
                "Rectangle.main fails for input: 10.25 2.5");
    }
}
