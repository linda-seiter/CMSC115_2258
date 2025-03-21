# Unit 7 Project - Physical Training Performance Analyzer

In this lab, you will develop a **PT Performance Analyzer** that collects
and evaluates trainees' physical training (PT) performance.
You will apply modular design principles to break down the program
into reusable methods for data collection, performance analysis,
and overall fitness evaluation.

By the end of this lab, you will:  
✅ Work with **arrays** to store and process trainee data.  
✅ Use **loops and conditionals** to compute overall performance metrics and determine individual performance status.  
✅ Implement **method decomposition** to improve code readability and reusability.  
✅ Format and display structured output using **String.format()** and `Arrays.toString()`.

This lab will strengthen your problem-solving skills and reinforce
best practices in **structured programming**.

## **Learning Outcomes**

### **1. Working with Arrays**
- Apply loops to traverse arrays for data entry, processing, and output generation.
- Populate arrays dynamically based on user input.
- Organize related data in **parallel arrays** for optimized access and manipulation.
- Use conditional logic while iterating through arrays to extract important performance metrics.

### **2. Modular Programming Practices**
- Decompose a program into **independent, reusable methods**.
- Use **method decomposition** to clearly separate different tasks (e.g., input handling, calculations, evaluations).
- Follow the **Single Responsibility Principle (SRP)** to ensure that each method focuses on a single responsibility.

### **3. Breaking Down Problems**
- Divide complex tasks (like performance analysis) into smaller, manageable components:
  - Gathering user input
  - Calculating performance metrics
  - Summarizing individual results
  - Formatting and presenting the output

### **4. Handling User Input**
- Use **Scanner** to capture structured user input.
- Process **integer and string inputs** in a clear and organized format (e.g., "Name PushUps SitUps").

### **5. String Formatting & Output**
- Utilize **formatted strings (`String.format()`)** to create clear and user-friendly outputs.
- Convert arrays into human-readable formats using `Arrays.toString()`.

### **6. Decision Making with Conditional Logic**
- Implement **logical conditions** to assess trainee performance against defined thresholds.

### **7. Code Readability and Documentation**
- Include **Javadoc comments** to clearly document methods and their functionalities.

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

Example I/O** (for arrays of length 3):
```
Enter Name PushUps SitUps: Morgan 50 60  
Enter Name PushUps SitUps: Abel 28 48  
Enter Name PushUps SitUps: Tay 43 45  
```

Resulting array contents:
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
 * Computes and returns a formatted description of overall performance metrics for a given exercise.
 * The description includes the maximum, minimum, and average scores.
 *
 * @param exerciseScores An array of scores representing performance in a specific exercise (e.g., push-ups or sit-ups).
 * @param exerciseName   The name of the exercise being analyzed.
 * @return A formatted string displaying the exercise name, maximum score, minimum score, and average score 
 *         in the format: "*** Exercise *** Max: X, Min: Y, Avg: Z.ZZ".
 */
  public static String getOverallPerformanceMetrics(int[] exerciseScores, String exerciseName)
  }
```

- Implement the method `getOverallPerformanceMetrics` to compute the metrics (min, max, average) for the array passed as a parameter.
  - The `getOverallPerformanceMetrics` method should call the `getMinValue`, `getMaxValue`, and `calculateSum` methods in determining the metrics.  Note you'll have to compute the average using the sum and the array length.  Make sure you avoid integer division!
  - The `getOverallPerformanceMetrics` method should return a formatted string that includes the exercise name and metrics as shown below. The average should be displayed with two digits after the decimal point.
    ```*** Sit-ups *** Max: 50, Min: 20, Avg: 35.00```
- Run the JUnit tests in the `OverallPerformanceMetricsTest` class to verify your solution.

Once the tests pass, update the `main()` method to  call `getOverallPerformanceMetrics` twice, once for calculating the push-ups metrics
and once for calculating the sit-ups metrics.  Print the resulting string returned by each method call.

Sample execution:

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

<details>
  <summary>Task Instructions</summary>

```java
/**
 * Determines whether a person passes or fails based on their push-up and sit-up performance.
 *
 * @param pushUps    The number of push-ups performed.
 * @param sitUps     The number of sit-ups performed.
 * @param minPushUps The minimum required push-ups to pass.
 * @param minSitUps  The minimum required sit-ups to pass.
 * @return "Pass" if both push-ups and sit-ups meet or exceed the minimum requirements, otherwise "Fail".
 */
public static String getPerformanceStatus(int pushUps, int sitUps, int minPushUps, int minSitUps) {
```

- Implement the `getPerformanceStatus` method to return "Pass" if both push-ups and sit-ups meet or exceed the minimum requirements, otherwise "Fail".
- Run the JUnit tests in the `PerformanceStatusTest` class to verify your solution.

```java
/**
 * Generates performance summaries for multiple individuals based on their push-up and sit-up scores.
 * Each summary includes the individual's name, exercise counts, and pass/fail status.
 *
 * @param names      An array of individuals' names.
 * @param pushUps    An array of push-up scores corresponding to each individual.
 * @param sitUps     An array of sit-up scores corresponding to each individual.
 * @param minPushUps The minimum required push-ups for passing.
 * @param minSitUps  The minimum required sit-ups for passing.
 * @return A string array where each element contains the individual's name, push-up and sit-up counts,
 *         and pass/fail status formatted as: "Name - Push-ups: X, Sit-ups: Y - Status".
 */
public static String[] getPerformanceSummaries(String[] names, int[] pushUps, int[] sitUps, int minPushUps, int minSitUps)
```

- Implement the `getPerformanceSummaries` method to return a string array where each element contains the individual's name, push-up and sit-up counts, and pass/fail status formatted as:<br>"Name - Push-ups: X, Sit-ups: Y - Status".
- Run the JUnit tests in the `PerformanceSummariesTest` class to verify your solution.


Once the tests pass, update the `main()` method:
1. Prompt for and read in the minimum push-ups and sit-ups.
2. Call `getPerformanceSummaries`, passing the arrays and minimum values given by the user.
3. Iterate through the resulting array and print each summary.

Sample execution:

```text
Enter the number of trainees: 4
Enter Name PushUps SitUps: Alpha 50 60
Enter Name PushUps SitUps: Beta 40 45
Enter Name PushUps SitUps: Gamma 67 77
Enter Name PushUps SitUps: Delta 35 40
Trainee names, push-ups, sit-ups:
[Alpha, Beta, Gamma, Delta]
[50, 40, 67, 35]
[60, 45, 77, 40]
*** Push-ups *** Max: 67, Min: 35, Avg: 48.00
*** Sit-ups *** Max: 77, Min: 40, Avg: 55.50
Enter minimum push-ups required: 45
Enter minimum sit-ups required: 50
Alpha - Push-ups: 50, Sit-ups: 60 - Pass
Beta - Push-ups: 40, Sit-ups: 45 - Fail
Gamma - Push-ups: 67, Sit-ups: 77 - Pass
Delta - Push-ups: 35, Sit-ups: 40 - Fail
```

Run the Junit tests in `MainTest` to confirm your solution.

Great job on completing this lab! 


</details>

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
