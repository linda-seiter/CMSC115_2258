# Unit 6 Project - Inventory Analyzer

In this project, you will develop a **Inventory Analyzer**  that extracts and processes
item data from a structured string format. It enables users to track item quantities
and reorder thresholds, compare current stock against thresholds, and generate reorder
summaries for each item. The system aims to assist in inventory management by determining
whether items need to be reordered based on their current quantity and predefined reorder
thresholds.

## Learning Outcomes

1. **Model Inventory Data with Strings**:
   - Use strings to represent and manage inventory data, including item names, quantities, and reorder thresholds.
   - Implement logic to check reorder levels and generate summaries, using string manipulation to extract and format relevant data for reporting.

2. **Extract and Manipulate Data from Strings**:
   - Create, concatenate, compare, and format strings.
   - Use string indexing, substring extraction, and case-insensitive searching to parse and extract data from structured strings.
   - Access individual characters in a string.
   - Use a loop to iterate through the characters in a string.

3. **Implement Conditional Logic for String Validation**:
   - Use conditionals to verify data formats, like checking for valid numbers.
   - Handle edge cases like missing delimiters or null/empty strings for robust parsing.
   - Compare extracted values to decide on actions.

4. **Format Strings for Output**:
   - Use string formatting to generate readable summaries.

5. **Work with Reference Types**:
   - Distinguish between primitive data types (e.g., `int`, `double`, `boolean`) and reference data types (e.g., `String`).
   - Recognize that `null` in Java signifies the absence of a reference.
   - Check for `null` to prevent `NullPointerExceptions` when working with reference types.

6. **Handle String References in Methods**:
   - Write methods that accept string parameters and return string values.
   - Return dynamically generated strings after processing or modification.

7. **Develop Debugging and Testing Skills**:
   - Use debugging techniques to visualize and inspect the structure of strings in memory, focusing on how strings are stored.
   - Apply debugging techniques to fix issues in string parsing and logic.

8. **Master Modular Programming and the Single Responsibility Principle**:
   - Decompose tasks into smaller, focused methods, each responsible for a single action to enhance clarity and reduce complexity.
   - Write reusable methods to avoid redundancy, making the code more efficient and maintainable.
   - Group related tasks (e.g., data extraction, validation, and formatting) into distinct methods, improving organization, maintainability, and ease of debugging.


## Coding Guidelines

- You may use loops and conditionals, but avoid using advanced Java Streams.
- Do not use the `String` methods `split` or `matches` or other classes/methods that use regular expressions.

## Getting Started:

You will implement the methods in the `InventoryAnalyzer` class.  

The `main` method currently initializes the inventory with two items and then calls the `getItemReorderSummary` method,
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

## Task #2: Implement the `isNonEmptyDigits` method

The purpose of the `isNonEmptyDigits` method is to check if a given string can be parsed as
a non-negative integer, i.e. it contains only digit characters and is not null or empty. 

```java
/**
 * Checks if the given string contains only digit characters and is not null or empty.
 * The method returns true if all characters in the string are digits,
 * and false if the string is null, empty, or contains any non-digit characters.
 *
 * @param str The string to be checked.
 * @return {@code true} if the string contains only digits; {@code false} otherwise.
 */
public static boolean isNonEmptyDigits(String str)
```

Sample method calls:

```java
boolean result1 = isNonEmptyDigits("123456");
System.out.println(result1); // Output: true

boolean result2 = isNonEmptyDigits("123a56");
System.out.println(result2); // Output: false

boolean result3 = isNonEmptyDigits("");
System.out.println(result3); // Output: false
```

Do not use `String.matches()` or other methods that rely on regular expressions.

HINT: Use a loop to get each character in the string and test if it is a digit by calling the `Character.isDigit()` method.
Return false if a character is **not** a digit.

Run the Junit tests in `IsNonEmptyDigitsTest`  to confirm your implementation.

## Task #3: Implement the `ExtractQuantityOnHand` method

The `extractQuantityOnHand` method is responsible for extracting the quantity of an item from a string formatted as `"quantity:threshold"`.
The quantity is the numeric value before the colon (`:`), and it should be returned as an integer.

```java
 /**
  * Extracts the quantity on hand from a string formatted as "QuantityOnHand:ReorderThreshold".
  * The quantity on hand is expected to be a sequence of digits before the colon (:).
  * If the format is invalid or the quantity on hand is not a valid sequence of digits, the method returns -1.
  *
  * @param itemDetails The string containing the quantity on hand and reorder threshold, separated by a colon.
  *                    For example, "50:25".
  * @return The quantity on hand as an integer if the substring before the colon consists solely of digits; otherwise, -1.
  */
 public static int extractQuantityOnHand(String itemDetails)
```

#### **Algorithm**:
1. Find the Colon (`:`) Separator
2. Extract  the substring before the colon
3. Validate the quantity substring contains only digits
4. Convert the quantity from a string to an integer and return the value

The method should return -1 if a quantity can't be extracted as an integer from the parameter string.

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

   //Invalid, empty string
   int quantity4 = extractQuantityOnHand(":30");
   System.out.println(quantity4); // Output: -1
   ```

Run the Junit tests in `ExtractQuantityOnHandTest`  to confirm your implementation.

## Task #4: Implement the `ExtractReorderThreshold` method

The `extractReorderThreshold` method is responsible for extracting the reorder threshold
of an item from a string formatted as `"quantity:threshold"`.
The reorder threshold is the numeric value after the colon (`:`), and it should be returned as an integer.

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
public static int extractReorderThreshold(String itemDetails)
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
   - If either value can't be extracted (e.g., extract method returns -1), return `null`.

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
