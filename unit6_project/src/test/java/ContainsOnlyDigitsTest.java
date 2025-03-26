import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainsOnlyDigitsTest {

    // Test case: Null input
    @Test
    @DisplayName("containsOnlyDigits return false for null string")
    public void testNullInput() {
        assertFalse(InventoryAnalyzer.containsOnlyDigits(null), "The string should not be considered as containing only digits.");
    }

    // Test case: Empty string
    @Test
    @DisplayName("containsOnlyDigits return false for empty string")
    public void testEmptyString() {
        assertFalse(InventoryAnalyzer.containsOnlyDigits(""), "An empty string should not be considered as containing only digits.");
    }

    // Test case: String with only digits
    @Test
    @DisplayName("containsOnlyDigits return true for string with all digits")
    public void testStringWithOnlyDigits() {
        assertTrue(InventoryAnalyzer.containsOnlyDigits("12345"), "The string '12345' should be considered as containing only digits.");
    }

    // Test case: String with non-digit characters
    @Test
    @DisplayName("containsOnlyDigits return false for string containing a non-digit")
    public void testStringWithNonDigitCharacters() {
        assertFalse(InventoryAnalyzer.containsOnlyDigits("123a45"), "The string '123a45' should not be considered as containing only digits.");
    }

    // Test case: String with spaces (spaces are not digits)
    @Test
    @DisplayName("containsOnlyDigits return false for string containing a space")
    public void testStringWithSpaces() {
        assertFalse(InventoryAnalyzer.containsOnlyDigits("1 3"), "The string '1 3' should not be considered as containing only digits.");
    }
}
