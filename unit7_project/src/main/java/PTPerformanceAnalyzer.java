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

        // Task 3: Generate performance summary
        // Prompt for minimum exercise thresholds after displaying metrics
        System.out.print("Enter minimum push-ups required: ");
        int minPushUps = scanner.nextInt();
        System.out.print("Enter minimum sit-ups required: ");
        int minSitUps = scanner.nextInt();
        // Summarize each trainee's performance and display the result
        String[] scoresSummary = getPerformanceSummaries(names, pushUps, sitUps, minPushUps, minSitUps);
        for (String score : scoresSummary) {
            System.out.println(score);
        }

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
        // TODO

    }

    /**
     * Finds and returns the maximum value in an integer array.
     *
     * @param array The array to evaluate.
     * @return The maximum value found in the array.
     */
    public static int findMaxValue(int[] array) {
        // TODO
        return 0;
    }

    /**
     * Finds and returns the minimum value in an integer array.
     *
     * @param array The array to evaluate.
     * @return The minimum value found in the array.
     */
    public static int findMinValue(int[] array) {
        // TODO
        return 0;
    }

    /**
     * Calculates and returns the sum of all values in an integer array.
     *
     * @param array The array to sum up.
     * @return The sum of all values in the array.
     */
    public static int calculateSum(int[] array) {
        // TODO
        return 0;
    }

    /**
     * Computes and returns a formatted description of overall performance metrics for a given exercise.
     * The description includes the maximum, minimum, and average scores.
     *
     * @param exerciseScores An array of scores representing performance in a specific exercise (e.g., push-ups or sit-ups).
     * @param exerciseName   The name of the exercise being analyzed.
     * @return A formatted string displaying the exercise name, maximum score, minimum score, and average score
     *         in the format: "*** Exercise *** Max: X, Min: Y, Avg: Z.ZZ".
     */
    public static String getOverallPerformanceMetrics(int[] exerciseScores, String exerciseName) {
        // TODO
        return null;
    }

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
        // TODO
        return null;
    }

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
    public static String[] getPerformanceSummaries(String[] names, int[] pushUps, int[] sitUps, int minPushUps, int minSitUps) {
        // TODO
        return null;
    }

}
