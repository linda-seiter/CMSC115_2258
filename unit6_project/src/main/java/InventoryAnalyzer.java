
public class InventoryAnalyzer {

    /**
     * Extracts the details associated with an item from the given inventory data.
     * The inventory data is assumed to be in the format:
     * "ItemName:Details;ItemName:Details;..." where each item is separated by a
     * semicolon.
     * The method returns the substring following the item name, up to but not
     * including
     * the semicolon that marks the end of the item's details.
     *
     * @param inventoryData The string containing the inventory data, where each
     *                      item is formatted as
     *                      "ItemName:Details", separated by semicolons.
     * @param itemName      The name of the item to search for in the inventory
     *                      data.
     * @return The substring following the item name, up to the semicolon, or
     *         {@code null} if the item is not found
     *         or if the format is incorrect (e.g., missing the semicolon after the
     *         item data).
     */
    public static String extractItemDetails(String inventoryData, String itemName) {
        // TODO
        return null;
    }

    /**
     * Checks if the given string contains only digit characters and is not null or
     * empty. The method returns true if all characters in the string are digits,
     * and false if the string is null, empty, or contains any non-digit characters.
     *
     * @param str The string to be checked.
     * @return {@code true} if the string contains only digits; {@code false}
     *         otherwise.
     */
    public static boolean isDigits(String str) {
        // TODO
        return false;
    }

    /**
     * Extracts the quantity on hand from a string formatted as
     * "QuantityOnHand:ReorderThreshold".
     * The quantity on hand is expected to be a sequence of digits before the colon
     * (:).
     * If the format is invalid or the quantity on hand is not a valid number, the
     * method returns -1.
     *
     * @param itemDetails The string containing the quantity on hand and reorder
     *                    threshold, separated by a colon.
     *                    For example, "50:25".
     * @return The quantity on hand as an integer if the substring before the colon
     *         consists solely of digits; otherwise, -1.
     */
    public static int extractQuantityOnHand(String itemDetails) {
        // TODO
        return -1;
    }

    /**
     * Extracts the reorder threshold from a string formatted as
     * "QuantityOnHand:ReorderThreshold".
     * The threshold is expected to be a sequence of digits after the colon (:),
     * representing the quantity level at which a reorder should be triggered if the
     * current
     * inventory falls below or equals this threshold.
     * If the format is invalid or the threshold is not a valid number, the method
     * returns -1.
     *
     * @param itemDetails The string containing the quantity on hand and reorder
     *                    threshold, separated by a colon.
     *                    For example, "50:25".
     * @return The reorder threshold as an integer if the substring after the colon
     *         consists solely of digits; otherwise, -1.
     */
    public static int extractReorderThreshold(String itemDetails) {
        // TODO
        return -1;
    }

    /**
     * Generates a summary of an item's reorder status based on the provided
     * inventory data.
     * It extracts the quantity on hand and reorder threshold for the specified
     * item, compares them,
     * and determines if the item needs to be reordered.
     *
     * The format of the summary returned is:
     * "<itemName> - Quantity On Hand: <quantityOnHand>, Reorder Threshold:
     * <reorderThreshold> - <reorderStatus>"
     *
     * For example, for an item "Medical Kit" with a quantity on hand of 5 and a
     * reorder threshold of 20,
     * the summary might be:
     * "Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be
     * reordered"
     *
     * For an item "Tactical Equipment" with a quantity on hand of 100 and a reorder
     * threshold of 30,
     * the summary might be:
     * "Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not
     * need to be reordered"
     *
     * @param inventoryData A string containing multiple item records in the format
     *                      "ItemName:QuantityOnHand:ReorderThreshold;ItemName:QuantityOnHand:ReorderThreshold;".
     *                      Each item is separated by a semicolon, with the item's
     *                      name, quantity on hand,
     *                      and reorder threshold separated by colons.
     * @param itemName      The name of the item whose reorder status is to be
     *                      checked.
     * @return A string summary of the item's quantity on hand, reorder threshold,
     *         and whether it needs to be reordered.
     *         If the item is not found or the quantity or reorder threshold is
     *         invalid, returns null.
     */
    public static String getItemReorderSummary(String inventoryData, String itemName) {
        // TODO
        return null;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Sample inventory
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;";

        // Display the reorder summary for each item
        System.out.println(getItemReorderSummary(inventoryData, "Tactical Equipment"));
        System.out.println(getItemReorderSummary(inventoryData, "Medical Kit"));
        System.out.println(getItemReorderSummary(inventoryData, "Rations"));
        System.out.println(getItemReorderSummary(inventoryData, "Water"));
    }
}
