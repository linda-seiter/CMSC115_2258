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

    private static void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 4.5 3.0")
    public void length_4pt5_width_3() throws Exception {
        //Arrange
        String input = "4.5 3.0";
        String expectedOutput = "Enter length and width: \n" +
                "length=4.5 width=3.0 area=13.5\n";

        //Act
        provideInput(input);
        Rectangle.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Rectangle.main prints correct output for input: 10.25 2.5")
    public void length_10pt25_width_2pt5() throws Exception {
        //Arrange
        String input = "10.25 2.5";
        String expectedOutput = "Enter length and width: \n" +
                "length=10.25 width=2.5 area=25.625\n";

        //Act
        provideInput(input);
        Rectangle.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

}
