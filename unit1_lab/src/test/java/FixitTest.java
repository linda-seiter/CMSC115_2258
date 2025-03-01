import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class FixitTest {

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
    @DisplayName("Fixit.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "ship\n"
                + "airplane\n"
                + "tank\n";
        // Act
        Fixit.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

}