import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

class CommentsTest {

    @Test
    @DisplayName("Comments.main prints correct output")
    void commentsOutput() throws Exception {
        String expectedOutput = "apple\n"
                + "pear\n"
                + "watermelon\n";
        // Capture the output from Comments.main
        String actualOutput = tapSystemOutNormalized(() -> {
            Comments.main(new String[] {});
        });
        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}