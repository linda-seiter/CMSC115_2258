import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    @DisplayName("Test: Main method output for reorder summary")
    public void testMainMethodOutput() {
        // Arrange
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String expectedOutput = "Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered\n"
                + "Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered\n"
                + "Rations - Quantity On Hand: 40, Reorder Threshold: 50 - needs to be reordered\n"
                + "Water - Quantity On Hand: 300, Reorder Threshold: 100 - does not need to be reordered\n";

        // Redirecting System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        InventoryAnalyzer.main(new String[0]); // Call the main method

        // Assert
        assertEquals(expectedOutput, outContent.toString()); // Verify if the output is as expected
    }
}
