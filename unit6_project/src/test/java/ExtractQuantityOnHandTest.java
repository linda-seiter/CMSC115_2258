import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExtractQuantityOnHandTest {

    @Test
    @DisplayName("extractQuantityOnHand parses single digit before the colon")
    void testExtractQuantity_SingleDigit() {
        // Given a valid item detail string with single digit quantity
        String itemDetails = "5:20";

        // When calling extractQuantityOnHand
        int quantity = InventoryAnalyzer.extractQuantityOnHand(itemDetails);

        // Then the quantity should be extracted correctly
        assertEquals(5, quantity);
    }

    @Test
    @DisplayName("extractQuantityOnHand parses multiple digits before the colon")
    void testExtractQuantity_multipleDigits() {
        // Given a valid item detail string with multiple digit quantity
        String itemDetails = "400:50";

        // When calling extractQuantityOnHand with valid string
        int quantity = InventoryAnalyzer.extractQuantityOnHand(itemDetails);

        // Then the quantity should be extracted correctly
        assertEquals(400, quantity);
    }

    @Test
    @DisplayName("extractQuantityOnHand returns null when missing colon")
    void testExtractQuantity_invalidFormat_noColon() {
        // Given an item detail string missing the colon
        String itemDetails = "567";

        // When calling extractQuantity with invalid string
        int quantity = InventoryAnalyzer.extractQuantityOnHand(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, quantity);
    }

    @Test
    @DisplayName("extractQuantityOnHand returns null if quantity substring contains non-digit")
    void testExtractQuantity_nonIntegerQuantity() {
        // Given an item detail string with a non-integer quantity
        String itemDetails = "abc:50";

        // When calling extractQuantity with invalid string
        int quantity = InventoryAnalyzer.extractQuantityOnHand(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, quantity);
    }

    @Test
    @DisplayName("extractQuantityOnHand returns null if quantity substring is empty")
    void testExtractQuantity_quantityEmptyString() {
        // Given an item detail string missing the quantity (empty string before the colon)
        String itemDetails = ":50";

        // When calling extractQuantityOnHand with invalid string
        int quantity = InventoryAnalyzer.extractQuantityOnHand(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, quantity);
    }


}
