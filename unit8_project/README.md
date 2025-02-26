# Lesson Title

## Learning Goals

- Learning Goal 1
- Learning Goal 2

## Introduction

A 1-2 sentence summary of what will be covered.

## Instructions

Download starter.

NOTE: Do not use methods from the Java `Array` or `Arrays` classes.


## Task #1 - Implement the `fillMatrix()` Method

### Objective

The purpose of the `fillMatrix` method is to assign a specified fill value to every cell in a 2D array of strings.

```java
public static void fillMatrix(String[][] matrix, String fillValue) {
    //TODO
}
```

The method accepts two parameters:
1. `matrix`: A 2D array of strings that will be updated.
2. `fillValue`: A string that will replace the current value of each cell in the matrix.

### Examples

- **Example 1**: We start with a 3x3 matrix where each cell is initialized to `null` (default for a `String` array in Java). All cells are updated with the value "X".
- **Example 2**: We start with a 2x3 matrix where each cell has a different value. All cells are updated to "HI".

#### Example 1

**Initial Matrix**:

```java
String[][] m1 = new String[3][3]; 
/* All cells are initially null:
{
    {null, null, null},
    {null, null, null},
    {null, null, null}
}
*/
```

**Method Call**:
```java
fillMatrix(m1, "X");
```

**Updated Matrix**:

```java
{
    {"X", "X", "X"},
    {"X", "X", "X"},
    {"X", "X", "X"}
}
```

#### Example 2

**Initial Matrix**:

```java
String[][] m2 = {
    {"A", "B"},
    {"C", "D"},
    {"E", "F"}
};
```

**Method Call**:
```java
fillMatrix(m2, "HI");
```

**Updated Matrix**:

```java
{
    {"HI", "HI"},
    {"HI", "HI"},
    {"HI", "HI"}
}
```

### Testing

After implementing the method, run the JUnit tests in the `TestFillMatrix` class to verify your solution.


## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
