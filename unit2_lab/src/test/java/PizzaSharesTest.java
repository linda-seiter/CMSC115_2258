import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaSharesTest {

    @Test
    @DisplayName("PizzaShares.main prints correct output for input: 24 10")
    public void slices_24_people_10() throws Exception {
        // Arrange
        String input = "24 10";
        String expectedOutput = "Enter #slices and #people: "
                + "Each person gets 2 slices.\n"
                + "There are 4 slices remaining.\n";
        // Act: Call the main method of the PizzaShares class with the input and capture the output
        String actualOutput = JunitHelper.executeClassWithInput("PizzaShares", input);
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "PizzaShares.main fails for input: 24 10");
    }

    @Test
    @DisplayName("PizzaShares.main prints correct output for input: 12 4")
    public void slices_12_people_4() throws Exception {
        // Arrange
        String input = "12 4";
        String expectedOutput = "Enter #slices and #people: "
                + "Each person gets 3 slices.\n"
                + "There are 0 slices remaining.\n";
        // Act: Call the main method of the PizzaShares class with the input and capture the output
        String actualOutput = JunitHelper.executeClassWithInput("PizzaShares", input);
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "PizzaShares.main fails for input: 12 4");
    }

}
