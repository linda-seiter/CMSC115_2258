import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagerTest {

    private ByteArrayOutputStream testOut;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // 🔧 Helper method to simulate user input
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testInventoryManagerScenario1() {
        setInput("100 20 30 25 30 10 10 5");

        InventoryManager.main(new String[] {});

        String expectedOutput = String.join("\n",
                "Enter initial inventory and low stock threshold: ",
                "Enter order quantity: Order filled. Remaining inventory: 70",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 45",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 15",
                "Low stock. Time to restock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 5",
                "Low stock. Time to restock.",
                "",
                "Enter order quantity: Insufficient inventory. Only 5 items left.",
                "Low stock. Time to restock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 0",
                "Low stock. Time to restock.",
                "",
                "Inventory empty.",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInventoryManagerExactDepletionNoOverOrder() {
        setInput("50 10 15 10 10 5 10");

        InventoryManager.main(new String[] {});

        String expectedOutput = String.join("\n",
                "Enter initial inventory and low stock threshold: ",
                "Enter order quantity: Order filled. Remaining inventory: 35",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 25",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 15",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 10",
                "Low stock. Time to restock.",
                "",
                "Enter order quantity: Order filled. Remaining inventory: 0",
                "Low stock. Time to restock.",
                "",
                "Inventory empty.",
                "");

        String actualOutput = testOut.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
