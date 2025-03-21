# Unit 7 Project - Physical Training Performance Analyzer

In this lab, you will develop a **PT Performance Analyzer** that collects
and evaluates trainees' physical training (PT) performance. You will
apply **modular design** principles to break down the program into
reusable methods for data collection, statistical analysis, and
performance evaluation.

By the end of this lab, you will:  
✅ Work with **arrays** to store and process trainee data.  
✅ Use **loops and conditionals** to compute statistics and determine pass/fail status.  
✅ Implement **method decomposition** to improve code readability and reusability.  
✅ Format and display structured output using **String.format()** and `Arrays.toString()`.

This lab will strengthen your problem-solving skills and reinforce
best practices in **structured programming**.

## **Learning Objectives**

### **1. Modular Design**
- Understand how to break down a program into **independent, reusable methods**.
- Use **method decomposition** to separate concerns (e.g., input collection, calculations, evaluation).
- Follow **single responsibility principle (SRP)** by ensuring each method handles only one task.

### **2. Problem Decomposition**
- Divide a complex task (PT performance analysis) into smaller, manageable steps:
    - Collecting user input
    - Computing statistics
    - Evaluating pass/fail status
    - Formatting and displaying results

### **3. Working with Arrays**
- Store related data in **parallel arrays** for efficient access and processing.
- Compute common statistics for arrays (min, max, and sum).

### **4. User Input Handling**
- Use **Scanner** for reading structured user input.
- Handle **integer and string input** in a structured format (e.g., "Name PushUps SitUps").

### **5. String Formatting & Output**
- Use **formatted strings (`String.format()`)** for clear, user-friendly output.
- Convert arrays into readable formats using `Arrays.toString()`.

### **6. Decision Making & Conditional Logic**
- Use **if-else statements and ternary operators** for evaluating pass/fail criteria.
- Implement **logical conditions** to compare trainee performance against thresholds.

### **7. Code Readability & Documentation**
- Write **Javadoc comments** to document methods clearly.
- Follow **consistent naming conventions** for variables and methods.

## Guidelines
- Utilize Scanner for user input.
- Use basic loops and conditionals instead of advanced Java Streams.
- You may use the Arrays.toString() method, but avoid other methods from the Array or Arrays classes.

## Getting Started: Run the `main()` method with sample user input

You are provided with an initial version of the `PTPerformanceAnalyzer` class.

The `main` method prompts the user for the number of exercise trainees, and creates
3 parallel arrays to store the name, push-up count, and sit-up count for each trainee.
The `Arrays.toString()` method is called to print the contents of each array, showing the default value `null` or `0` based on the data type.

Execute the `main()` method with a sample size of 5 and confirm the output:

```text
Enter the number of trainees: 5
[null, null, null, null, null]
[0, 0, 0, 0, 0]
[0, 0, 0, 0, 0]
```

## Task 1: Collect PT Data from user input

<details>
  <summary>Task Instructions</summary>

Implement the `collectExerciseData` method to collect trainees' physical
training (PT) data using **Scanner**. This method will read names,
push-up counts, and sit-up counts and store them in parallel arrays.

## **Method Signature**
```java
public static void collectExerciseData(Scanner scanner, String[] names, int[] pushUps, int[] sitUps)
```
### **Parameters:**
- `scanner` – A `Scanner` object to read user input.
- `names` – An array to store trainees' names.
- `pushUps` – An array to store push-up counts.
- `sitUps` – An array to store sit-up counts.

You can assume that a `Scanner` object has already been created to read from `System.in`, and the arrays are initialized with the same length.

Use a loop to repeatedly prompt the user for input (name, push-ups, and sit-ups), then store the values in the `names`, `pushUps`, and `sitUps` arrays.

### **Example Execution** (for arrays of size 3):
```
Enter Name PushUps SitUps: Morgan 50 60  
Enter Name PushUps SitUps: Abel 28 48  
Enter Name PushUps SitUps: Tay 43 45  
```

### **Stored Data:**
```java
names = {"Morgan", "Abel", "Tay"};
pushUps = {50, 28, 43};
sitUps = {60, 48, 45};
```

Run the JUnit tests in the `CollectDataTest` class to verify your solution.

Once the tests pass, update the `main()` method to  call `collectExerciseData` after the arrays have been created using the specified input size.
Run the program to confirm the arrays are filled with the user input and their contents printed.

```text
Enter the number of trainees: 4
Enter Name PushUps SitUps: Nel 42 50
Enter Name PushUps SitUps: Lana 30 38
Enter Name PushUps SitUps: Zelish 28 34
Enter Name PushUps SitUps: Telaza 50 60
[Nel, Lana, Zelish, Telaza]
[42, 30, 28, 50]
[50, 38, 34, 60]
```

</details>

## Task 2: Compute and Display Statistics

## Task 3: Compute and Display Performance Report

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
