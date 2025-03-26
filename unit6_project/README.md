# Unit 6 Project - Inventory Analyzer

In this project, you will develop a **Inventory Analyzer**  that extracts and processes
item data from a structured string format. It enables users to track item quantities
and reorder thresholds, compare current stock against thresholds, and generate reorder
summaries for each item. The system aims to assist in inventory management by determining
whether items need to be reordered based on their current quantity and predefined reorder
thresholds.

## Learning Outcomes

1. **Extract Data from Structured Strings**:
   - Parse and extract specific data from a structured string format (e.g., `ItemName:Quantity:Threshold;ItemName:Quantity:Threshold;`).
   - Use string manipulation methods to extract substrings based on delimiters such as colons and semicolons.
   - Convert extracted string portions (e.g., quantity on hand and reorder threshold) into integers.

2. **Manipulate Strings Effectively**:
   - Apply string indexing, substring extraction, and case-insensitive searching to efficiently retrieve relevant data.
   - Identify and handle edge cases, such as missing delimiters or null/empty strings, to ensure the robustness of data parsing logic.

3. **Implement Conditional Logic for Validation**:
   - Use conditional statements to verify if data follows expected formats, such as checking for valid numeric values.
   - Compare extracted values (e.g., quantity vs. reorder threshold) to determine appropriate actions, such as whether to reorder an item.

4. **Create Reusable Utility Methods**:
   - Design utility methods that can be reused across different parts of the program, such as checking for numeric strings or extracting specific item details (e.g., quantity, threshold).
   - Break down larger tasks into smaller methods to enhance code modularity, maintainability, and readability.

5. **Apply Inventory Management Concepts**:
   - Implement basic inventory management logic, including evaluating reorder thresholds based on the current quantity on hand.
   - Generate meaningful outputs (e.g., reorder status) by comparing item quantities against reorder thresholds.

6. **Format Strings for Output**:
   - Use dynamic string formatting techniques to generate well-organized, readable outputs, such as summaries of item quantities and reorder statuses.
   - Ensure output readability and clarity for end-users or reports.

7. **Develop Debugging and Testing Skills**:
   - Implement debugging strategies to identify and fix issues in string parsing and conditional logic.
   - Use unit testing to verify that each method works correctly, covering edge cases and various input scenarios.

## Coding Guidelines

- You may use loops and conditionals, but avoid using advanced Java Streams.
- Do not use the `String` methods `split` or `matches` or other classes/methods that use regular expressions.

## Getting Started:

You will implement the methods in the `InventoryAnalyzer` class.  

The `main` method currently initializes the inventory with "Tactical Equipment" and
"Medical Kit". It does not include "Rations" and "Water".  The `main` method calls the `getItemReorderSummary` method,
which simply returns `null`.  Run the `main` method and confirm the output:

```text
null
null
null
null
```

## Task #1: Implement the `extractItemDetails` method

```java
/**
 * Extracts the details associated with an item from the given inventory data. The method returns the
 * substring following the item name, up to the semicolon that marks the end of the item's data.
 * The inventory data is assumed to be in the format:
 * "ItemName:Details;ItemName:Details;..." where each item is separated by a semicolon.
 *
 * The method performs a case-insensitive search for the item name to allow for flexibility in input.
 * It checks for the presence of the semicolon to ensure the item data is properly delimited,
 * but does not validate the content or format of the details following the item name.
 *
 * If the item is found, the method returns the details after the item name and before the next semicolon.
 * If the item is not found or the format is incorrect (e.g., missing the semicolon after the item data), 
 * it returns {@code null}.
 *
 * @param inventoryData The string containing the inventory data, where each item is formatted as
 *                      "ItemName:Details", separated by semicolons.
 * @param itemName The name of the item to search for in the inventory data. The search is case-insensitive.
 * @return The substring following the item name, up to the semicolon, or {@code null} if the item is not found
 *         or if the format is incorrect (e.g., missing the semicolon after the item data).
 */
public static String extractItemDetails(String inventoryData, String itemName)
```

Implement the `extractItemDetails` method to  extract the details of a
specific item from the provided inventory data. The inventory data is expected
to be in the format:

```
ItemName:Details;ItemName:Details;...
```

Each item is separated by a semicolon, and the item's name is followed by its
details. This method returns the substring of the details for the specified item
(excluding the semicolon), or `null` if the item is not found or the format is
incorrect (e.g., missing a semicolon after the item).

### Example Usage:


```java
//Item found.
String inventoryData, itemName, itemDetails;

inventoryData = "Medical Kit:5:20;Rations:40:50;";
itemName = "Medical Kit";
itemDetails = InventoryAnalyzer.extractItemDetails(inventoryData, itemName);
System.out.println(itemDetails); // Output: "5:20"

//Item found. Note the method need not validate format of details substring
inventoryData = "Water:H20;";
itemName = "Water";
itemDetails = InventoryAnalyzer.extractItemDetails(inventoryData, itemName);
System.out.println(itemDetails); // Output: "H20"

//Item found. Case-insensitive example.
inventoryData = "Rations:40:50;Tactical Equipment:100:30;";
itemName = "tactical EQUIPMENT";
itemDetails = InventoryAnalyzer.extractItemDetails(inventoryData, itemName);
System.out.println(itemDetails); // Output: "100:30"

//Item not found. Method returns null
inventoryData = "Tactical Equipment:100:30;";
itemName = "Water";
itemDetails = InventoryAnalyzer.extractItemDetails(inventoryData, itemName);
System.out.println(itemDetails); // Output: null

//Format invalid due to missing semicolon. Method returns null
inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20";
itemName = "Medical Kit";
itemDetails = InventoryAnalyzer.extractItemDetails(inventoryData, itemName);
System.out.println(itemDetails); // Output: null
```

Run the Junit tests in `ExtractItemDetailsTest` to confirm your implementation.

## Task #2: Implement the `containsOnlyDigits` method

The purpose of the `containsOnlyDigits` method is to check if a given string contains only digit characters. It returns true if the string contains only digits, and false otherwise (including when the string is null, empty, or contains non-digit characters).

```java
/**
* Checks if the given string contains only digit characters.
* The method returns true if all characters in the string are digits,
* and false if the string is null, empty, or contains any non-digit characters.
*
* @param str The string to be checked.
*            It can be any string, including null or empty.
* @return {@code true} if the string contains only digits; {@code false} otherwise.
*/
public static boolean containsOnlyDigits(String str)
```

Here a sample method calls:

```java
boolean result = containsOnlyDigits("123456");
System.out.println(result); // Output: true

boolean result = containsOnlyDigits("123a56");
System.out.println(result); // Output: false
```

Do not use `String.matches()` or other methods that rely on regular expressions.

Use a loop to get each character in the string and test if it is a digit, returning false if a character is a not a digit.
HINT: Call the `Character.isDigit()` method.

Run the Junit tests in `ContainsOnlyDigitsTest`  to confirm your implementation.

## Task #3: Implement the `ExtractQuantityOnHand` method

The `extractQuantityOnHand` method is responsible for extracting the quantity of an item from a string formatted as `"quantity:threshold"`.
The quantity is the numeric value before the colon (`:`), and it should be returned as an integer.

```java
 /**
  * Extracts the quantity on hand from a string formatted as "QuantityOnHand:ReorderThreshold".
  * The quantity on hand is expected to be a sequence of digits before the colon (:).
  * If the format is invalid or the quantity on hand is not a valid number, the method returns -1.
  *
  * @param itemDetails The string containing the quantity on hand and reorder threshold, separated by a colon.
  *                    For example, "50:25".
  * @return The quantity on hand as an integer if the substring before the colon consists solely of digits; otherwise, -1.
  */
 public static int extractQuantityOnHand(String itemDetails)
```

#### **Steps for Implementation**:
1. Find the Colon (`:`) Separator
2. Extract  the substring before the colon
3. Validate the quantity substring contains only digits
4. Convert the quantity from a string to an integer and return the value

The method should return -1 if a quantity can't be extracted from the parameter string.

Sample Calls:

   ```java
   //Valid quantity
   int quantity1 = extractQuantityOnHand("100:30");
   System.out.println(quantity1); // Output: 100
  
   //Invalid, contains a non-digit
   int quantity2 = extractQuantityOnHand("100a:30"); 
   System.out.println(quantity2); // Output: -1
   
   //Invalid, missing colon
   int quantity3 = extractQuantityOnHand("10030");
   System.out.println(quantity3); // Output: -1
   ```

Run the Junit tests in `ExtractQuantityOnHandTest`  to confirm your implementation.


## Task #4: Implement the `ExtractReorderThreshold` method

The `extractReorderThreshold` method is responsible for extracting the reorder threshold
of an item from a string formatted as `"quantity:threshold"`.
The quantity is the numeric value after the colon (`:`), and it should be returned as an integer.

```java
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
   if (containsOnlyDigits(thresholdString))
      return Integer.parseInt(thresholdString);
   else
      return -1;
}
```

Run the Junit tests in `ExtractReorderThresholdTest`  to confirm your implementation.

## Task #5: Implement the `ExtractReorderThreshold` method

The `getItemReorderSummary` method generates a summary of an item's reorder status based on the provided inventory data. It compares the quantity on hand of an item to its reorder threshold and determines if the item needs to be reordered.

```java
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
    public static String getItemReorderSummary(String inventoryData, String itemName) 
```

Consider the algorithm for this method:

1. **Extract Item Details:**
   - Search for the item name in the inventory data string.
   - If the item is found, extract its details (quantity on hand and reorder threshold).
   - If the item is not found, return `null`.

2. **Parse Quantity and Threshold:**
   - Extract the quantity on hand and reorder threshold values from the item details string.
   - If either value is invalid (e.g., not a valid number), return `null`.

3. **Determine Reorder Status:**
   - Compare the quantity on hand with the reorder threshold:
      - If the quantity on hand is less than or equal to the reorder threshold, the item "needs to be reordered."
      - Otherwise, it "does not need to be reordered."

4. **Format and Return Summary:**
   - Format the summary string in the format:
     ```
     "<itemName> - Quantity On Hand: <quantityOnHand>, Reorder Threshold: <reorderThreshold> - <reorderStatus>"
     ```
   - Return the formatted string with the reorder status.


### Example Usage:

1. **Sample 1:**
   ```java
   String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;";
   String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, "Tactical Equipment");
   System.out.println(result);
   // Output: "Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered"
   ```

2. **Sample 2:**
   ```java
   String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;";
   String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, "Medical Kit");
   System.out.println(result);
   // Output: "Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered"
   ```

3. **Sample 3: (Item not found)**
   ```java
   String inventoryData = "Tactical Equipment:100:30;Medical Kit:5:20;";
   String result = InventoryAnalyzer.getItemReorderSummary(inventoryData, "Rations");
   System.out.println(result);
   // Output: null
   ```

## Task #6: Edit the `main` method to add inventory

The `main` method currently initializes the inventory with only "Tactical Equipment" and
"Medical Kit". However, it does not include "Rations" and "Water". As a result, when running
the `main` method, the output will display `null` for these missing items:

```text
Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered
Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered
null
null
```

To resolve this, update the `inventoryData` variable in the `main` method to include the following two items:
- **Rations**: A quantity on hand of 40 and a reorder threshold of 50.
- **Water**: A quantity on hand of 300 and a reorder threshold of 100.

After updating the `inventoryData` string, run the `main` method again, and the output should be as follows:

```text
Tactical Equipment - Quantity On Hand: 100, Reorder Threshold: 30 - does not need to be reordered
Medical Kit - Quantity On Hand: 5, Reorder Threshold: 20 - needs to be reordered
Rations - Quantity On Hand: 40, Reorder Threshold: 50 - needs to be reordered
Water - Quantity On Hand: 300, Reorder Threshold: 100 - does not need to be reordered
```

Finally, run the JUnit tests in `MainTest` to ensure your changes are correctly implemented and functioning as expected.


## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
