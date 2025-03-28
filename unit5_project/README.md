# Unit 5 Project - RoomPaintingCostCalculator

### Introduction 

The `RoomPaintingCostCalculator` application calculates the total area
of the walls and ceiling of a room and estimates the cost of paint
required to cover those surfaces. The user inputs the room's dimensions
(length, width, and height) and can specify whether the ceiling should
be included in the area calculation. The program uses predefined constants
for paint coverage and price per gallon to calculate the amount of paint needed
and its total cost.

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

Here’s the refined list with consistent outcome titles:

Here’s the updated version with a focus on the **Single Responsibility Principle**:

The content you've provided is already well-structured and clear. However, I have a few suggestions to improve readability and conciseness:

1. **Design and Implement Modular Methods**:
    - Design and implement modular, reusable methods that perform specific tasks to reduce code redundancy.
    - Assign a single responsibility to each method, ensuring it focuses on one task. This enhances code clarity, maintainability, and testability.
    - Utilize static methods for utility functions, improving code efficiency, readability, and minimizing duplication.
    - Structure the program to clearly separate concerns (such as calculations, validations, and user interaction), following the **Single Responsibility Principle**. This makes the code easier to debug and extend.

2. **Pass Parameters, Use Local Variables, and Handle Return Values**:
    - Pass values into methods using parameters.
    - Store intermediate results in local variables within methods.
    - Validate parameters to ensure methods operate with valid data, enhancing program reliability.
    - Return values from methods to pass data out.
    - Encourage method composition by passing values returned from one method as parameters to another, simplifying complex tasks and reducing overall complexity.

3. **Debug and Comprehend the Call Stack**:
    - Debug a Java program to track the flow of execution through methods via the call stack.
    - Use debugging techniques to trace variable values and resolve issues related to variable scope and method calls.
    - Observe how method calls are added to and removed from the stack, and how parameters and local variables are managed during execution.

4. **Validate Input and Handle Errors**:
    - Implement methods for input validation to handle invalid data gracefully, ensuring robust, error-free execution.

5. **Generate and Format Output**:
    - Use string formatting to present results clearly and in a user-friendly manner, ensuring that the output is easy to understand.


## Coding Guidelines

- You may use loops and conditionals, but avoid using advanced Java Streams.

## Getting Started:



## Task #1: 



## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
