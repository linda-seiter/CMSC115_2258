import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentInfoTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture the output
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out and System.in
        System.setOut(originalSystemOut);
    }

    @Test
    @DisplayName("Test StudentInfo Output")
    void testStudentInfoSolution() {

        // Run the main method of StudentInfo
        StudentInfo.main(new String[] {});

        // Expected output after the program runs
        String expectedOutput = "Age: 28 gpa: 3.8\nAge: 29 gpa: 4.0";

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
