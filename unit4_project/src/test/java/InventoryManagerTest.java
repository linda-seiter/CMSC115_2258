import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryManagerTest {

    private ByteArrayOutputStream testOut;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // 🔧 Helper method to simulate user input
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testInventoryManagerInsufficientAndLowStock() {
        setInput("100 20 30 25 30 10 10 5");

        InventoryManager.main(new String[] {});

        String expectedOutput = String.join("\n",
                "Enter initial inventory and low stock threshold: ",
                "Enter order quantity: Order filled. Remaining inventory: 70",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 45",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 15",
                "Low stock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 5",
                "Low stock.",
                "",
                "Enter order quantity: Insufficient inventory. Only 5 items left.",
                "Low stock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 0",
                "Low stock.",
                "",
                "Inventory empty.",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInventoryManagerExactDepletionNoOverOrder() {
        setInput("50 10 15 10 10 5 10");

        InventoryManager.main(new String[] {});

        String expectedOutput = String.join("\n",
                "Enter initial inventory and low stock threshold: ",
                "Enter order quantity: Order filled. Remaining inventory: 35",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 25",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 15",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 10",
                "Low stock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 0",
                "Low stock.",
                "",
                "Inventory empty.",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test: InventoryManager has a do-while loop")
    void testDoWhileLoopPresence() throws IOException {
        Path path = Paths.get("src/main/java/InventoryManager.java"); // Update the path if needed
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match do-while loop in the main method
        String regex = "public\\s+static\\s+void\\s+main.*do.*while";

        // Create a pattern and matcher to find the match in the code
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); // DOTALL allows matching across newlines
        Matcher matcher = pattern.matcher(code);

        // Assert that the regular expression finds at least one match
        assertTrue(matcher.find(), "Do-While loop not found in main method.");

    }
}
