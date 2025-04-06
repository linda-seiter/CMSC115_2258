# CMSC 115 Unit 2 Programming Projects

### Learning Objectives

1. **Perform Mathematical Calculations**:

   - Apply arithmetic operations like addition, subtraction, multiplication, and
     division to solve real-world problems.

2. **Use Java Math Methods**:

   - Utilize built-in Java methods like `Math.pow()` and `Math.sqrt()` to handle
     more advanced mathematical operations.

3. **Perform Type Casting and Rounding**:

   - Use type casting to convert between data types (e.g., `double` to `int`)
     and apply rounding techniques to format numeric outputs.

4. **Capture and Process User Input**:

   - Implement the `Scanner` class to gather user input, including both integers
     and floating-point numbers, for calculations.

5. **Format and Display Output**:

   - Format numerical results for clear and precise output, such as rounding to
     a specified number of decimal places.

6. **Test Java Code Using JUnit**:
   - Execute JUnit tests to validate program correctness and ensure accurate
     output.

### Introduction

In this unit's programming assignment, you will complete several tasks that
involve practical Java programming concepts such as mathematical operations,
input/output handling, and working with variables. These tasks are designed to
improve your understanding of Java fundamentals and enhance your problem-solving
abilities.

The tasks will also help you apply mathematical functions and work with both
integer and floating-point numbers in real-world scenarios. By the end of this
assignment, you will have experience in implementing basic calculations,
formatting output, and running unit tests to verify your solutions.

## Task 1 - TransmissionRate

**Objective**: Simulate the spread of a virus using the concept of the
transmission rate (R₀) and calculate the number of new cases after several
iterations.

R<sub>0</sub> (pronounced R-naught) is a number that refers to the transmission
rate of a given virus. If R<sub>0</sub> is 5, then 1 person is capable of
spreading on average to 5 other people within a susceptible population.

The table below shows the number of new cases after various iterations of viral
spread:

<table>
<tr>
<th>R0</th>
<th>Iteration 1</th>
<th>Iteration 2</th>
<th>Iteration 3</th>
<th>Iteration 4</th>
</tr>

<tr>
<td>Common Cold: 2</td>
<td>2</td>
<td>4</td>
<td>8</td>
<td>16</td>
</tr>

<tr>
<td>1918 Flu: 3</td>
<td>3</td>
<td>9</td>
<td>27</td>
<td>81</td>
</tr>

<tr>
<td>Chickenpox: 10</td>
<td>10</td>
<td>100</td>
<td>1000</td>
<td>10000</td>
</tr>

</table>

Update the `main` method in the `TransmissionRate` class to implement the
following functionality:

1. Declare and initialize a `Scanner` to read input from the console.
2. Prompt for and read the transmission rate R<sub>0</sub> as an integer,
   storing the value in a variable named `r0`.
3. Call `Math.pow` to calculate the potential new cases at the 4th iteration
   based on the given R<sub>0</sub> value. Use casting to convert the `double`
   value returned from `Math.pow` to an `int`, and store the result in an int
   variable named `newCases`.
4. Print the number of new cases as shown in the sample runs.
5. Run `TransmissionRateTest` to confirm your solution passes the Junit tests.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Enter r0: <b>2</b><br>
New cases on 4th iteration: 16
</td>
<td>Enter r0: <b>18</b><br>
New cases on 4th iteration: 104976
</td>

</tr>
</table>

## Task 2 - SeafoodMarket

**Objective**: Calculate the total cost of fish purchased based on the weight
and price per pound, rounding the total to two decimal places.

Update the `main` method in the `SeafoodMarket` class to implement the following
functionality:

1. Declare and initialize a `Scanner` to read input from the console.
2. Prompt for and read two doubles: (1) pounds of fish and (2) price per pound.
3. Calculate the total cost as a double, rounding the value to 2 digits after
   the decimal point. Make sure you avoid integer division!
4. Print the pounds, price per pound, and total cost as shown in the sample runs
   below.
5. Run `SeafoodMarketTest` to confirm your solution passes the Junit tests.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Enter pounds of fish and price per pound: <b>5 8.99</b><br>
5.0 lbs at $8.99 per lb = $44.95
</td>
<td>Enter pounds of fish and price per pound: <b>3.25 15.99</b><br>
3.25 lbs at $15.99 per lb = $51.97
</td>

</tr>
</table>

# Task 3 - NearestInt

**Objective**: Demonstrate how to convert a fraction into a double and round it
to the nearest integer, including handling negative values.

Update the `main` method in the `NearestInt` class to implement the following
functionality:

1. Declare and initialize a `Scanner` to read input from the console.
2. Prompt for and read two ints: a numerator and a denominator.
3. Print the numeric conversions displayed in the sample runs.<br>Hint: add 0.5
   when rounding to nearest positive int, and subtract 0.5 when rounding to the
   nearest negative int.
4. Run `NearestIntTest` to confirm your solution passes the Junit tests.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Enter numerator and denominator: <b>19 4</b><br>
Fraction: 19/4<br>
Double Value: 4.75<br>
Cast as Int: 4<br>
Rounded to nearest int: 5<br>
Negative Value: -4.75<br>
Negative Value rounded to nearest int: -5
</td>
<td>Enter numerator and denominator: <b>11 8</b><br>
Fraction: 11/8<br>
Double Value: 1.375<br>
Cast as Int: 1<br>
Rounded to nearest int: 1<br>
Negative Value: -1.375<br>
Negative Value rounded to nearest int: -1<br>
</td>

</tr>
</table>

## Task 4 - BasketBallGame

**Objective**: Simulate the progression of a basketball game by updating scores
after each quarter based on specific instructions.

The `main` method in the `BasketBallGame` class prompts for the home and away
scores for the first quarter, initializes variables to store each team's score,
and prints the scores for the 1st quarter.

Your task is to update the code for the 2nd, 3rd, and 4th quarters based on the
instructions given in the comments.

<table>
<tr>
<th>Sample Run#1</th>
<th>Sample Run#2</th>
</tr>
<tr>
<td>Home and away points for 1st quarter: <b>25 20</b><br>
1st quarter scores: home 25 away 20<br>
2nd quarter scores: home 50 away 50<br>
After challenge: home 47 away 50<br>
3rd quarter scores: home 57 away 62<br>
After challenge: home 58 away 62<br>
4th quarter scores: home 82 away 81
</td>
<td>
Home and away points for 1st quarter: <b>30 22</b><br>
1st quarter scores: home 30 away 22<br>
2nd quarter scores: home 60 away 60<br>
After challenge: home 57 away 60<br>
3rd quarter scores: home 67 away 72<br>
After challenge: home 68 away 72<br>
4th quarter scores: home 97 away 96<br>
</td>
</tr>
</table>

Run `BasketballGameTest` to confirm your solution passes the Junit tests.

## Submitting your project

TBD

<style>
 th, td {
  border: 1px solid black;
  padding: 4px;
  border-collapse: collapse;
  
  }
</style>
