import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseWelcomeTest {

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
    @DisplayName("CourseWelcome.main prints correct output")
    void main_prints_correct_output() {
        //Arrange
        String expectedOutput = "Welcome to CMSC 115.\n" +
                "Let's learn Java!\n";
        // Act
        CourseWelcome.main(new String[]{});
        String actualOutput = outputStreamCaptor.toString();
        //Assert
        assertEquals(expectedOutput, actualOutput,
                "CourseWelcome.main fails to print expected outout.");
    }

}