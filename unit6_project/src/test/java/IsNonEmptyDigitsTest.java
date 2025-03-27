import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsNonEmptyDigitsTest {

    // Test case: String with only digits
    @Test
    @DisplayName("isNonEmptyDigits return true for string with all digits")
    public void testStringWithOnlyDigits() {
        assertTrue(InventoryAnalyzer.isNonEmptyDigits("12345"), "The string '12345' should be considered as containing only digits.");
    }

    // Test case: String with non-digit characters
    @Test
    @DisplayName("isNonEmptyDigits return false for string containing a non-digit")
    public void testStringWithNonDigitCharacters() {
        assertFalse(InventoryAnalyzer.isNonEmptyDigits("123a45"), "The string '123a45' should not be considered as containing only digits.");
    }

    // Test case: Null input
    @Test
    @DisplayName("isNonEmptyDigits return false for null string")
    public void testNullInput() {
        assertFalse(InventoryAnalyzer.isNonEmptyDigits(null), "The string should not be considered as containing only digits.");
    }

    // Test case: Empty string
    @Test
    @DisplayName("isNonEmptyDigits return false for empty string")
    public void testEmptyString() {
        assertFalse(InventoryAnalyzer.isNonEmptyDigits(""), "An empty string should not be considered as containing only digits.");
    }

}
