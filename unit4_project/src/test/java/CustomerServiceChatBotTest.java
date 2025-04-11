import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceChatBotTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void provideInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testChatBotWithBye() {
        String input = String.join(System.lineSeparator(),
                "I have a problem with my order",
                "Tell me about shipping",
                "What is your return policy?",
                "Can I speak with your supervisor?",
                "bYe");

        provideInput(input);
        CustomerServiceChatBot.main(new String[0]);

        String expectedOutput = String.join(System.lineSeparator(),
                "Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.",
                "You: Customer Support: I'm sorry to hear that.",
                "You: Customer Support: Our standard shipping takes 5-7 business days.",
                "You: Customer Support: Returns are accepted within 30 days.",
                "You: Customer Support: Can you tell me more?",
                "You: Customer Support: Thanks for reaching out. Goodbye!",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n").replace("\r", "\n");
        String normalizedExpected = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpected, actualOutput);
    }

    @Test
    public void testChatBotWithExitAndGenericQuestions() {
        String input = String.join(System.lineSeparator(),
                "Hello?",
                "I have a question",
                "What are your hours?",
                "ExIt");

        provideInput(input);
        CustomerServiceChatBot.main(new String[0]);

        String expectedOutput = String.join(System.lineSeparator(),
                "Customer Support: Welcome! Type 'bye' or 'exit' to end the chat.",
                "You: Customer Support: Can you tell me more?",
                "You: Customer Support: Can you tell me more?",
                "You: Customer Support: Can you tell me more?",
                "You: Customer Support: Thanks for reaching out. Goodbye!",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n").replace("\r", "\n");
        String normalizedExpected = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpected, actualOutput);
    }

    @Test
    @DisplayName("Test: CustomerServiceChatBot has a while loop")
    void testDoWhileLoopPresence() throws IOException {
        Path path = Paths.get("src/main/java/CustomerServiceChatBot.java"); // Update the path if needed
        String code = new String(Files.readAllBytes(path));

        // Regular expression to match while loop in the main method
        String regex = "public\\s+static\\s+void\\s+main.*while";

        // Create a pattern and matcher to find the match in the code
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); // DOTALL allows matching across newlines
        Matcher matcher = pattern.matcher(code);

        // Assert that the regular expression finds at least one match
        assertTrue(matcher.find(), "While loop not found in main method.");

    }
}
