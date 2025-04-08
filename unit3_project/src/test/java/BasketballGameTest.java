import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	@DisplayName("Test BasketballGame Output for Input (25, 20)")
	void testBasketballGameForInput25and20() {
		// Simulate user input: 25 (home team) and 20 (away team) for the 1st quarter
		String input = "25 20";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

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
	@DisplayName("Test BasketballGame Output for Input (30, 22)")
	void testBasketballGameForInput30and22() {
		// Simulate user input: 30 (home team) and 22 (away team) for the 1st quarter
		String input = "30 22";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

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

	// @Test
	// @DisplayName("BasketballGame.main ++ operator used once")
	// public void incrementOperator() {
	// String pattern = "\\+\\+";
	// int actualCount = JunitHelper.countOccurrences("BasketballGame", "main",
	// pattern);
	// assertEquals(1, actualCount);
	// }

	// @Test
	// @DisplayName("BasketballGame.main -- operator used once")
	// public void decrementOperator() {
	// String pattern = "\\-\\-";
	// int actualCount = JunitHelper.countOccurrences("BasketballGame", "main",
	// pattern);
	// assertEquals(1, actualCount);
	// }

	// @Test
	// @DisplayName("BasketballGame.main += operator used twice")
	// public void additionAssignmentOperator() {
	// String pattern = "\\+\\=";
	// int actualCount = JunitHelper.countOccurrences("BasketballGame", "main",
	// pattern);
	// assertEquals(2, actualCount);
	// }

	// @Test
	// @DisplayName("BasketballGame.main -= operator used once")
	// public void subtractionAssignmentOperator() {
	// String pattern = "\\-\\=";
	// int actualCount = JunitHelper.countOccurrences("BasketballGame", "main",
	// pattern);
	// assertEquals(1, actualCount);
	// }

	// @Test
	// @DisplayName("BasketballGame.main *= operator used once")
	// public void multiplicationAssignmentOperator() {
	// String pattern = "\\*\\=";
	// int actualCount = JunitHelper.countOccurrences("BasketballGame", "main",
	// pattern);
	// assertEquals(1, actualCount);
	// }

}
