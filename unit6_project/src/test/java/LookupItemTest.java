import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LookupItemTest {

    @Test
    @DisplayName("lookupItem finds first item")
    public void testLookupItem_ItemExists() {
        // Arrange
        String inventoryData = "Guitar:150:50;Drum Kit:200:60;Trumpet:120:40;";
        String expected = "Guitar:150:50";

        // Act
        String result = InventoryAnalyzer.lookupItem(inventoryData, "Guitar");

        // Assert that the result is as expected
        assertEquals(expected, result, "The item details should match the expected output.");
    }

    @Test
    @DisplayName("lookupItem finds last item")
    public void testLookupItem_LastItem() {
        //Arrange
        String inventoryData = "Guitar:150:50;Flute:30:50;Drum Kit:200:60;Violin:80:30;Trumpet:120:40;";
        String expected = "Trumpet:120:40";

        //Act
        String result = InventoryAnalyzer.lookupItem(inventoryData, "Trumpet");

        // Assert that the result is as expected
        assertEquals(expected, result, "The item details should match the expected output.");
    }

    @Test
    @DisplayName("lookupItem returns null for non-existent item")
    public void testLookupItem_ItemDoesNotExist() {
        // Arrange
        String inventoryData = "Guitar:150:50;Drum Kit:200:60;Violin:80:30;Trumpet:120:40;";

        // Act
        String result = InventoryAnalyzer.lookupItem(inventoryData, "Piano");

        // Assert that the result is null because the item doesn't exist
        assertNull(result, "The result should be null as the item does not exist.");
    }

    @Test
    @DisplayName("lookupItem returns null for empty string")
    public void testLookupItem_EmptyInventory() {
        // Arrange
        String inventoryData = "";

        // Act
        String result = InventoryAnalyzer.lookupItem(inventoryData, "Guitar");

        // Assert that the result is null since the inventory is empty
        assertNull(result, "The result should be null as the inventory is empty.");
    }

}
