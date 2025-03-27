
public class InventoryAnalyzer {

    /**
     * Extracts the details associated with an item from the given inventory data.
     * The inventory data is assumed to be in the format:
     * "ItemName:Details;ItemName:Details;..." where each item is separated by a semicolon.
     * The method returns the substring following the item name, up to but not including
     * the semicolon that marks the end of the item's details.
     *
     * @param inventoryData The string containing the inventory data, where each item is formatted as
     *                      "ItemName:Details", separated by semicolons.
     * @param itemName The name of the item to search for in the inventory data.
     * @return The substring following the item name, up to the semicolon, or {@code null} if the item is not found
     *         or if the format is incorrect (e.g., missing the semicolon after the item data).
     */
    public static String extractItemDetails(String inventoryData, String itemName) {
        // Find the start index of the item in the string
        String searchStr = itemName + ":";
        int itemIndex = inventoryData.toLowerCase().indexOf(searchStr.toLowerCase());
        if (itemIndex == -1) {
            return null; // Item not found
        }

        // Find the index of the semicolon (;) that marks the end of the item data
        int semicolonIndex = inventoryData.indexOf(";", itemIndex);
        // Return null if there isn't a semicolon
        if (semicolonIndex == -1)
            return null;

        // Extract and return the substring containing the item details
        return inventoryData.substring(itemIndex + searchStr.length(), semicolonIndex);
    }

    /**
     * Checks if the given string contains only digit characters and is not null or empty.
     * The method returns true if all characters in the string are digits,
     * and false if the string is null, empty, or contains any non-digit characters.
     *
     * @param str The string to be checked.
     * @return {@code true} if the string contains only digits; {@code false} otherwise.
     */
    public static boolean isNonEmptyDigits(String str) {
        // Check if the string is null or empty
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // If any character is not a digit, return false
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        // If all characters are digits, return true
        return true;
    }


    /**
     * Extracts the quantity on hand from a string formatted as "QuantityOnHand:ReorderThreshold".
     * The quantity on hand is expected to be a sequence of digits before the colon (:).
     * If the format is invalid or the quantity on hand is not a valid number, the method returns -1.
     *
     * @param itemDetails The string containing the quantity on hand and reorder threshold, separated by a colon.
     *                    For example, "50:25".
     * @return The quantity on hand as an integer if the substring before the colon consists solely of digits; otherwise, -1.
     */
    public static int extractQuantityOnHand(String itemDetails) {
        // Extract the quantity on hand from the substring (before the colon)
        int colonIndex = itemDetails.indexOf(":");
        if (colonIndex == -1)
            return -1;
        String quantityString = itemDetails.substring(0, colonIndex);

        // Ensure the substring can be parsed as an integer
        if (isNonEmptyDigits(quantityString))
            return Integer.parseInt(quantityString);
        else
            return -1;
    }

    /**
     * Extracts the reorder threshold from a string formatted as "QuantityOnHand:ReorderThreshold".
     * The threshold is expected to be a sequence of digits after the colon (:),
     * representing the quantity level at which a reorder should be triggered if the current
     * inventory falls below or equals this threshold.
     * If the format is invalid or the threshold is not a valid number, the method returns -1.
     *
     * @param itemDetails The string containing the quantity on hand and reorder threshold, separated by a colon.
     *                    For example, "50:25".
     * @return The reorder threshold as an integer if the substring after the colon consists solely of digits; otherwise, -1.
     */
    public static int extractReorderThreshold(String itemDetails) {
        // Extract the threshold from the substring (after the colon)
        int colonIndex = itemDetails.indexOf(":");
        if (colonIndex == -1)
            return -1;
        String thresholdString = itemDetails.substring(colonIndex + 1);

        // Ensure the substring can be parsed as an integer
        if (isNonEmptyDigits(thresholdString))
            return Integer.parseInt(thresholdString);
        else
            return -1;
    }

    /**
     * Generates a summary of an item's reorder status based on the provided inventory data.
     * It extracts the quantity on hand and reorder threshold for the specified item, compares them,
     * and determines if the item needs to be reordered.
     *
     * The format of the summary returned is:
     * "<itemName> - Quantity On Hand: <quantityOnHand>, Reorder Threshold: <reorderThreshold> - <reorderStatus>"
     *
     * For example, for an item "Medical Kit" with a quantity on hand of 5 and a reorder threshold of 20,
     * the summary might be:
     * "Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered"
     *
     *  For an item "Tactical Equipment" with a quantity on hand of 100 and a reorder threshold of 30,
     *  the summary might be:
     *  "Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered"
     *
     * @param inventoryData A string containing multiple item records in the format
     *                      "ItemName:QuantityOnHand:ReorderThreshold;ItemName:QuantityOnHand:ReorderThreshold;".
     *                      Each item is separated by a semicolon, with the item's name, quantity on hand,
     *                      and reorder threshold separated by colons.
     * @param itemName The name of the item whose reorder status is to be checked.
     * @return A string summary of the item's quantity on hand, reorder threshold, and whether it needs to be reordered.
     *         If the item is not found or the quantity or reorder threshold is invalid, returns null.
     */
    public static String getItemReorderSummary(String inventoryData, String itemName) {
        // Use the name to find the item details in the inventory
        String itemDetail = extractItemDetails(inventoryData, itemName);
        if (itemDetail == null)
            return null;

        // Extract quantity on hand and reorder threshold
        int quantityOnHand = extractQuantityOnHand(itemDetail);
        int reorderThreshold = extractReorderThreshold(itemDetail);
        if (quantityOnHand == -1 || reorderThreshold == -1)
            return null;

        // Compare quantity on hand and reorder threshold to determine reorder status
        String reorderStatus = quantityOnHand <= reorderThreshold ? "needs to be reordered" : "does not need to be reordered";

        // Return a formatted item summary, including the reorder status
        return String.format("%s - Quantity On Hand: %d, Reorder Threshold: %d - %s", itemName, quantityOnHand, reorderThreshold, reorderStatus);
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Sample inventory
        String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";

        // Display the reorder summary for each item
        System.out.println(getItemReorderSummary(inventoryData, "Tactical Equipment"));
        System.out.println(getItemReorderSummary(inventoryData, "Medical Kit"));
        System.out.println(getItemReorderSummary(inventoryData, "Rations"));
        System.out.println(getItemReorderSummary(inventoryData, "Water"));
    }
}
