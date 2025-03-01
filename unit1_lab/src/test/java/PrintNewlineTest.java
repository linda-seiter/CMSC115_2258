import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PrintNewlineTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("PrintNewline.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "red \n"
                + "green blue \n"
                + "pink \n"
                + "yellow\n";

        // Act
        PrintNewline.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        // Assert
        assertEquals(expectedOutput, actualOutput,
                "PrintNewline.main fails to print expected outout.");
    }

}