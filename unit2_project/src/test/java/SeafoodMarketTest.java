import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class SeafoodMarketTest {

    @Test
    @DisplayName("SeafoodMarket.main prints correct output for input: 5 8.99")
    public void mainInput_5_8dot99() throws Exception {
        String input = "5 8.99";
        String expectedOutput = "Enter pounds of fish and price per pound: "
                + "5.0 lbs at $8.99 per lb = $44.95\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("SeafoodMarket", input);
        // Assert
        assertEquals(expectedOutput, actualOutput, "SeafoodMarket.main fails for input: 5 8.99");
    }

    @Test
    @DisplayName("SeafoodMarket.main prints correct output for input: 3.25 15.99")
    public void mainInput_3dot25_15dot99() throws Exception {
        String input = "3.25 15.99";
        String expectedOutput = "Enter pounds of fish and price per pound: "
                + "3.25 lbs at $15.99 per lb = $51.97\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("SeafoodMarket", input);
        // Assert
        assertEquals(expectedOutput, actualOutput, "SeafoodMarket.main fails for input: 3.25 15.99");
    }
}
