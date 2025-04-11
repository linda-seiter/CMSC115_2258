import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsDigitsTest {

    // Test case: String with only digits
    @Test
    @DisplayName("isDigits return true for string with all digits")
    public void testStringWithOnlyDigits() {
        assertTrue(InventoryAnalyzer.isDigits("12345"),
                "The string '12345' should be considered as containing only digits.");
    }

    // Test case: String with non-digit characters
    @Test
    @DisplayName("isDigits return false for string containing a non-digit")
    public void testStringWithNonDigitCharacters() {
        assertFalse(InventoryAnalyzer.isDigits("123a45"),
                "The string '123a45' should not be considered as containing only digits.");
    }

    // Test case: Null input
    @Test
    @DisplayName("isDigits return false for null string")
    public void testNullInput() {
        assertFalse(InventoryAnalyzer.isDigits(null), "The string should not be considered as containing only digits.");
    }

    // Test case: Empty string
    @Test
    @DisplayName("isDigits return false for empty string")
    public void testEmptyString() {
        assertFalse(InventoryAnalyzer.isDigits(""),
                "An empty string should not be considered as containing only digits.");
    }

}
