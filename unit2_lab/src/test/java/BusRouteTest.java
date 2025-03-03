import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BusRouteTest {

    @Test
    @DisplayName("BusRoute.main prints correct output")
    public void mainIOTest() throws Exception {
        // Arrange
        String expectedOutput = "Bus begins its route\n"
                + "8 passengers get on at stop#1\n"
                + "Departing stop#1 with 8 passengers\n"
                + "2 passengers get off at stop#2\n"
                + "Departing stop#2 with 6 passengers\n"
                + "Half the passengers get off at stop#3\n"
                + "Departing stop#3 with 3 passengers\n"
                + "The number of passengers triples at stop#4\n"
                + "Departing stop#4 with 9 passengers\n";
        // Act: Call the main method of the BusRoute class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("BusRoute");

        // Assert
        assertEquals(expectedOutput, actualOutput,
                "BusRoute.main fails to produce correct output");
    }

//    @Test
//    @DisplayName("BusRoute.main uses /= once")
//    public void mainDivOpTest() {
//        // Arrange
//        String pattern = "passengers\s*/=\s*2";
//        int expectedCount = 1;
//        // Act
//        int actualCount = JunitHelper.countOccurrences("BusRoute", "main", pattern);
//        // Assert
//        assertEquals(expectedCount, actualCount, "main uses /= once");
//    }
//
//    @Test
//    @DisplayName("BusRoute.main uses *= once")
//    public void mainMultOpTest() {
//        // Arrange
//        String pattern = "passengers\s*\\*=\s*3";
//        int expectedCount = 1;
//        // Act
//        int actualCount = JunitHelper.countOccurrences("BusRoute", "main", pattern);
//        // Assert
//        assertEquals(expectedCount, actualCount, "main uses *= once");
//    }

}
