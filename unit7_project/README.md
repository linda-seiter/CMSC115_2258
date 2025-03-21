# Unit 7 Project - Physical Training Performance Analyzer

In this lab, you will develop a **PT Performance Analyzer** that collects
and evaluates trainees' physical training (PT) performance.
You will apply modular design principles to break down the program
into reusable methods for data collection, performance analysis,
and overall fitness evaluation.

By the end of this lab, you will:  
✅ Work with **arrays** to store and process trainee data.  
✅ Use **loops and conditionals** to compute performance statistics and determine pass/fail status.  
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
    - Computing performance metrics
    - Summarizing individual performance
    - Formatting and displaying results

### **3. Working with Arrays**
- Store related data in **parallel arrays** for efficient access and processing.
- Compute common statistics for arrays (min, max, and mean).

### **4. User Input Handling**
- Use **Scanner** for reading structured user input.
- Handle **integer and string input** in a structured format (e.g., "Name PushUps SitUps").

### **5. String Formatting & Output**
- Use **formatted strings (`String.format()`)** for clear, user-friendly output.
- Convert arrays into readable formats using `Arrays.toString()`.

### **6. Decision Making & Conditional Logic**
- Implement **logical conditions** to compare trainee performance against thresholds.

### **7. Code Readability & Documentation**
- Write **Javadoc comments** to document methods clearly.

## Guidelines
- Use loops and conditionals instead of advanced Java Streams.
- Use Arrays.toString(), but avoid other methods from the Array or Arrays classes.

## Getting Started: Run the `main()` method with sample user input

You are provided with an initial version of the `PTPerformanceAnalyzer` class.

The `main` method prompts the user for the number of exercise trainees, and creates
3 parallel arrays to store the name, push-up count, and sit-up count for each trainee.
The `Arrays.toString()` method is called to print the contents of each array, showing the default value `null` or `0` based on the data type.

Execute the `main()` method with a sample size of 3 and confirm the output:

```text
Enter the number of trainees: 3
Trainee names, push-ups, sit-ups:
[null, null, null]
[0, 0, 0]
[0, 0, 0]
```

## Task 1: Collect PT Data from user input

<details>
  <summary>Task Instructions</summary>

```java
    /**
     * Collects physical training (PT) data by reading names, push-up counts, and sit-up counts
     * from user input. The method uses parallel arrays to store this information.
     *
     * <p>The arrays are assumed to be instantiated with the same size.</p>
     *
     * <p>Data is entered in a single line per trainee in the format:
     * <pre>
     * Name PushUps SitUps
     * </pre>
     *
     * @param scanner The Scanner object used to read input.
     * @param names   The pre-created array to store the names.
     * @param pushUps The pre-created array to store push-up counts.
     * @param sitUps  The pre-created array to store sit-up counts.
     */
    public static void collectExerciseData(Scanner scanner, String[] names, int[] pushUps, int[] sitUps)
```

Implement the `collectExerciseData` method to collect trainees' physical
training (PT) data from user input. This method will prompt for and read names,
push-up counts, and sit-up counts and store them in parallel arrays.

You can assume that the `Scanner` parameter is not null and reads from `System.in`, and the arrays are not null and have the same length.

Use a loop to repeatedly prompt the user for input (name, push-ups, and sit-ups), then store the values in the `names`, `pushUps`, and `sitUps` arrays.

### **Example Execution** (for arrays of length 3):
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

Once the tests pass, update the `main()` method to  call `collectExerciseData` after
the arrays have been created for the specified input size.
Run the program to confirm the arrays are filled with the user input and their contents printed.

```text
Enter the number of trainees: 4
Enter Name PushUps SitUps: Nel 42 50
Enter Name PushUps SitUps: Lana 30 38
Enter Name PushUps SitUps: Zelish 28 34
Enter Name PushUps SitUps: Telaza 50 60
Trainee names, push-ups, sit-ups:
[Nel, Lana, Zelish, Telaza]
[42, 30, 28, 50]
[50, 38, 34, 60]
```

</details>

## Task 2: Compute Overall Performance Metrics

<details>
  <summary>Task Instructions</summary>

```java
/**
* Finds and returns the maximum value in an integer array.
*
* @param array The array to evaluate.
* @return The maximum value found in the array.
*/
public static int findMaxValue(int[] array) 


/**
* Finds and returns the minimum value in an integer array.
*
* @param array The array to evaluate.
* @return The minimum value found in the array.
*/
public static int findMinValue(int[] array) 

/**
* Calculates and returns the sum of all values in an integer array.
*
* @param array The array to sum up.
* @return The sum of all values in the array.
*/
public static int calculateSum(int[] array) 
```

- Implement the methods `findMaxValue`, `findMinValue`, and `calculateSum` to
return the highest value, lowest value, and total sum of the elements
in the given array.
- Run the JUnit tests in the `MetricsTest` class to verify your solution.

```java
  /**
   * Evaluates and formats the performance metrics (max, min, and average) for a given exercise.
   *
   * @param exerciseScores The array of scores for the exercise (push-ups or sit-ups).
   * @param exerciseName   The name of the exercise being analyzed.
   * @return A formatted string displaying max, min, and average, with average rounded to two decimal places,
   */
  public static String getOverallPerformanceMetrics(int[] exerciseScores, String exerciseName)
  }
```

- Implement the method `getOverallPerformanceMetrics` to compute the metrics (min, max, average) for the array passed as a parameter.
  - The `getOverallPerformanceMetrics` method should call the `getMinValue`, `getMaxValue`, and `calculateSum` methods in determining the metrics.  Note you'll have to compute the average using the sum and the array length.  Make sure you avoid integer division!
  - The `getOverallPerformanceMetrics` method should return a formatted string that includes the exercise name and metrics. The average should be displayed with two digits after the decimal point. For example:
    ```*** Sit-ups *** Max: 50, Min: 20, Avg: 35.00```
- Run the JUnit tests in the `OverallPerformanceMetricsTest` class to verify your solution.

For example:
```java
int[] squatsScores = {20, 35, 40, 50, 30};
String result = getOverallPerformanceMetrics(squatsScores, "Squats");  
System.out.println(result);
```

Expected output:

```text
*** Squats *** Max: 50, Min: 20, Avg: 35.00
```

Once the tests pass, update the `main()` method to  call `getOverallPerformanceMetrics` twice, once for calculating the push-ups metrics
and once for calculating the sit-ups metrics.  Print the resulting string returned by each method call.

Run the program to confirm the overall performance metrics are calculated and printed for some sample data.

```text
Enter the number of trainees: 3
Enter Name PushUps SitUps: Alpha 50 60
Enter Name PushUps SitUps: Beta 42 56
Enter Name PushUps SitUps: Gamma 48 39
Trainee names, push-ups, sit-ups:
[Alpha, Beta, Gamma]
[50, 42, 48]
[60, 56, 39]
*** Push-ups *** Max: 50, Min: 42, Avg: 46.67
*** Sit-ups *** Max: 60, Min: 39, Avg: 51.67
```

</details>

## Task 3: Compute and Display Performance Report

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
