import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GasPurchaseTest extends IOTest {

    @Test
    @DisplayName("GasPurchase.main prints correct output for input: 12.5 3.50")
    public void gallons_12pt5_price_3pt5() {
        String input = "12.5 3.50";
        String expectedOutput = "Enter gallons and price per gallon: " +
                "You owe $43.75\n";
        // Act: Call the main method of the GasPurchase class with the input and capture the output
        provideInput(input);
        GasPurchase.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "GasPurchase.main fails for input: 12.5 3.50");
    }

    @Test
    @DisplayName("GasFillup.main prints correct output for input: 8.0 3.75")
    public void gallons_8_price_3pt75()  {
        //Arrange
        String input = "8.0 3.75";
        String expectedOutput = "Enter gallons and price per gallon: " +
                "You owe $30.0\n";
        // Act: Call the main method of the GasPurchase class with the input and capture the output
        provideInput(input);
        GasPurchase.main(new String[]{});
        String actualOutput = getOutput();
        // Assert
        assertEquals(expectedOutput, actualOutput,
                "GasPurchase.main fails for input: 8.0 3.75");
    }

}
