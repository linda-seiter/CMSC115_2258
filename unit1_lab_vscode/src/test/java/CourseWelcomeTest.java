import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class CourseWelcomeTest {

    @Test
    @DisplayName("CourseWelcome.main prints correct output")
    void courseWelcomeOutput() throws Exception {
        String expectedOutput = "Welcome to CMCS 115 - Introductory Programming.\n" +
                "Let's learn Java!\n";
        // Capture the output from CourseWelcome.main
        String actualOutput = tapSystemOutNormalized(() -> {
            CourseWelcome.main(new String[] {});
        });
        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}