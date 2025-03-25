# Unit 6 Project - Physical Training Performance Analyzer

In this lab, you will develop a **PT Performance Analyzer** that collects
and evaluates trainees' physical training (PT) performance.
You will apply modular design principles to break down the program
into reusable methods for data collection, overall performance analysis,
and individual fitness evaluation.

## **Learning Outcomes**

### **1. Working with Arrays**
- Utilize loops to iterate through arrays for data input, processing, and output generation.
- Dynamically fill arrays based on user input.
- Maintain related data using **parallel arrays**.
- Construct an array dynamically by applying conditional logic to data from other arrays.

### **2. Breaking Down Problems**
- Divide complex tasks (like performance analysis) into smaller, manageable components:
  - Gathering user input
  - Calculating performance metrics
  - Summarizing individual results
  - Formatting and presenting the output

### **3. Modular Programming Practices**
- Decompose a program into **independent, reusable methods**.
- Use **method decomposition** to clearly separate different tasks (e.g., input handling, calculations, evaluations).
- Follow the **Single Responsibility Principle (SRP)** to ensure that each method focuses on a single responsibility.

### **4. Handling User Input**
- Use **Scanner** to capture structured user input.
- Process **integer and string inputs** in a clear and organized format (e.g., "Name PushUps SitUps").

### **5. String Formatting & Output**
- Utilize **formatted strings (`String.format()`)** to create clear and user-friendly outputs.
- Convert arrays into human-readable formats using `Arrays.toString()`.

### **6. Decision-Making with Conditional Logic**
- Implement **logical conditions** to assess trainee performance against defined thresholds.

### **7. Code Readability and Documentation**
- Include **Javadoc comments** to clearly document methods and their functionalities.

## Coding Guidelines

- Loops and conditionals are allowed, but avoid using advanced Java Streams.
- You may use `Arrays.toString()`, but do not use other methods from the `Array` or `Arrays` classes.

## Getting Started: Run the `main()` method with sample user input

You are provided with an initial version of the `PTPerformanceAnalyzer` class.

The `main` method prompts the user for the number of exercise trainees, and creates
3 parallel arrays to store the name, push-up count, and sit-up count for each trainee.
The `Arrays.toString()` method is called to print the contents of each array, showing the default value `null` or `0` based on the data type.

Execute the `main()` method with a sample size of 7 and confirm the output:

```text
Enter the number of trainees: 7

Trainee names, push-ups, sit-ups:
[null, null, null, null, null, null, null]
[0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0]

Performance Metrics:

Performance Summaries:
```

## Task 1: Collect PT Data from user input

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

Sample I/O, assuming the `names` array has length 3:

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
the arrays have been created for the specified input size, but before the print statements that display their content.
Run the program to confirm the arrays are filled with the user input and their contents printed.

Sample I/O:

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

Performance Metrics:

Performance Summaries:
```

## Task 2: Compute Performance Metrics

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
 * Calculates and returns the mean value of an integer array.
 *
 * @param array The array to evaluate.
 * @return The mean of all values in the array.
 */
public static double calculateMean(int[] array) 
```

- Implement the methods `findMaxValue`, `findMinValue`, and `calculateMean` to determine the highest value, lowest value, and average of the elements in the given array.m
- The mean is computed by summing all elements in the array and dividing by the total number of elements. **Ensure** that integer division is avoided so the result is accurately returned as a `double`.
- Execute the JUnit tests in the `MetricsTest` class to validate your implementation.

```java
/**
 * Computes and returns a formatted description of performance metrics for a given exercise.
 * The description includes the maximum, minimum, and mean scores.
 *
 * @param exerciseScores An array of scores representing performance in a specific exercise (e.g., push-ups or sit-ups).
 * @param exerciseName   The name of the exercise being analyzed.
 * @return A formatted string displaying the exercise name, maximum score, minimum score, and mean score formatted to 2 decimal places
 *         in the format: "*** Exercise *** Max: X, Min: Y, Mean: Z.ZZ".
 */
  public static String getPerformanceMetrics(int[] exerciseScores, String exerciseName)
  }
```

Implement the `getPerformanceMetrics` method to calculate three key metrics (minimum, maximum, and mean) for the provided array.

- This method should call `getMinValue`, `getMaxValue`, and `calculateMean` to determine the respective metrics.
- It should return a formatted string displaying the exercise name along with the computed metrics, formatted as follows, with the mean rounded to two decimal places:
  ```  
  *** Sit-ups *** Max: 50, Min: 20, Mean: 35.25  
  ```  

Next, run the JUnit tests in the `PerformanceMetricsTest` class to validate your implementation.

Once all tests pass, update the `main()` method. After gathering and displaying the trainee's data, modify `main` to call `getPerformanceMetrics` twice—once for push-up metrics and once for sit-up metrics—then print each result.

Sample I/O:

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

Performance Metrics:
*** Push-ups *** Max: 67, Min: 35, Mean: 48.00
*** Sit-ups *** Max: 77, Min: 40, Mean: 55.50

Performance Summaries:
```

## Task 3: Compute and Display Performance Summaries

```java
/**
 * Creates a performance summary by comparing the number of push-ups and sit-ups completed against the required minimum threshold.
 *
 * @param name       The name of the individual.
 * @param pushUps    The number of push-ups completed.
 * @param sitUps     The number of sit-ups completed.
 * @param minPushUps The minimum required push-ups to pass.
 * @param minSitUps  The minimum required sit-ups to pass.
 * @return A formatted string containing the individual's name, number of push-ups and sit-ups,
 *         and their pass/fail status based on whether they meet the minimum requirements.
 */
public static String getPerformanceSummary(String name, int pushUps, int sitUps, int minPushUps, int minSitUps)
```

Implement the `getPerformanceSummary` method to evaluate an individual's fitness performance based on push-ups and sit-ups. The method should:
  - Take the individual's name, number of push-ups, and sit-ups, and minimum push-ups and sit-ups as parameters.
  - Compare their performance against the minimum required push-ups **and** sit-ups to determine Pass/Fail status. Both thresholds must be met to pass.
  - Return a formatted string indicating their name, the number of push-ups and sit-ups performed, and their Pass/Fail status formatted as shown:
    <br>"Name - Push-ups: X, Sit-ups: Y - Status"

| **Method Call**  | **Expected Output** |
|------------------|----------------------|
| `getPerformanceSummary("Alpha", 20, 30, 15, 25)`  | `Alpha - Push-ups: 20, Sit-ups: 30 - Pass` |
| `getPerformanceSummary("Beta", 10, 30, 15, 25)`    | `Beta - Push-ups: 10, Sit-ups: 30 - Fail` |
| `getPerformanceSummary("Gamma", 15, 20, 15, 25)`| `Gamma - Push-ups: 15, Sit-ups: 20 - Fail` |
| `getPerformanceSummary("Delta", 15, 25, 15, 25)`   | `Delta - Push-ups: 15, Sit-ups: 25 - Pass` |

Run the Junit tests in `PerformanceSummaryTest` to confirm your solution.

```java
/**
 * Generates performance summaries for multiple individuals based on their push-up and sit-up scores.
 * Each summary includes the individual's name, push-up and sit-up counts, and Pass/Fail status.
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

Implement the `getPerformanceSummaries` method to generate and return a new string array, where each element holds a performance summary produced by the `getPerformanceSummary` method.

The method should:
1. Initialize a new `String` array to store the performance summaries.
2. Iterate through the input data, calling `getPerformanceSummary` for each trainee and saving the result in the array.
3. Return the populated array.

For example, given this call to `getPerformanceSummaries`:
```java
String[] names = {"A", "B", "C", "D"};
int[] pushUps = {20, 10, 15, 18};
int[] sitUps = {30, 25, 20, 25};
int minPushUps = 15;
int minSitUps = 25;
String[] results = getPerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);
```

The `results` array should contain the four strings as shown:
```java
{
    "A - Push-ups: 20, Sit-ups: 30 - Pass",
    "B - Push-ups: 10, Sit-ups: 25 - Fail",
    "C - Push-ups: 15, Sit-ups: 20 - Fail",
    "D - Push-ups: 18, Sit-ups: 25 - Pass"
}
```

Run the JUnit tests in the `PerformanceSummariesTest` class to verify your solution.

Once the tests pass, update the `main()` method. After displaying the push-ups and sit-ups metrics,
the `main` method should:

1. Prompt for and read in minimum push-up and sit-up requirements.
2. Call `getPerformanceSummaries`, passing the arrays and minimum thresholds specified by the user.
3. Iterate through the array returned by `getPerformanceSummaries` and print each summary.

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

Performance Metrics:
*** Push-ups *** Max: 67, Min: 35, Mean: 48.00
*** Sit-ups *** Max: 77, Min: 40, Mean: 55.50

Performance Summaries:
Enter minimum push-ups required: 50
Enter minimum sit-ups required: 60
Alpha - Push-ups: 50, Sit-ups: 60 - Pass
Beta - Push-ups: 40, Sit-ups: 45 - Fail
Gamma - Push-ups: 67, Sit-ups: 77 - Pass
Delta - Push-ups: 35, Sit-ups: 40 - Fail
```

Run the Junit tests in `MainTest` to confirm your solution.

## Submission Instructions

TBD

## Resources

- [Resource Link 1](example.com)
- [Resource Link 2](example.com)
