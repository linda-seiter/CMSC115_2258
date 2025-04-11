# CMSC 115 Unit 2 Programming Projects

NOTE: Possibly remove transmission rate task if Math.pow not covered in unit 2.

### Learning Outcomes

1. **Perform Mathematical Calculations**:

   - Apply arithmetic operations like addition, subtraction, multiplication, and
     division to solve real-world problems.

2. **Perform Type Casting and Rounding**:

   - Use type casting to convert between data types (e.g., `double` to `int`)
     and apply rounding techniques to format numeric outputs.

3. **Capture and Process User Input**:

   - Implement the `Scanner` class to gather user input, including both integers
     and floating-point numbers, for calculations.

4. **Format and Display Output**:

   - Format numerical results for clear and precise output, such as rounding to
     a specified number of decimal places.

5. **Test Java Code Using JUnit**:
   - Run JUnit tests to verify the program's output.
   - Run JUnit tests to ensure specific operators are used correctly in the
     code.

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

## Task 1 - SeafoodMarket

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
5. Run `SeafoodMarketTest` to confirm your solution passes the JUnit tests.

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

# Task 2 - NearestInt

**Objective**: Demonstrate how to convert a fraction into a double and round it
to the nearest integer, including handling negative values.

Update the `main` method in the `NearestInt` class to implement the following
functionality:

1. Declare and initialize a `Scanner` to read input from the console.
2. Prompt for and read two ints: a numerator and a denominator.
3. Print the numeric conversions displayed in the sample runs.<br>Hint: add 0.5
   when rounding to nearest positive int, and subtract 0.5 when rounding to the
   nearest negative int.
4. Run `NearestIntTest` to confirm your solution passes the JUnit tests.

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

## Task 3 - BasketBallGame

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

Run `BasketballGameTest` to confirm your solution passes the JUnit tests.

## Submitting your project

TBD

<style>
 th, td {
  border: 1px solid black;
  padding: 4px;
  border-collapse: collapse;
  
  }
</style>
