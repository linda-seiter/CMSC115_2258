public class InventoryAnalyzer {

    /**
     * Looks up the details of a specific item in the inventory data.
     *
     * This method searches the given inventory data for the specified item name.
     * The inventory data is expected to be a semicolon-separated string with each item in the format:
     * "name:quantity:minimum". If the item is found, the method returns a substring of the inventory
     * data that includes the item's name, quantity on hand, and minimum reorder threshold.
     * If the item is not found, it returns null.
     *
     * @param inventoryData A string containing the inventory data, where each item is formatted as "name:quantity:threshold;".
     * @param itemName The name of the item to be looked up in the inventory.
     * @return A substring of the inventory data containing the item details in the format "name:quantity:threshold",
     *         or null if the item is not found in the inventory.
     */
    public static String lookupItem(String inventoryData, String itemName) {
        // Find the start index of the item in the string
        int itemIndex = inventoryData.indexOf(itemName + ":");
        if (itemIndex == -1) {
            return null; // Item not found
        }

        // Find the index of the semicolon (;) that marks the end of the item data
        int semicolonIndex = inventoryData.indexOf(";", itemIndex);

        // Extract the substring containing the item's quantity and threshold
        return inventoryData.substring(itemIndex, semicolonIndex);
    }


    // Method to extract the quantity of a given item
    //Assume item details are in the
    public static int extractQuantity(String itemDetails) {
        // Extract the quantity from the substring (after the first colon, before the second colon)
        int firstColonIndex = itemDetails.indexOf(":");
        int secondColonIndex = itemDetails.indexOf(":", firstColonIndex + 1);
        String quantityString = itemDetails.substring(firstColonIndex + 1, secondColonIndex);
        return Integer.parseInt(quantityString);
    }

    // Method to extract the minimum reorder threshold of a given item
    public static int extractMinimum(String itemDetails) {
        // Extract the minimum from the substring (after the second colon)
        int secondColonIndex = itemDetails.indexOf(":", itemDetails.indexOf(":") + 1);
        String thresholdString = itemDetails.substring(secondColonIndex + 1);
        return Integer.parseInt(thresholdString);
    }

    //Format the name, quantity, minimum, and reorder status of a given item
    public static String getItemReorderSummary(String inventoryData, String itemName) {
        String itemDetail = lookupItem(inventoryData, itemName );
        if (itemDetail == null)
            return null;
        int quantity = extractQuantity(itemDetail);
        int minimum = extractMinimum(itemDetail);
        String reorderStatus = quantity <= minimum ? "needs to be reordered" : "does not need to be reordered";
        return String.format("%s - Quantity On Hand: %d, Reorder Threshold: %d - %s", itemName, quantity, minimum, reorderStatus);
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Sample inventory
        String inventoryData = "Ammunition:100:30;Medical Kit:5:20;Rations:40:50;Water:300:100;";

        // Display the reorder summary for each item
        System.out.println(getItemReorderSummary(inventoryData, "Ammunition"));
        System.out.println(getItemReorderSummary(inventoryData, "Medical Kit"));
        System.out.println(getItemReorderSummary(inventoryData, "Rations"));
        System.out.println(getItemReorderSummary(inventoryData, "Water"));
    }
}
