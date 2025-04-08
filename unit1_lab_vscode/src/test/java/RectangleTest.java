import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;
        private final InputStream originalIn = System.in;

        @BeforeEach
        public void setUp() {
                // Redirect System.out to capture the output
                System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void tearDown() {
                // Reset System.out to its original stream
                System.setOut(originalOut);

                // Reset System.in to its original stream
                System.setIn(originalIn);
        }

        private void simulateInput(String input) {
                // Simulate user input
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);
        }

        @Test
        @DisplayName("Test: Calculate area for length 7 and width 3")
        public void testCalculateArea_7_3() {
                // Simulate user input for length=7 and width=3
                simulateInput("7 3");

                // Call the main method of Rectangle
                Rectangle.main(new String[] {});

                // Verify the output (Area = 7 * 3 = 21.0)
                String expectedOutput = "Enter length and width: " +
                                "length=7.0 width=3.0 area=21.0\n";
                assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("Test: Calculate area for length 8 and width 4.5")
        public void testCalculateArea_8_4_5() {
                // Simulate user input for length=8 and width=4.5
                simulateInput("8 4.5");

                // Call the main method of Rectangle
                Rectangle.main(new String[] {});

                // Verify the output (Area = 8 * 4.5 = 36.0)
                String expectedOutput = "Enter length and width: " +
                                "length=8.0 width=4.5 area=36.0\n";
                assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("Test: Calculate area for length 0 and width 0")
        public void testCalculateArea_0_0() {
                // Simulate user input for length=0 and width=0
                simulateInput("0 0 ");

                // Call the main method of Rectangle
                Rectangle.main(new String[] {});

                // Verify the output (Area = 0 * 0 = 0.0)
                String expectedOutput = "Enter length and width: " +
                                "length=0.0 width=0.0 area=0.0\n";
                assertEquals(expectedOutput, outContent.toString());
        }
}
