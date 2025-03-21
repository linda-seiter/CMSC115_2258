import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

        @Test
        @DisplayName("YardPlanner.main prints correct output for input: 7 9")
        public void landscape_7_x_9() {
            // Arrange
            String input = "7 9";
            String expectedOutput = "Enter rows and columns: \uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n" +
                    "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n" +
                    "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                    "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                    "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                    "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n" +
                    "\uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n";
            // Act: Call the main method of the YardPlanner class with the input and capture the output
            String actualOutput = JunitHelper.executeClassWithInput("YardPlanner", input);
            // Assert
            assertEquals(expectedOutput, actualOutput,
                    "YardPlanner.main fails for input: 7 9");
        }


    @Test
    @DisplayName("YardPlanner.main prints correct output for input: 10 8")
    public void testLandscape_10_by_8()  {
        // Arrange
        String input = "10 8";
        String expectedOutput = "Enter rows and columns: \uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n" +
                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDFE0\uD83C\uDFE0\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\n" +
                "\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83D\uDC3F\uFE0F\n" +
                "\uD83C\uDF33\uD83D\uDC3F\uFE0F\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83D\uDC3F\uFE0F\uD83C\uDF33\n";
        // Act: Call the main method of the YardPlanner class with the input and capture the output
        String actualOutput = JunitHelper.executeClassWithInput("YardPlanner", input);
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "YardPlanner.main fails for input: 10 8");
    }
}
