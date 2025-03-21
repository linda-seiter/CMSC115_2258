import java.util.Arrays;
import java.util.Scanner;

/**
 * The PTPerformanceAnalyzer program collects and analyzes physical training (PT) performance data,
 * including push-ups and sit-ups. It calculates performance metrics, evaluates pass/fail status based on minimum thresholds,
 * and outputs a formatted performance summary.
 *
 * Features:
 * - Collects PT data using arrays
 * - Computes max, min, and average performance metrics
 * - Evaluates and encodes pass/fail performance based on user-defined thresholds
 *
 * @author Your Name
 * @version 1.0
 */
public class PTPerformanceAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for number of soldiers
        System.out.print("Enter the number of trainees: ");
        int numTrainees = scanner.nextInt();
        // Create parallel arrays based on the number of trainees
        String[] names = new String[numTrainees];
        int[] pushUps = new int[numTrainees];
        int[] sitUps = new int[numTrainees];

        // Task 1: Input Data (one-line entry)
        collectExerciseData(scanner, names, pushUps, sitUps);

        // Display the contents of each array
        System.out.println("Trainee names, push-ups, sit-ups:");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(pushUps));
        System.out.println(Arrays.toString(sitUps));

        // Task 2: Display overall performance metrics (min, max, average) for each exercise
        System.out.println(getOverallPerformanceMetrics(pushUps, "Push-ups"));
        System.out.println(getOverallPerformanceMetrics(sitUps, "Sit-ups"));
//
//        // Task 3: Generate performance summary
//        // Prompt for minimum exercise thresholds after displaying metrics
//        System.out.print("Enter minimum push-ups required: ");
//        int minPushUps = scanner.nextInt();
//        System.out.print("Enter minimum sit-ups required: ");
//        int minSitUps = scanner.nextInt();
//        // Summarize each trainee's performance and display the result
//        System.out.println("--- Performance Summary ---");
//        String[] scoresSummary = evaluateAndSummarizePerformance(names, pushUps, sitUps, minPushUps, minSitUps);
//        for (String score : scoresSummary) {
//            System.out.println(score);
//        }

        scanner.close();
    }

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
    public static void collectExerciseData(Scanner scanner, String[] names, int[] pushUps, int[] sitUps) {
        // Input Data (one-line entry)
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter Name PushUps SitUps: ");
            names[i] = scanner.next();      // Read name
            pushUps[i] = scanner.nextInt(); // Read push-ups
            sitUps[i] = scanner.nextInt();  // Read sit-ups
        }

    }

    /**
     * Finds and returns the maximum value in an integer array.
     *
     * @param array The array to evaluate.
     * @return The maximum value found in the array.
     */
    public static int findMaxValue(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Finds and returns the minimum value in an integer array.
     *
     * @param array The array to evaluate.
     * @return The minimum value found in the array.
     */
    public static int findMinValue(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Calculates and returns the sum of all values in an integer array.
     *
     * @param array The array to sum up.
     * @return The sum of all values in the array.
     */
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    /**
     * Evaluates and formats the performance metrics (max, min, and average) for a given exercise.
     *
     * @param exerciseScores The array of scores for the exercise (push-ups or sit-ups).
     * @param exerciseName   The name of the exercise being analyzed.
     * @return A formatted string displaying max, min, and average, with average rounded to two decimal places,
     */
    public static String getOverallPerformanceMetrics(int[] exerciseScores, String exerciseName) {
        int max = findMaxValue(exerciseScores);
        int min = findMinValue(exerciseScores);
        double avg = calculateSum(exerciseScores) / (double) exerciseScores.length;

        return String.format("*** %s *** Max: %d, Min: %d, Avg: %.2f",
                exerciseName, max, min, avg);
    }

    /**
     * Evaluates soldiers' performance based on minimum push-up and sit-up requirements
     * and returns a summary including pass/fail status.
     *
     * @param names     The array of soldier names.
     * @param pushUps   The array of push-up scores.
     * @param sitUps    The array of sit-up scores.
     * @param minPushUps The minimum required push-ups for passing.
     * @param minSitUps  The minimum required sit-ups for passing.
     * @return A string array summarizing each soldier's performance with pass/fail status.
     */
    public static String[] generatePerformanceSummaries(String[] names, int[] pushUps, int[] sitUps, int minPushUps, int minSitUps) {
        String[] scoresSummary = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String status = evaluateStatus(pushUps[i], sitUps[i], minPushUps, minSitUps);
            scoresSummary[i] = String.format("%s - Push-ups: %d, Sit-ups: %d - %s",
                    names[i], pushUps[i], sitUps[i], status);
        }
        return scoresSummary;
    }

    /**
     * Evaluates whether a person passes or fails based on their push-ups and sit-ups count.
     *
     * @param pushUps    The number of push-ups performed.
     * @param sitUps     The number of sit-ups performed.
     * @param minPushUps The minimum required push-ups to pass.
     * @param minSitUps  The minimum required sit-ups to pass.
     * @return "Pass" if both push-ups and sit-ups meet or exceed the minimum requirements, otherwise "Fail".
     */
    public static String evaluateStatus(int pushUps, int sitUps, int minPushUps, int minSitUps) {
        return (pushUps >= minPushUps && sitUps >= minSitUps) ? "Pass" : "Fail";
    }

}
