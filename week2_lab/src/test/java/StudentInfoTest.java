import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class StudentInfoTest {

    @Test
    @DisplayName("StudentInfo.main prints correct output")
    public void mainIOTest() throws Exception {
        String expectedOutput = "Age: 28 gpa: 3.8\n"
                + "Age: 29 gpa: 4.0\n";

        // Capture the output from StudentInfo.main
        String actualOutput = tapSystemOutNormalized(() -> {
            StudentInfo.main(new String[] {});
        });

        // Compare expected vs actual output
        assertEquals(expectedOutput, actualOutput);
    }

}
