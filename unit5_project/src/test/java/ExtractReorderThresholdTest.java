import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtractReorderThresholdTest {

    @Test
    @DisplayName("extractReorderThreshold parses single digit after the colon")
    void testExtractThreshold_SingleDigit() {
        // Given a valid item detail string with single digit minimum
        String itemDetails = "50:2";

        // When calling extractReorderThreshold
        int threshold = InventoryAnalyzer.extractReorderThreshold(itemDetails);

        // Then the threshold should be extracted correctly
        assertEquals(2, threshold);
    }

    @Test
    @DisplayName("extractReorderThreshold parses multiple digits after the colon")
    void testExtractThreshold_multipleDigits() {
        // Given a valid item detail string with multiple digit minimum
        String itemDetails = "4:100";

        // When calling extractReorderThreshold
        int threshold = InventoryAnalyzer.extractReorderThreshold(itemDetails);

        // Then the threshold should be extracted correctly
        assertEquals(100, threshold);
    }

    @Test
    @DisplayName("extractReorderThreshold returns null when missing colon")
    void testExtractThreshold_invalidFormat_noColon() {
        // Given an item detail string missing the colon
        String itemDetails = "567";

        // When calling extractReorderThreshold
        int threshold = InventoryAnalyzer.extractReorderThreshold(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, threshold);
    }

    @Test
    @DisplayName("extractReorderThreshold returns null if threshold substring contains non-digit")
    void testExtractThreshold_nonIntegerQuantity() {
        // Given an item detail string with a non-integer threshold
        String itemDetails = "50:def";

        // When calling extractReorderThreshold
        int threshold = InventoryAnalyzer.extractReorderThreshold(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, threshold);
    }

    @Test
    @DisplayName("extractReorderThreshold returns null if threshold substring is empty")
    void testExtractThreshold_quantityEmptyString() {
        // Given an item detail string missing the minimum (empty string after the colon)
        String itemDetails = "50:";

        // When calling extractReorderThreshold
        int threshold = InventoryAnalyzer.extractReorderThreshold(itemDetails);

        // Then the returned value should be -1
        assertEquals(-1, threshold);
    }


}
