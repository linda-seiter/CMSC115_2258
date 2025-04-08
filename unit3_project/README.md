# CMSC 115 Unit 3 Programming Projects

### Learning Objectives

4. **Capture and Process User Input**:

   - Implement the `Scanner` class to gather user input, including both integers
     and floating-point numbers, for calculations.

5. **Test Java Code Using JUnit**:
   - Execute JUnit tests to validate program correctness and ensure accurate
     output.

### Introduction

## Task 1 - Chained/Ladder/Multi-way Conditional

The `VehicleTask1` class show allow users to input the mileage of a vehicle in
kilometers. Based on the input mileage, the program will print the corresponding
mileage category:

- **Low mileage:** Less than 50,000 km
- **Moderate mileage:** Between 50,000 (inclusive) km and 100,000 (exclusive) km
- **High mileage:** Between 100,000 (inclusive) km and 150,000 (exclusive) km
- **Very high mileage:** At least 150,000 km

Update the `main` method in the `VehicleTask1` class to implement the following
functionality:

1. Prompt the user to enter the vehicle's mileage in kilometers. Use a Scanner
   to read in the value and store in a variable.
2. Use **ladder/chained/multi-way conditionals** (i.e. if, else-if, ..., else)
   to categorize the mileage into one of the four predefined ranges. You should
   be able to implement this without logical operators (&&, ||, !).
3. Based on the input, output the corresponding category: Low Mileage, Moderate
   Mileage, High Mileage, or Very High Mileage.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Enter r0: <b>2</b><br>
Enter mileage in kilometers: <b>75000</b><br>
Moderate mileage.
</td>
<td>Enter r0: <b>3</b><br>
Enter mileage in kilometers: <b>20000</b><br>
Low mileage.
</td>

</tr>
</table>

Run `VehicleTask1Test` to confirm your solution passes the Junit tests.

- Several tests check the various mileage categories (Low, Moderate, etc.)
- One test checks for the presence of `else if` to ensure you are using the
  ladder conditional structure.
- One test checks to make ensure the code **does not** use logical operators.

## Task 2 - Nested Conditional

The `VehicleTask2` class should ask the user for two inputs: the car's age and
whether it has been in any accidents. Based on the car's age and accident
history, it categorizes the car's condition and provides a recommendation on
whether to buy it:

- Older, with an accident. Avoid buying.
- Older, no accidents. Consider buying.
- Newer, but involved in an accident. Caution advised, think twice.
- Newer, no accidents! Highly recommended to buy.

The term "older" refers to vehicles that are more than 10 years old, while
"newer" refers to vehicles that are 10 years old or younger.

Update the `main` method in the `VehicleTask2` class to implement the following
functionality:

1. Prompt for and read in the vehicle's age (int) and accident status (boolean).
2. Use **nested conditionals** to categorize the response based on the two
   inputs. You should be able to implement this without logical operators (&&,
   ||, !).
3. Based on the input, output the corresponding purchasing recommendation.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Enter the car's age: <b>8</b><br>
Any accidents? (true/false): <b>false</b><br>
Newer, no accidents! Highly recommended to buy.
</td>
<td>Enter the car's age: <b>12</b><br>
Any accidents? (true/false): <b>true</b><br>
Older, with an accident. Avoid buying.
</td>

</tr>
</table>

Run `VehicleTask2Test` to confirm your solution passes the Junit tests.

- Several tests check the various purchasing recommendations based on the age
  and accident status.
- One test checks to make ensure the code **does not** use logical operators.
  You should use nested conditionals to achieve the functionality.

# Task 3 - Switch Expression

The `VehicleTask3` program should ask the user to input the type of vehicle
(e.g., Sedan, SUV, or Truck) and display a corresponding message based on that
type.

The possible vehicle types and their related messages are:

- **Sedan**: Great for commuting.
- **SUV**: Perfect for off-road trips.
- **Truck**: Great for heavy loads.
- **Any other vehicle type**: "Uncommon: [type]"

Update the `main` method in the `VehicleTask3` class to follow these steps:

1. Ask the user for and read in the vehicle type (Sedan, SUV, Truck).
2. Use a **switch expression** to assign one of the four messages listed above
   to the `message` variable, based on the vehicle type. The switch expression
   should have a case for each type (Sedan, SUV, Truck) and a default case for
   any unknown types.
3. Print the message that was assigned by the switch expression.

### Sample Output:

| **Sample Run#1**                                                                          | **Sample Run#2**                                                            |
| ----------------------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| Enter the vehicle type (Sedan, SUV, Truck): **SUV** <br> SUV: Perfect for off-road trips. | Enter the vehicle type (Sedan, SUV, Truck): **Coupe** <br> Uncommon: Coupe. |

Finally, run the `VehicleTask3Test` to check that your solution passes the JUnit
tests.

- Some tests check if the correct message is displayed based on the vehicle
  type.
- One test checks that the code uses a switch expression to assign the value to
  the `message` variable.

## Task 4 - Ternary Operator

The `VehicleTask4` program should ask the user to enter the vehicle's fuel type
(electric, hybrid, gas, or diesel) and its engine size in liters. Based on this
information, the program will classify the vehicle as either eco-friendly or not
eco-friendly.

Here are the rules to determine eco-friendliness:

- If the fuel type is either electric or hybrid and the engine size is **2.0
  liters or less**, the vehicle is considered eco-friendly.
- Otherwise, the vehicle is considered not eco-friendly.

To update the `main` method in the `VehicleTask4` class, follow these steps:

1. Ask the user to input the fuel type and engine size.
2. Use a **ternary operator** to assign a variable named `message` based on the
   fuel type and engine size to determine whether the vehicle is eco-friendly.
   You'll need to use logical operators `&&` and `||` for the condition.
3. Print the message that the ternary operator assigned.

### Tips:

If you're unsure how to write the boolean expression for the ternary operator,
start by using an if/else statement to test with various fuel types and engine
sizes. Once the output is correct, convert the if/else statement into a ternary
operator.

| **Sample Run#1**                                                                                                                                           | **Sample Run#2**                                                                                                                                               |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Enter the fuel type (electric/hybrid/gas/diesel): **hybrid** <br> Enter the engine size in liters (e.g., 2.0 for 2.0L): **1.6** <br> Eco-Friendly vehicle. | Enter the fuel type (electric/hybrid/gas/diesel): **diesel** <br> Enter the engine size in liters (e.g., 2.0 for 2.0L): **1.8** <br> Not eco-friendly vehicle. |

Run `VehicleTask4Test` to confirm that your solution passes the JUnit tests.

- Some tests check if the correct message is displayed based on the fuel type
  and engine size.
- One test checks if the ternary operator is used to assign the `message`
  variable correctly.

## Submitting your project

TBD

<style>
 th, td {
  border: 1px solid black;
  padding: 4px;
  border-collapse: collapse;
  
  }
</style>
