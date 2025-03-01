import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class PaycheckTest {

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
    @DisplayName("Paycheck.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Week#1 hours: 35 rate: $18.25 pay: $638.75\n"
                + "Week#2 hours: 39 rate: $18.25 pay: $711.75\n"
                + "Week#3 hours: 27 rate: $18.75 pay: $506.25\n";

        // Act
        Paycheck.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Paycheck.main fails to print expected outout.");
    }

}
