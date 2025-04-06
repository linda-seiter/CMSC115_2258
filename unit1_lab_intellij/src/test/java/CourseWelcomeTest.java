import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CourseWelcomeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        // Reset System.out to its original stream
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test: CourseWelcome output")
    public void testCourseWelcomeOutput() {
        // Call the main method of CourseWelcome
        CourseWelcome.main(new String[] {});

        // Verify the output
        String expectedOutput = "Welcome to CMSC 115.\nLet's learn Java!\n";
        assertEquals(expectedOutput, outContent.toString(), "CourseWelcome fails to print correct output");
    }
}
