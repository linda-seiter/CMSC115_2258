import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetItemReorderSummaryTest {

    // Test 1: Valid case where the item needs to be reordered
    @Test
    @DisplayName("getItemReorderSummary: Item needs to be reordered")
    public void testGetItemReorderSummary_NeedsReordering() {
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String itemName = "Medical Kit";

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);
        String expected = "Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered";

        assertEquals(expected, result);
    }

    // Test 2: Valid case where the item does not need to be reordered
    @Test
    @DisplayName("getItemReorderSummary: Item does not need to be reordered")
    public void testGetItemReorderSummary_DoesNotNeedReordering() {
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String itemName = "Tactical Equipment";

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);
        String expected = "Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered";

        assertEquals(expected, result);
    }

    // Test 3: Item not found in inventory
    @Test
    @DisplayName("getItemReorderSummary: Item not found in inventory")
    public void testGetItemReorderSummary_ItemNotFound() {
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String itemName = "Nonexistent Item";

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);

        assertNull(result);  // Should return null since the item is not found
    }

    // Test 4: Invalid inventory data format (no colon for quantity or threshold)
    @Test
    @DisplayName("getItemReorderSummary: Invalid format in inventory data (missing reorder threshold)")
    public void testGetItemReorderSummary_InvalidDataFormat() {
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40;Water:300:100;";
        String itemName = "Rations";  // Rations has an invalid format (missing reorder threshold)

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);

        assertNull(result);  // Should return null due to invalid format
    }

    // Test 5: Case insensitive item lookup
    @Test
    @DisplayName("getItemReorderSummary: Case-insensitive item lookup")
    public void testGetItemReorderSummary_CaseInsensitive() {
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String itemName = "tactical equipment";  // Lowercase input

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);
        String expected = "tactical equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered";

        assertEquals(expected, result);  // Should match despite case differences
    }

    // Test 6: Invalid quantity (non-numeric)
    @Test
    @DisplayName("getItemReorderSummary: Invalid quantity in inventory data (non-numeric)")
    public void testGetItemReorderSummary_InvalidQuantity() {
        String inventoryData = "Tactical Equipment:abc:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";
        String itemName = "Tactical Equipment";

        String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, itemName);

        assertNull(result);  // Should return null due to invalid quantity (non-numeric)
    }
}
