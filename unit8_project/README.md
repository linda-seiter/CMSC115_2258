# Lesson Title

## Learning Goals

- Learning Goal 1
- Learning Goal 2

## Introduction

A 1-2 sentence summary of what will be covered.

## Instructions

Download starter.

NOTE: Do not use methods from the Java `Array` or `Arrays` classes.


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

**Example 1**: We start with a 3x3 matrix where each cell is initialized to `null` (default for a `String` array in Java). All cells are updated with the value "X".

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

**Example 2**: We start with a 2x3 matrix where each cell has a different value. All cells are updated to "HI".

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

## Task #2 - Implement the `isValidIndex()` method

The purpose of the `isValidIndex` method check is a given index is valid within the bounds
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


## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
