import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RoundingTest {

	@Test
	@DisplayName("Rounding.main prints correct output for input: 1.9247")
	public void mainIOTest1() throws Exception {
		String input = "1.9247";
		String expectedOutput = "Enter number: "
				+ "Cast as int: 1\n"
				+ "\n"
				+ "Round to nearest int\n"
				+ "Original: 	1.9247\n"
				+ "Add 0.5:	2.4247\n"
				+ "Cast as int:	2\n"
				+ "\n"
				+ "Truncate to 3 digits after the decimal point\n"
				+ "Original:		1.9247\n"
				+ "Move . 3 digits right:	1924.7\n"
				+ "Cast as int:		1924\n"
				+ "Move . 3 digits left:	1.924\n"
				+ "\n"
				+ "Round to 3 digits after the decimal point\n"
				+ "Original:		1.9247\n"
				+ "Move . 3 digits right:	1924.7\n"
				+ "Add 0.5:		1925.2\n"
				+ "Cast as int:		1925\n"
				+ "Move . 3 digits left:	1.925\n";
		// Act: Call the main method of the Rounding class with the input and capture the output
		String actualOutput = JunitHelper.executeClassWithInput("Rounding", input);
		// Assert
		assertEquals(expectedOutput, actualOutput,
				"Rounding.main fails for input: " + input);
	}

	public void mainIOTest2() throws Exception {
		String input = "3.2984";
		String expectedOutput = "Enter number: "
				+ "Cast as int: 3\n"
				+ "\n"
				+ "Round to nearest int\n"
				+ "Original: 	3.2984\n"
				+ "Add 0.5:	3.7984\n"
				+ "Cast as int:	3\n"
				+ "\n"
				+ "Truncate to 3 digits after the decimal point\n"
				+ "Original:		3.2984\n"
				+ "Move . 3 digits right:	3298.4\n"
				+ "Cast as int:		3298\n"
				+ "Move . 3 digits left:	3.298\n"
				+ "\n"
				+ "Round to 3 digits after the decimal point\n"
				+ "Original:		3.2984\n"
				+ "Move . 3 digits right:	3298.4\n"
				+ "Add 0.5:		3298.9\n"
				+ "Cast as int:		3298\n"
				+ "Move . 3 digits left:	3.298\n";
		// Act: Call the main method of the Rounding class with the input and capture the output
		String actualOutput = JunitHelper.executeClassWithInput("Rounding", input);
		// Assert
		assertEquals(expectedOutput, actualOutput,
				"Rounding.main fails for input: " + input);

	}

}
