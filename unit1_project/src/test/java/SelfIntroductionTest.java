import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SelfIntroductionTest extends IOTest {

    @Test
    @DisplayName("SelfIntroduction.main prints at least 4 lines of output")
    void selfIntro4LinesOutput() throws Exception {
        // Act: Call the main method of the SelfIntroduction class and capture the output
        SelfIntroduction.main(new String[]{});
        String actualOutput = getOutput();
        String[] lines = actualOutput.split("\n"); //split at newline

        //Assert: At least 4 lines of output
        assertTrue(lines.length >= 4, "SelfIntroduction produces at least 4 lines of output");
    }

}