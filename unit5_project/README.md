# Unit 5 Project - RoomPaintingCostCalculator

### Introduction 

The `RoomPaintingCostCalculator` application calculates the total area
of the walls and ceiling of a rectangular room and estimates the cost of paint
required to cover those surfaces. The user inputs the room's dimensions
(length, width, and height) and can specify whether the ceiling should
be included in the area calculation. The program uses predefined constants
for paint coverage and price per gallon to calculate the amount of paint needed
and its total cost.

<img src="images/rectangular_prism.png" alt="rectangular prism" width=300>

Key features of this application include:
- Validating room dimensions to ensure proper input.
- Calculating the surface area of walls and ceiling.
- Estimating the total paint cost based on the surface area.
- Generating a formatted report summarizing the results.

Constants used for the calculation:
- **SQFT_PER_GALLON**: Coverage area of one gallon of paint (350 square feet).
- **PRICE_PER_GALLON**: Price of one gallon of paint ($50.75).

This project demonstrates how to implement static methods, promote modularity,
and encourage code reuse by breaking down the problem into smaller, manageable
functions. It also showcases how to handle basic mathematical calculations,
validate user input, and generate formatted output in Java.

## Learning Outcomes

1. **Design and Implement Modular Methods**:
    - Design and implement modular, reusable methods that perform specific tasks and reduce code redundancy.
    - Assign a single responsibility to each method to enhance code clarity, maintainability, and testability.

2. **Pass Parameters, Use Local Variables, and Handle Return Values**:
    - Pass values into methods using parameters.
    - Store intermediate results in local variables within methods.
    - Validate parameters to ensure methods operate with valid data, enhancing program reliability.
    - Return values from methods to pass data out.

3. **Method Composition**
    - Pass return values from one method as parameters to another.
    - Combine simple, specialized methods to build complex functionality, promoting modularity and reusability.
   
4. **Debug and Comprehend the Call Stack**:
    - Debug a Java program to track the flow of execution through methods via the call stack.
    - Use debugging techniques to trace variable values and resolve issues related to variable scope and method calls.
    - Inspect how method calls are pushed to and popped from the stack, and how parameters and local variables are created, stored, and destroyed within the stack during method execution.

5. **Validate Input and Handle Errors**:
    - Implement methods for input validation to handle invalid data gracefully.

6. **Generate and Format Output**:
    - Write methods that use string formatting to present results in a clear and readable manner.

## Coding Guidelines

- You may use loops and conditionals, but avoid using advanced Java Streams or Lambdas.

## Task #1: `isValidRectangle`

Implement and test a method called `isValidRectangle` that verifies if the length and width provided
as parameters represent a valid rectangle. The method should return `true` if both dimensions are
greater than zero, and `false` otherwise.

```java
/**
 * Checks if the given length and width represent a valid rectangle.
 * A valid rectangle must have both dimensions greater than zero.
 *
 * @param length The length of the rectangle.
 * @param width The width of the rectangle.
 * @return true if the dimensions represent a valid rectangle, false otherwise.
 */
public static boolean isValidRectangle(double length, double width)
```

Here are a few sample method calls for the `isValidRectangle` method:

```java
// Example 1: Valid rectangle
boolean isValid1 = isValidRectangle(5.0, 3.0);
System.out.println(isValid1); // Expected: true

// Example 2: Invalid rectangle (length is zero)
boolean isValid2 = isValidRectangle(0.0, 3.0);
System.out.println(isValid2); // Expected: false

// Example 3: Invalid rectangle (negative width)
boolean isValid3 = isValidRectangle(5.0, -3.0);
System.out.println(); // Expected: false
``` 

Run the Junit tests in `IsValidRectangleTest` to confirm your solution.

## Task #2: `isValidRectangularPrism`

A rectangular prism is a three-dimensional geometric shape with six rectangular faces,
where each face meets at a right angle.  Common examples include boxes, envelopes, and books.

Implement and test a method called `isValidRectangularPrism` that verifies if the length, width, and height
provided as parameters represent a valid rectagular prism. The method should return `true` if all three dimensions are
greater than zero, and `false` otherwise.

```java
/**
 * Checks if the given length, width, and height represent a valid rectangular prism.
 * A valid rectangular prism must have all dimensions greater than zero.
 *
 * @param length The length of the rectangular prism.
 * @param width The width of the rectangular prism.
 * @param height The height of the rectangular prism.
 * @return true if the dimensions represent a valid rectangular prism, false otherwise.
 */
public static boolean isValidRectangularPrism(double length, double width, double height) 
```

Here are a few sample method calls for the `isValidRectangularPrism` method:

```java
// Example 1: Valid rectangular prism
boolean isValid1 = isValidRectangularPrism(5.0, 3.0, 2.0);
System.out.println(isValid1); // Expected: true

// Example 2: Invalid rectangular prism (length is zero)
boolean isValid2 = isValidRectangularPrism(0.0, 3.0, 2.0);
System.out.println(isValid2); // Expected: false

// Example 3: Invalid rectangular prism (negative width)
boolean isValid3 = isValidRectangularPrism(5.0, -3.0, 2.0);
System.out.println(); // Expected: false

// Example 4: Invalid rectangular prism (negative height)
boolean isValid4 = isValidRectangularPrism(5.0, 3.0, -2.0);
System.out.println(isValid4); // Expected: false
```

Run the Junit tests in `IsValidRectangularPrismTest` to confirm your solution.

## Task #3: `getCeilingArea`

Implement and test a method called `getCeilingArea` that calculates the ceiling area given the room length and width.

```java
/**
 * Calculates the ceiling area of a rectangular room using the given length and width.
 * If either dimension is invalid (less than or equal to zero), the method returns 0.
 *
 * @param length The length of the room.
 * @param width The width of the room.
 * @return The area of the ceiling, or 0 if either dimension is invalid.
 */
public static double getCeilingArea(double length, double width)
```

The `getCeilingArea` method should leverage **method composition** by calling the `isValidRectangle` method to
validate the dimensions. If the dimensions are valid, `getCeilingArea` should calculate and return the area;
otherwise, it should return `0.0`. This approach avoids duplicating the validity check and promotes code
reusability by simply invoking the `isValidRectangle` method.

Here are a few sample method calls for the `getCeilingArea` method:

```java
// Example 1: Valid rectangle
double ceilingArea1 = getCeilingArea(5.0, 3.0);
System.out.println(ceilingArea1); // Expected: 15.0

// Example 2: Invalid rectangle (length is zero)
double ceilingArea2 = getCeilingArea(0.0, 3.0);
System.out.println(ceilingArea2); // Expected: 0.0

// Example 3: Invalid rectangle (negative width)
double ceilingArea3 = getCeilingArea(5.0, -3.0);
System.out.println(ceilingArea3); // Expected: 0.0
``` 

Run the Junit tests in `GetCeilingAreaTest` to confirm your solution.  One of the tests checks that `getCeilingArea` calls `isValidRectangle`.

## Task #4: `getWallArea`

Implement and test a method called `getWallArea` that calculates the wall area given
the room length, width, and height.  


```java
/**
 * Calculates the total wall area of a room with a rectangular prism shape, using the provided length, width, and height.
 * If any of the dimensions are invalid (less than or equal to zero), the method returns 0.
 *
 * @param length The length of the room.
 * @param width The width of the room.
 * @param height The height of the room.
 * @return The total wall area of the room, or 0 if any dimension is invalid.
 */
```

Just like the validation check for calculating the ceiling area, the room dimensions
should be validated to ensure they form a valid rectangular prism.
If the room is a rectangular prism, the
wall area can be determined by multiplying the perimeter by the height.

Here are a few sample method calls for the `getWallArea` method:

```java
// Example 1: Valid rectangular prism
double wallArea1 = getWallArea(5.0, 3.0, 4.0);
System.out.println(wallArea1); // Expected: 64.0

// Example 2: Invalid rectangular prism (length is zero)
double wallArea2 = getWallArea(0.0, 3.0, 4.0);
System.out.println(wallArea2); // Expected: 0.0

// Example 3: Invalid rectangular prism (negative width)
double wallArea3 = getWallArea(5.0, -3.0, 4.0);
System.out.println(wallArea3); // Expected: 0.0
```

Run the Junit tests in `GetWallAreaTest` to confirm your solution.  One of the tests checks that `getWallArea` calls `isValidRectangularPrism`.


## Task #5: `getSurfaceArea`

Implement and test a method called `getSurfaceArea` that calculates the total surface area
of a room shaped like a rectangular prism, with an option to include or exclude
the ceiling area. The floor area is not included in the calculation.

```java
/**
 * Calculates the total surface area of a room shaped like a rectangular prism, with an option to include or exclude the ceiling area. 
 * Note that the floor area is not included in the calculation.
 * The provided length, width, and height are used for the calculation. If any dimension is invalid (less than or equal to zero), the method returns 0.
 *
 * @param length The length of the room in feet.
 * @param width The width of the room in feet.
 * @param height The height of the room in feet.
 * @param includeCeiling A flag to indicate whether the ceiling area should be included in the total surface area.
 * @return The total surface area to be painted, or 0 if any dimension is invalid.
 */
public static double getSurfaceArea(double length, double width, double height, boolean includeCeiling)
```

The room dimensions must be validated to confirm they form a valid rectangular prism; if not,
the method should return 0. If the dimensions are valid, the method should calculate the
paintable surface area by calling `getWallArea` and, depending on the flag, possibly
`getCeilingArea`.

Here are a few method calls for the `getSurfaceArea` method:


```java
// Example 1: Valid rectangular prism with ceiling area included
double surfaceArea1 = getSurfaceArea(5.0, 3.0, 4.0, true);
System.out.println(surfaceArea1); // Expected: 79.0 (ceiling area included)

// Example 2: Invalid rectangular prism (length is zero)
double surfaceArea2 = getSurfaceArea(0.0, 3.0, 4.0, true);
System.out.println(surfaceArea2); // Expected: 0.0

// Example 3: Invalid rectangular prism (negative width)
double surfaceArea3 = getSurfaceArea(5.0, -3.0, 4.0, true);
System.out.println(surfaceArea3); // Expected: 0.0

// Example 4: Valid rectangular prism with ceiling area excluded
double surfaceArea4 = getSurfaceArea(5.0, 3.0, 4.0, false);
System.out.println(surfaceArea4); // Expected: 64.0 (ceiling area excluded)
```

Run the Junit tests in `GetSurfaceAreaTest` to confirm your solution.

## Task #5: `calculatePaintCost`

Implement and test a method called `calculatePaintCost` that  calculates
how many gallons of paint are required to cover the area,
and then calculates the total cost of the paint based on the price per gallon.

The method should define local variables for the following constants to be used in the calculation:
- SQFT_PER_GALLON: the coverage area of one gallon of paint (350 square feet).
- PRICE_PER_GALLON: the price per gallon of paint ($50.75).

```java
    /**
 * Calculates the cost of paint required to cover a given surface area.
 *
 * This method calculates how many gallons of paint are required to cover the area,
 * and then calculates the total cost of the paint based on the price per gallon.
 *
 * The constants used in this calculation are:
 * - SQFT_PER_GALLON: the coverage area of one gallon of paint (350 square feet).
 * - PRICE_PER_GALLON: the price per gallon of paint ($50.75).
 *
 * @param totalSquareFeet The total surface area in square feet that needs to be painted.
 * @return The total cost of paint required to cover the surface area.
 */
public static double calculatePaintCost(double totalSquareFeet)
```

Here are a few method calls for the `calculatePaintCost` method:

```java
// Sample call 1: Calculate paint cost for 700 square feet
        double surfaceArea1 = 700.0;
        double cost1 = calculatePaintCost(surfaceArea1);
        System.out.println(cost1); //Expected: 101.5

        // Sample call 2: Calculate paint cost for 0 square feet (no painting needed)
        double surfaceArea2 = 0.0;
        double cost2 = calculatePaintCost(surfaceArea2);
        System.out.println(cost2);  //Expected: 0.0

        // Sample call 3: Calculate paint cost for 1100 square feet
        double surfaceArea3 = 1100.0;
        double cost3 = calculatePaintCost(surfaceArea3);
        System.out.println(cost3); //Expected: 159.5
```

Run the Junit tests in `CalculatePaintCostTest` to confirm your solution. 

## Task #6: `generatePaintCostReport`

Implement the method `generatePaintCostReport` to return a string containing
the surface area and cost to paint the room. The values should be
formatted to display two digits after the decimal point.

Example format: "Total area: 700.00 square feet, total cost: $102.25"

```java
/**
 * Generates a formatted report of the surface area and the total cost.
 *
 * Example format: "Total area: 700.00 square feet, total cost: $102.25"
 * The values are formatted to display two digits after the decimal point.
 *
 * @param surfaceArea The surface area to be painted.
 * @param paintCost The cost of the paint.
 * @return A formatted string containing the surface area and cost to paint the room.
 */
public static String generatePaintCostReport(double surfaceArea, double paintCost)
```

Run the Junit tests in `PaintCostReportTest` to confirm your solution.

## Task #7: `main`

Finally, update the `main` method to prompt the user  to input room dimensions
and whether to include the ceiling in the paint area calculation.
The method should calculate the total surface area to be painted and the total paint cost,
and then generate a formatted report displaying the results.

Here is a sample execution that includes the ceiling:

```text
Enter the room length, width, and height: 12.5 10.0 9.0
Include ceiling (true/false): 
true
Total area: 530.00 square feet, total cost: $76.85
```

The same room dimensions without the ceiling:

```text
Enter the room length, width, and height: 12.5 10.0 9.0
Include ceiling (true/false): 
false
Total area: 405.00 square feet, total cost: $58.73
```

Run the Junit tests in `MainTest` to confirm your solution.

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
