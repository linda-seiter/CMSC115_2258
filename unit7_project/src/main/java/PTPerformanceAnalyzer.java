import java.util.Arrays;
import java.util.Scanner;

/**
 * The PTPerformanceAnalyzer program collects and analyzes physical training
 * (PT) performance data,
 * including push-ups and sit-ups. It calculates performance metrics (min, max,
 * mean),
 * evaluates pass/fail status for each individual based on minimum thresholds,
 * and outputs a formatted performance summary.
 *
 * Features:
 * - Collects PT data using arrays
 * - Computes max, min, and mean performance metrics
 * - Evaluates and encodes pass/fail performance based on user-defined
 * thresholds
 *
 * @author Your Name
 * @version 1.0
 */
public class PTPerformanceAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for number of trainees
        System.out.print("Enter the number of trainees: ");
        int numTrainees = scanner.nextInt();
        // Create parallel arrays based on the number of trainees
        String[] names = new String[numTrainees];
        int[] pushUps = new int[numTrainees];
        int[] sitUps = new int[numTrainees];

        // Task 1: Input Data
        // TODO

        // Display the contents of each array
        System.out.println("\nTrainee names, push-ups, sit-ups:");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(pushUps));
        System.out.println(Arrays.toString(sitUps));

        // Task 2: Display performance metrics (min, max, mean) for each exercise
        System.out.println("\nPerformance Metrics:");
        // TODO

        // Task 3: Generate performance summary
        // Task 3a: Prompt for minimum exercise thresholds after displaying metrics
        System.out.println("\nPerformance Summaries:");
        // TODO

        scanner.close();
    }

    /**
     * Collects physical training (PT) data by reading names, push-up counts, and
     * sit-up counts
     * from user input. The method uses parallel arrays to store this information.
     *
     * <p>
     * The arrays are assumed to be instantiated with the same size.
     * </p>
     *
     * <p>
     * Data is entered in a single line per trainee in the format:
     * 
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
     * Calculates and returns the mean value of an integer array.
     *
     * @param array The array to evaluate.
     * @return The mean of all values in the array.
     */
    public static double calculateMean(int[] array) {
        // TODO
        return 0.0;
    }

    /**
     * Computes and returns a formatted description of performance metrics for a
     * given exercise.
     * The description includes the maximum, minimum, and mean scores.
     *
     * @param exerciseScores An array of scores representing performance in a
     *                       specific exercise (e.g., push-ups or sit-ups).
     * @param exerciseName   The name of the exercise being analyzed.
     * @return A formatted string displaying the exercise name, maximum score,
     *         minimum score, and mean score formatted to 2 decimal places
     *         in the format: "*** Exercise *** Max: X, Min: Y, Mean: Z.ZZ".
     */
    public static String getPerformanceMetrics(int[] exerciseScores, String exerciseName) {
        // TODO
        return null;
    }

    /**
     * Creates a performance summary by comparing the number of push-ups and sit-ups
     * completed against the required minimum threshold.
     *
     * @param name       The name of the individual.
     * @param pushUps    The number of push-ups completed.
     * @param sitUps     The number of sit-ups completed.
     * @param minPushUps The minimum required push-ups to pass.
     * @param minSitUps  The minimum required sit-ups to pass.
     * @return A formatted string containing the individual's name, number of
     *         push-ups and sit-ups,
     *         and their pass/fail status based on whether they meet the minimum
     *         requirements.
     */
    public static String getPerformanceSummary(String name, int pushUps, int sitUps, int minPushUps, int minSitUps) {
        // TODO
        return null;
    }

    /**
     * Generates performance summaries for multiple individuals based on their
     * push-up and sit-up scores.
     * Each summary includes the individual's name, exercise counts, and pass/fail
     * status.
     *
     * @param names      An array of individuals' names.
     * @param pushUps    An array of push-up scores corresponding to each
     *                   individual.
     * @param sitUps     An array of sit-up scores corresponding to each individual.
     * @param minPushUps The minimum required push-ups for passing.
     * @param minSitUps  The minimum required sit-ups for passing.
     * @return A string array where each element contains the individual's name,
     *         push-up and sit-up counts,
     *         and pass/fail status formatted as: "Name - Push-ups: X, Sit-ups: Y -
     *         Status".
     */
    public static String[] getPerformanceSummaries(String[] names, int[] pushUps, int[] sitUps, int minPushUps,
            int minSitUps) {
        // TODO
        return null;
    }

}
