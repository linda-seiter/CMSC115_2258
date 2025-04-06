import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CommentsTest {

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
    @DisplayName("Test: Comments class output")
    public void testCommentsOutput() {
        // Call the main method of Comments class
        Comments.main(new String[] {});

        // Verify the output
        String expectedOutput = "apple\npear\nwatermelon\n";
        assertEquals(expectedOutput, outContent.toString(), "Comment class fails to print correct output");
    }
}
