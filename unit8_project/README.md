# Unit 8 Project

## Learning Goals

- Manipulate 2D arrays in Java, including accessing, modifying, and iterating over rows and columns.
- Use conditional logic and validation to ensure safe array access, preventing `ArrayIndexOutOfBoundsException`.
- Handle and process strings containing Unicode characters.
- Use a 2D array to visually represent data in a grid-like structure.
- Create modular, clean, and well-organized code using reusable methods to achieve a final outcome (such as landscaping a yard).

## Introduction

In this project, you will develop several methods within the `LandscapeService` class
to manipulate a 2D array that represents a rectangular yard.
The `main` method will add elements to the yard such as green grass,
a house surrounded by flowers, and trees surrounded by squirrels. 

For example:

```text
🌳🐿️🟩🟩🟩🟩🟩🐿️🌳
🐿️🐿️🟩🟩🟩🟩🟩🐿️🐿️
🟩🟩🟩🌸🌸🌸🟩🟩🟩
🟩🟩🟩🌸🏠🌸🟩🟩🟩
🟩🟩🟩🌸🌸🌸🟩🟩🟩
🐿️🐿️🟩🟩🟩🟩🟩🐿️🐿️
🌳🐿️🟩🟩🟩🟩🟩🐿️🌳
```

Array dimensions will be
specified as `rows X columns`. You may assume the methods to implement receive a non-empty, rectangular 2D array as a parameter.

## Restrictions

Do not use methods from the Java `Array` or `Arrays` classes to solve the tasks.


## Setup Instructions 

TBD

## Task #0 - Run the `main()` method with sample user input

The `LandscapeService` class contains a method `printMatrix` to print the contents of a 2D array of strings.
The `main` method creates a 2D array of strings with the dimensions given by the user, then calls `printMatrix`.

Run the `main()` method to confirm the matrix with the specified dimensions is created and printed:

```text
Enter rows and columns:
7 9
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
nullnullnullnullnullnullnullnullnull
```

Each cell contains the default String value of `null`.

## Task #1 - Implement the `fillMatrix()` method

The purpose of the `fillMatrix` method is to assign a specified fill value to every cell in a 2D array of strings.

```java
/**
 * Fills a 2D array with a given value.
 *
 * @param matrix The 2D array to be filled with new values.
 * @param fillValue A string that will replace the current value of each cell in the matrix.
 */
public static void fillMatrix(String[][] matrix, String fillValue) {
    //TODO
}
```

**Example 1**

```java
String[][] matrix = new String[3][3]; 

/* All cells are initially null:
{
    {null, null, null},
    {null, null, null},
    {null, null, null}
}
*/

// Reassign all cells to "X"
fillMatrix(matrix, "X");

/* All cells now contain "X" 
{
    {"X", "X", "X"},
    {"X", "X", "X"},
    {"X", "X", "X"}
}
 */
```

**Example 2**

```java
String[][] matrix = {
    {"A", "B"},
    {"C", "D"},
    {"E", "F"}
};

// Reassign all cells to "HI"
fillMatrix(matrix, "HI");

/* All cells now contain "HI" 
{
    {"HI", "HI"},
    {"HI", "HI"},
    {"HI", "HI"}
}
 */
```

Run the JUnit tests in the `TestFillMatrix` class to verify your solution.

Once the tests pass, update the `main()` method to fill the yard with dirt (brown squares).

```text
Enter rows and columns:
7 9
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
```


## Task #2 - Implement the `setMiddleCell()` method

The purpose of the `setMiddleCell` method is to assign a value 
to the middle cell in a 2D array.

If both the number of rows and columns are odd, the method should set
the cell at the exact center. If either the number of rows
or columns is even, there is no precise 'middle' cell. In these cases,
the method should select the cell closest to the center, favoring the
larger row and/or column index (bottom-central or right-central).
This can be accomplished by dividing the row or column size by 2
using integer division.

```java
/**
 * Assign the middle cell to a given string.
 * For even columns, set the cell with the larger column index in the central region.
 * For even rows, set the cell with the larger row index in the central region.
 *
 * @param matrix The 2D array.
 * @param value The string to assign the middle cell to.
 */
public static void setMiddleCell(String[][] matrix, String value) {
    //TODO
}
```

**Example 1**: 5x7: odd rows, odd columns

```java
String[][] matrix = {
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"}
};

// Set middle cell to "O"
setMiddleCell(matrix, "O");

/* Middle cell (2,3) contains "O" 
{
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "O", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B", "B"}
}
*/
```

**Example 2**: 4x6: even rows, even columns

```java
String[][] matrix = {
    {"B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B"}
};

// Set middle cell to "O"
setMiddleCell(matrix, "O");

/* Middle cell (2,3) contains "O". 
{
    {"B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B", "B"},
    {"B", "B", "B", "O", "B", "B"},
    {"B", "B", "B", "B", "B", "B"}
}
*/
```

Run the JUnit tests in the `TestSetMiddleCell` class to verify your solution.

Once the tests pass, update the `main()` method to add a house in the middle of the yard.

Test with various even and odd sized yards as shown.

```text
Enter rows and columns:
7 9
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🏠🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
```

```text
Enter rows and columns:
4 6
🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫
🟫🟫🟫🏠🟫🟫
🟫🟫🟫🟫🟫🟫
```

## Task #3 - Implement the `setCornerCells()` method

The `setCornerCells` method is designed to assign a value to the
corner cells of a 2D array: (first row, first column), (first row, last column),
(last row, first column), and (last row, last column).

The method should work for any non-empty 2D array, including arrays with a single row or column.

```java
/**
 * Sets the four corners of the array to a given string.
 *
 * @param matrix The 2D array.
 * @paramvalue The string to set in the corners.
 */
public static void setCornerCells(String[][] matrix, String value) {
    //TODO
}
```

**Example 1**: 3x4

```java
String[][] matrix = {
        {"A", "A", "A", "A"},
        {"B", "B", "B", "B"},
        {"C", "C", "C", "C"}
};

// Set corner cells to "Z"
setCornerCells(matrix, "Z");

/* Result 
{
        {"Z", "A", "A", "Z"},
        {"B", "B", "B", "B"},
        {"Z", "C", "C", "Z"}
}
*/
```

**Example 2**: 1x4

```java
String[][] matrix = {
        {"A", "A", "A", "A"}
};

// Set corner cells to "?"
setCornerCells(matrix, "?");

/* Result
{
        {"?", "A", "A", "?"}
}
*/
```

**Example 3**: 3x1

```java
String[][] matrix = {
        {"A"},
        {"B"},
        {"C"}
};

// Set corner cells to "#"
setCornerCells(matrix, "#");

/* Result 
{
        {"#"},
        {"B"},
        {"#"}
}
*/
```

**Example 4**: 1x1

```java
String[][] matrix = {
    {"B"}
};

// Set corner cells to "X"
setCornerCells(matrix, "X");

/* Result 
{
    {"X"}
}
*/
```

Run the JUnit tests in the `TestSetCornerCells` class to verify your solution.

Once the tests pass, update the `main()` to add trees in the corners of the yard.

```text
Enter rows and columns:
7 9
🌳🟫🟫🟫🟫🟫🟫🟫🌳
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🏠🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🟫🟫🟫🟫🟫🟫🟫🟫🟫
🌳🟫🟫🟫🟫🟫🟫🟫🌳
```

## Task #4 - Implement the `replaceValue()` method

The `replaceValue` method is used to replace all instances of a specified string in a 2D array with a new string.

```java
/**
 * Replaces all occurrences of a target string in the matrix with the specified new value.
 *
 * @param matrix The 2D array.
 * @param targetValue The string to be replaced.
 * @param newValue The string to replace the target with.
 */
public static void replaceValue(String[][] matrix, String targetValue, String newValue) {
    //TODO
}
```

The matrix may contain zero, one, or multiple occurrences of the
target string, and all such occurrences should
be replaced with the new value.

**Example**

```java
String[][] matrix = {
        {"A", "B", "B"},
        {"B", "B", "A"},
        {"B", "A", "B"}
};

// Replace "A" with "X"
replaceValue(matrix, "A", "X");

/* Cells that contained "A" now contain "X" 
{
        {"X", "B", "B"},
        {"B", "B", "X"},
        {"B", "X", "B"}
}
 */
```

Run the JUnit tests in the `TestReplaceTargetValue` class to verify your solution.

Once the tests pass, update the `main()` to replace the dirt (brown square) with grass (green square).

```text
Enter rows and columns:
7 9
🌳🟩🟩🟩🟩🟩🟩🟩🌳
🟩🟩🟩🟩🟩🟩🟩🟩🟩
🟩🟩🟩🟩🟩🟩🟩🟩🟩
🟩🟩🟩🟩🏠🟩🟩🟩🟩
🟩🟩🟩🟩🟩🟩🟩🟩🟩
🟩🟩🟩🟩🟩🟩🟩🟩🟩
🌳🟩🟩🟩🟩🟩🟩🟩🌳
```

## Task #5 - Implement the `isValidIndex()` method

The purpose of the `isValidIndex` method is to check if a given index is valid within the bounds
of a 2D array.

```java
/**
 * Checks if a given index is valid within the bounds of the 2D array.
 *
 * @param matrix The 2D array.
 * @param row The row index.
 * @param col The column index.
 * @return True if the indices are valid, false otherwise.
 */
public static boolean isValidIndex(String[][] matrix, int row, int col) {
    //TODO
}
```

**Example**: Given a 3x5 matrix, valid rows are in the range 0..2 and valid columns in 0..4.

```java
String[][] matrix = new String[3][5];  // 3 rows 5 columns

//4 corners are valid
System.out.println(isValidIndex(matrix, 0, 0)); //true
System.out.println(isValidIndex(matrix, 0, 4)); //true
System.out.println(isValidIndex(matrix, 2, 0)); //true
System.out.println(isValidIndex(matrix, 2, 4)); //true
//Interior cell is valid
System.out.println(isValidIndex(matrix, 1, 2)); //true

//Out of bounds indices are invalid
System.out.println(isValidIndex(matrix, -1, 0)); //false
System.out.println(isValidIndex(matrix, 3, 0));  //false
System.out.println(isValidIndex(matrix, 0, -1)); //false
System.out.println(isValidIndex(matrix, 0, 5));  //false
```

Run the JUnit tests in the `TestIsValidIndex` class to verify your solution.

## Task #6 - Implement the `setAdjacentCells()` method

The `setAdjacentCells` method assigns a new value to the cells that are adjacent
to a specified cell, including those horizontally, vertically, and diagonally adjacent.
To handle edge cases where the specified cell is located in the first or last
row, or the first or last column, the method should check the validity of the indices
before attempting to update an adjacent cell.

```java
/**
 * Assigns a new value to the cells adjacent to the given cell in all 8 directions
 * (top-left, top, top-right, left, right, bottom-left, bottom, and bottom-right).
 * The method checks the validity of the indices before updating the adjacent cells.
 *
 * @param matrix The 2D array representing the matrix.
 * @param row The row index of the given cell.
 * @param col The column index of the given cell.
 * @param newValue The string value to assign to the adjacent cells.
 */
public static void setAdjacentCells(String[][] matrix, int row, int col, String newValue) {
    //TODO
}
```

**Example 1**: Surround an interior cell having 8 adjacent cells

```java
String[][] matrix = {
    {"A", "A", "A", "A"},
    {"B", "B", "B", "B"},
    {"C", "C", "C", "C"},
    {"D", "D", "D", "D"},
    {"E", "E", "E", "E"}
};

// Surround interior cell (2, 1) with X
setAdjacentCells(matrix, 2, 1, "X");

/* Result 
{
    {"A", "A", "A", "A"},
    {"X", "X", "X", "B"},
    {"X", "C", "X", "C"},
    {"X", "X", "X", "D"},
    {"E", "E", "E", "E"}
}
*/
```

**Example 2**: Surround the cell in the first row and first column, which only has 3 adjacent cells. 

```java
String[][] matrix = {
    {"A", "A", "A", "A"},
    {"B", "B", "B", "B"},
    {"C", "C", "C", "C"},
    {"D", "D", "D", "D"},
    {"E", "E", "E", "E"}
};

// Surround first cell (0,0) with X
setAdjacentCells(matrix, 0, 0, "X");

/* Result 
{
    {"A", "X", "A", "A"},
    {"X", "X", "B", "B"},
    {"C", "C", "C", "C"},
    {"D", "D", "D", "D"},
    {"E", "E", "E", "E"}
}
*/
```

**Example 3**: Surround the cell in the last row and last column, which only has 3 adjacent cells.

```java
String[][] matrix = {
    {"A", "A", "A", "A"},
    {"B", "B", "B", "B"},
    {"C", "C", "C", "C"},
    {"D", "D", "D", "D"},
    {"E", "E", "E", "E"}
};

// Surround last cell (4,3) with X
setAdjacentCells(matrix, 4, 3, "X");

/* Result 
{
    {"A", "A", "A", "A"},
    {"B", "B", "B", "B"},
    {"C", "C", "C", "C"},
    {"D", "D", "X", "X"},
    {"E", "E", "X", "E"}
}
*/
```

Run the JUnit tests in the `TestSetAdjacentCells` class to verify your solution.

## Task #7 - Implement the `findAndUpdateAdjacentCells()` method

The `findAndUpdateAdjacentCells` method should find each cell
that matches the specified target value and update its adjacent cells
to the given new value by invoking the
`setAdjacentCells(String[][], int, int, String)` method.

```java
/**
 * Finds each cell in the matrix that matches the specified target value 
 * and updates its adjacent cells to the specified new value.
 *
 * The method iterates through the entire matrix and, when a cell containing 
 * the target value is found, updates the adjacent cells by calling the 
 * setAdjacentCells(String[][], int, int, String) method. 
 *
 * @param matrix The 2D array representing the matrix to search through.
 * @param targetValue The string value to search for in the matrix.
 * @param newValue The string value to assign to the adjacent cells of the matching target cells.
 */
public static void findAndUpdateAdjacentCells(String[][] matrix, String targetValue, String newValue) {
    //TODO
}
```

**Example 1**: Find and surround 2 instances of the target string "A"

```java
String[][] matrix = {
    {"B", "B", "B", "B", "B"},
    {"B", "A", "B", "B", "B"},
    {"B", "B", "B", "B", "B"},
    {"B", "B", "B", "B", "B"},
    {"B", "B", "B", "A", "B"},
    {"B", "B", "B", "B", "B"}
};

// Surround every "A" with "Z"
findAndUpdateAdjacentCells(matrix, "A", "Z");

/* Result 
{
    {"Z", "Z", "Z", "B", "B"},
    {"Z", "A", "Z", "B", "B"},
    {"Z", "Z", "Z", "B", "B"},
    {"B", "B", "Z", "Z", "Z"},
    {"B", "B", "Z", "A", "Z"},
    {"B", "B", "Z", "Z", "Z"}
}
*/
```

Run the JUnit tests in the `TestFindAndUpdateAdjacentCells` class to verify your solution.

Once the tests pass, update the `main()` to call `findAndUpdateAdjacentCells` twice:
- Surround the house with flowers 
- Surround the trees with squirrels

```text
Enter rows and columns:
7 9
🌳🐿️🟩🟩🟩🟩🟩🐿️🌳
🐿️🐿️🟩🟩🟩🟩🟩🐿️🐿️
🟩🟩🟩🌸🌸🌸🟩🟩🟩
🟩🟩🟩🌸🏠🌸🟩🟩🟩
🟩🟩🟩🌸🌸🌸🟩🟩🟩
🐿️🐿️🟩🟩🟩🟩🟩🐿️🐿️
🌳🐿️🟩🟩🟩🟩🟩🐿️🌳
```

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
