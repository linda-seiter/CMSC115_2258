import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BillSplitterTest extends IOTest {

    @Test
    @DisplayName("BillSplitter.main prints correct output")
    void billSplitterOutput() throws Exception {
        //Arrange
        String expectedOutput = "Each person owes: 56.52\n";
        // Act: Call the main method of the BillSplitter class and capture the output
        BillSplitter.main(new String[]{});
        String actualOutput = getOutput();
        //Assert
        assertEquals(expectedOutput, actualOutput,
                "BillSplitter.main fails to print expected outout.");
    }
}