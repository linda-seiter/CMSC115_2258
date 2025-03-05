import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NearestIntTest {

    @Test
    @DisplayName("NearestInt.main prints correct output for input: 19 4")
    public void mainInput_19_4()  {
        //Arrange
        String input = "19 4";
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 19/4\n"
                + "Double Value: 4.75\n"
                + "Cast as Int: 4\n"
                + "Rounded to nearest int: 5\n"
                + "Negative Value: -4.75\n"
                + "Negative Value rounded to nearest int: -5\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("NearestInt", input);
        // Assert
        assertEquals(expectedOutput, actualOutput, "NearestInt.main fails for input: 19 4");
    }

    @Test
    @DisplayName("NearestInt.main prints correct output for input: 11 8")
    public void mainInput_11_8()  {
        //Arrange
        String input = "11 8";
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 11/8\n"
                + "Double Value: 1.375\n"
                + "Cast as Int: 1\n"
                + "Rounded to nearest int: 1\n"
                + "Negative Value: -1.375\n"
                + "Negative Value rounded to nearest int: -1\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("NearestInt", input);
        // Assert
        assertEquals(expectedOutput, actualOutput, "NearestInt.main fails for input: 11 8");
    }

    @Test
    @DisplayName("NearestInt.main prints correct output for input: 7 10")
    public void mainInput_7_10()  {
        String input = "7 10";
        String expectedOutput = "Enter numerator and denominator: "
                + "Fraction: 7/10\n"
                + "Double Value: 0.7\n"
                + "Cast as Int: 0\n"
                + "Rounded to nearest int: 1\n"
                + "Negative Value: -0.7\n"
                + "Negative Value rounded to nearest int: -1\n";
        //Act
        String actualOutput = JunitHelper.executeClassWithInput("NearestInt", input);
        // Assert
        assertEquals(expectedOutput, actualOutput, "NearestInt.main fails for input: 7 10");
    }

}
