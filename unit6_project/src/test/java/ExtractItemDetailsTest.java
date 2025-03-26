import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExtractItemDetailsTest {

    @Test
    @DisplayName("extractItemDetails finds first item")
    public void testExtractItemDetails_ItemExists() {
        // Given the first item in the inventory
        String inventoryData = "Guitar:150:50;Drum Kit:200:60;Trumpet:120:40;";
        String expected = "150:50";

        // When calling extractItemDetails
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Guitar");

        // Then the item details should be extracted correctly
        assertEquals(expected, result, "The item details should match the expected output.");
    }

    @Test
    @DisplayName("extractItemDetails finds last item")
    public void testExtractItemDetails_LastItem() {
        // Given the last item in the inventory
        String inventoryData = "Guitar:150:50;Flute:30:50;Drum Kit:200:60;Violin:80:30;Trumpet:120:40;";
        String expected = "120:40";

        // When calling extractItemDetails
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Trumpet");

        // Then the item details should be extracted correctly
        assertEquals(expected, result, "The item details should match the expected output.");
    }


    @Test
    @DisplayName("extractItemDetails ignores case")
    public void testExtractItemDetails_IgnoreCase() {
        // Given the first item in the inventory
        String inventoryData = "GUITAR:150:50;";
        String expected = "150:50";

        // When calling extractItemDetails
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "guitar");

        // Then the item details should be extracted correctly
        assertEquals(expected, result, "The item details should match the expected output.");
    }


    @Test
    @DisplayName("extractItemDetails ignores case")
    public void testExtractItemDetails_IgnoreCase_2() {
        // Given the first item in the inventory
        String inventoryData = "guitar:150:50;";
        String expected = "150:50";

        // When calling extractItemDetails
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "GUITAR");

        // Then the item details should be extracted correctly
        assertEquals(expected, result, "The item details should match the expected output.");
    }

    @Test
    @DisplayName("extractItemDetails returns null for non-existent item")
    public void testExtractItemDetails_ItemDoesNotExist() {
        // Given an inventory that does not include Piano
        String inventoryData = "Guitar:150:50;Drum Kit:200:60;Violin:80:30;Trumpet:120:40;";

        // When calling extractItemDetails on a non-existent item
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Piano");

        // Then the result should be null
        assertNull(result, "The result should be null as the item does not exist.");
    }

    @Test
    @DisplayName("extractItemDetails returns null for empty string")
    public void testExtractItemDetails_EmptyInventory() {
        // Given an inventory with no items
        String inventoryData = "";

        // When calling extractItemDetails on any item
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Guitar");

        // Then the result should be null
        assertNull(result, "The result should be null as the inventory is empty.");
    }

    @Test
    @DisplayName("extractItemDetails missing colon after item name")
    public void testExtractItemDetails_ItemName_MissingColonAfterItemName() {
        // Given invalid item format
        String inventoryData = "Guitar:150:50;Flute30:50;";

        // When calling extractItemDetails with invalid item name
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Flute");

        // Then the result should be null
        assertNull(result, "The result should be null as the colon is missing after the item name.");
    }

    @Test
    @DisplayName("extractItemDetails missing semicolon")
    public void testExtractItemDetails_MissingSemiColon() {
        // Given invalid item format that is missing semicolon at the end of the item detail
        String inventoryData = "Guitar:150:50;Flute:30:50";

        // When calling extractItemDetails
        String result = InventoryAnalyzer.extractItemDetails(inventoryData, "Flute");

        // Then the result should be null
        assertNull(result, "The result should be null as the semicolon is missing.");
    }

}
