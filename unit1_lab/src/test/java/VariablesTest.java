import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VariablesTest {

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
    @DisplayName("Variables.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Hello Silas\n" +
                "You are 28 years old.\n" +
                "Your gpa is 3.8\n";

        // Act
        Variables.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();

        // Assert
        assertEquals(expectedOutput, actualOutput,
                "Variables.main fails to print expected outout.");
    }

}