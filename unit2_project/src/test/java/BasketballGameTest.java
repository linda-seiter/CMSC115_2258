import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketballGameTest {

	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private final PrintStream printStream = new PrintStream(outputStream);
	private final PrintStream originalSystemOut = System.out;
	private final InputStream originalSystemIn = System.in;

	@BeforeEach
	void setUp() {
		// Redirect System.out to capture the output
		System.setOut(printStream);
	}

	@AfterEach
	void tearDown() {
		// Restore the original System.out and System.in
		System.setOut(originalSystemOut);
		System.setIn(originalSystemIn);
	}

	private void simulateUserInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}

	@Test
	@DisplayName("Test BasketballGame Output for Input :25 20")
	void testBasketballGameForInput25and20() {
		// Simulate user input: 25 (home team) and 20 (away team) for the 1st quarter
		simulateUserInput("25 20");

		// Run the main method of BasketballGame
		BasketballGame.main(new String[] {});

		// Expected output after the program runs for input 25 and 20
		String expectedOutput = "Home and away points for 1st quarter: 1st quarter scores: home 25 away 20\n" +
				"2nd quarter scores: home 50 away 50\n" +
				"After challenge: home 47 away 50\n" +
				"3rd quarter scores: home 57 away 62\n" +
				"After challenge: home 58 away 62\n" +
				"4th quarter scores: home 82 away 81\n";

		// Check if the captured output matches the expected output
		assertEquals(expectedOutput, outputStream.toString());
	}

	@Test
	@DisplayName("Test BasketballGame Output for Input : 30 22")
	void testBasketballGameForInput30and22() {
		// Simulate user input: 30 (home team) and 22 (away team) for the 1st quarter
		simulateUserInput("30 22");

		// Run the main method of BasketballGame
		BasketballGame.main(new String[] {});

		// Expected output after the program runs for input 30 and 22
		String expectedOutput = "Home and away points for 1st quarter: 1st quarter scores: home 30 away 22\n" +
				"2nd quarter scores: home 60 away 60\n" +
				"After challenge: home 57 away 60\n" +
				"3rd quarter scores: home 67 away 72\n" +
				"After challenge: home 68 away 72\n" +
				"4th quarter scores: home 97 away 96\n";

		// Check if the captured output matches the expected output
		assertEquals(expectedOutput, outputStream.toString());
	}

	@Test
	@DisplayName("BasketballGame.main uses multiplication assignment operator")
	public void multiplicationAssignmentOperatorTest() throws IOException {
		// Load the source code of BasketballGame
		Path path = Paths.get("src/main/java/BasketballGame.java"); // Adjust path if needed
		String code = new String(Files.readAllBytes(path));

		// Assert that the code contains *=
		assertTrue(code.contains("*="), "BasketballGame must use *= operator.");
	}

	@Test
	@DisplayName("BasketballGame.main uses increment operator")
	public void incrementOperatorTest() throws IOException {
		// Load the source code of BasketballGame
		Path path = Paths.get("src/main/java/BasketballGame.java"); // Adjust path if needed
		String code = new String(Files.readAllBytes(path));

		// Assert that the code contains "++"
		assertTrue(code.contains("++"), "BasketballGame must use ++ operator.");
	}

	@Test
	@DisplayName("BasketballGame.main uses decrement operator")
	public void decrementOperatorTest() throws IOException {
		// Load the source code of BasketballGame
		Path path = Paths.get("src/main/java/BasketballGame.java"); // Adjust path if needed
		String code = new String(Files.readAllBytes(path));

		// Assert that the code contains "--"
		assertTrue(code.contains("--"), "BasketballGame must use -- operator.");
	}

	@Test
	@DisplayName("BasketballGame.main uses addition assignment operator")
	public void additionAssignmentOperatorTest() throws IOException {
		// Load the source code of BasketballGame
		Path path = Paths.get("src/main/java/BasketballGame.java"); // Adjust path if needed
		String code = new String(Files.readAllBytes(path));

		// Assert that the code contains +=
		assertTrue(code.contains("+="), "BasketballGame must use += operator.");
	}

	@Test
	@DisplayName("BasketballGame.main uses subtraction assignment operator")
	public void subtractionAssignmentOperatorTest() throws IOException {
		// Load the source code of BasketballGame
		Path path = Paths.get("src/main/java/BasketballGame.java"); // Adjust path if needed
		String code = new String(Files.readAllBytes(path));

		// Assert that the code contains -=
		assertTrue(code.contains("-="), "BasketballGame must use -= operator.");
	}

}
