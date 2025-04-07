import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundingTest {

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
		// Restore the original System.out
		System.setOut(originalSystemOut);
	}

	@Test
	@DisplayName("Test Rounding Output for Input 1.9247")
	void testRoundingForInput1pt9247() {
		// Simulate user input: 1.9247
		ByteArrayInputStream inputStream = new ByteArrayInputStream("1.9247".getBytes());
		System.setIn(inputStream);

		// Run the main method of Rounding
		Rounding.main(new String[] {});

		// Expected output after the program runs for input 1.9247
		String expectedOutput = "Enter number: Cast as int: 1\n" +
				"\n" +
				"Round to nearest int\n" +
				"Original: \t1.9247\n" +
				"Add 0.5:\t2.4247\n" +
				"Cast as int:\t2\n" +
				"\n" +
				"Truncate to 3 digits after the decimal point\n" +
				"Original:\t\t1.9247\n" +
				"Move . 3 digits right:\t1924.7\n" +
				"Cast as int:\t\t1924\n" +
				"Move . 3 digits left:\t1.924\n" +
				"\n" +
				"Round to 3 digits after the decimal point\n" +
				"Original:\t\t1.9247\n" +
				"Move . 3 digits right:\t1924.7\n" +
				"Add 0.5:\t\t1925.2\n" +
				"Cast as int:\t\t1925\n" +
				"Move . 3 digits left:\t1.925\n";

		// Check if the captured output matches the expected output
		assertEquals(expectedOutput, outputStream.toString());
	}

	@Test
	@DisplayName("Test Rounding Output for Input 3.2984")
	void testRoundingForInput3pt2984() {
		// Simulate user input: 3.2984
		ByteArrayInputStream inputStream = new ByteArrayInputStream("3.2984".getBytes());
		System.setIn(inputStream);

		// Run the main method of Rounding
		Rounding.main(new String[] {});

		// Expected output after the program runs for input 3.2984
		String expectedOutput = "Enter number: " +
				"Cast as int: 3\n" +
				"\n" +
				"Round to nearest int\n" +
				"Original: \t3.2984\n" +
				"Add 0.5:\t3.7984\n" +
				"Cast as int:\t3\n" +
				"\n" +
				"Truncate to 3 digits after the decimal point\n" +
				"Original:\t\t3.2984\n" +
				"Move . 3 digits right:\t3298.4\n" +
				"Cast as int:\t\t3298\n" +
				"Move . 3 digits left:\t3.298\n" +
				"\n" +
				"Round to 3 digits after the decimal point\n" +
				"Original:\t\t3.2984\n" +
				"Move . 3 digits right:\t3298.4\n" +
				"Add 0.5:\t\t3298.9\n" +
				"Cast as int:\t\t3298\n" +
				"Move . 3 digits left:\t3.298\n";

		// Check if the captured output matches the expected output
		assertEquals(expectedOutput, outputStream.toString());
	}
}
