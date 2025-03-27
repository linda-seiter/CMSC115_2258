import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BillSplitterTest  {

    @Test
    @DisplayName("BillSplitter.main prints correct output")
    void billSplitterOutput() throws Exception {
        //Arrange
        String expectedOutput = "Each person owes: 56.52\n";
        // Act: Call the main method of the BillSplitter class and capture the output
        String actualOutput = JunitHelper.captureClassOutput("BillSplitter");
        //Assert
        assertEquals(expectedOutput, actualOutput,
                "BillSplitter.main fails to print expected output.");
    }
}