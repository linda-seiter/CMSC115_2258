import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

        private ByteArrayOutputStream outputStream;
        private PrintStream printStream;

        @BeforeEach
        public void setUp() {
                // Set up the streams before each test
                outputStream = new ByteArrayOutputStream();
                printStream = new PrintStream(outputStream);
                System.setOut(printStream);
        }

        @AfterEach
        public void tearDown() {
                // Restore original System.out after each test
                System.setOut(System.out);
                System.setIn(System.in);
        }

        @Test
        @DisplayName("YardPlanner.main prints correct output for input: 7 9")
        public void landscape_7_x_9() {
                // Arrange
                String input = "7 9";
                String expectedOutput = "Enter rows and columns: \uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n"
                                +
                                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n"
                                +
                                "\uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n";

                // Simulate user input
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                // Act: Call the main method of YardPlanner
                YardPlanner.main(new String[] {});

                // Assert: Compare expected and actual outputs
                String actualOutput = outputStream.toString().trim(); // Removing leading/trailing spaces
                assertEquals(expectedOutput.trim(), actualOutput, "YardPlanner.main fails for input: 7 9");
        }

        @Test
        @DisplayName("YardPlanner.main prints correct output for input: 10 8")
        public void testLandscape_10_by_8() {
                // Arrange
                String input = "10 8";
                String expectedOutput = "Enter rows and columns: \uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n"
                                +
                                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n"
                                +
                                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n"
                                +
                                "\uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n";

                // Simulate user input
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                // Act: Call the main method of YardPlanner
                YardPlanner.main(new String[] {});

                // Assert: Compare expected and actual outputs
                String actualOutput = outputStream.toString().trim(); // Removing leading/trailing spaces
                assertEquals(expectedOutput.trim(), actualOutput, "YardPlanner.main fails for input: 10 8");
        }
}
