import java.util.Arrays;
import java.util.Scanner;

/**
 * The PTPerformanceAnalyzer program collects and analyzes physical training (PT) performance data,
 * including push-ups and sit-ups. It calculates statistics, evaluates pass/fail status based on minimum thresholds,
 * and outputs a formatted performance summary.
 *
 * Features:
 * - Collects PT data using arrays
 * - Computes max, min, and average statistics
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
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(pushUps));
        System.out.println(Arrays.toString(sitUps));

        // Task 2: Display statistics for each exercise
        System.out.println(calculateAndFormatStatistics(pushUps, "Push-ups"));
        System.out.println(calculateAndFormatStatistics(sitUps, "Sit-ups"));

        // Prompt for minimum exercise thresholds after displaying statistics
        System.out.print("Enter minimum push-ups required: ");
        int minPushUps = scanner.nextInt();
        System.out.print("Enter minimum sit-ups required: ");
        int minSitUps = scanner.nextInt();

        // Task 3: Encode overall performance and print
        System.out.println("--- Encoded Scores ---");
        String[] scoresSummary = evaluateAndSummarizePerformance(names, pushUps, sitUps, minPushUps, minSitUps);
        for (String score : scoresSummary) {
            System.out.println(score);
        }

        scanner.close();
    }

    /**
     * Collects physical training (PT) data by reading names, push-up counts, and sit-up counts
     * from user input. The method uses parallel arrays to store this information.
     *
     * <p>The arrays are assumed to be pre-created with the same size.</p>
     *
     * <p>Data is entered in a single line per trainee in the format:
     * <pre>
     * Name PushUps SitUps
     * </pre>
     * Example input:
     * <pre>
     * Jordan 50 80
     * Morgan 40 60
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
            System.out.print("Enter Name PushUps SitUps:");
            names[i] = scanner.next();      // Read name
            pushUps[i] = scanner.nextInt(); // Read push-ups
            sitUps[i] = scanner.nextInt();  // Read sit-ups
        }

    }

    /**
     * Calculates and formats the statistics (max, min, and average) for a given exercise.
     *
     * @param exerciseScores The array of scores for the exercise (push-ups or sit-ups).
     * @param exerciseName   The name of the exercise being evaluated.
     * @return A formatted string displaying max, min, and average values.
     */
    public static String calculateAndFormatStatistics(int[] exerciseScores, String exerciseName) {
        int max = getMax(exerciseScores);
        int min = getMin(exerciseScores);
        double avg = computeSum(exerciseScores) / (double) exerciseScores.length;

        return String.format("--- %s ---\nMax: %d, Min: %d, Avg: %.2f",
                exerciseName, max, min, avg);
    }

    /**
     * Evaluates soldiers' performance based on minimum push-up and sit-up requirements
     * and returns a summary of pass/fail status.
     *
     * @param names     The array of soldier names.
     * @param pushUps   The array of push-up scores.
     * @param sitUps    The array of sit-up scores.
     * @param minPushUps The minimum required push-ups for passing.
     * @param minSitUps  The minimum required sit-ups for passing.
     * @return A string array summarizing each soldier's performance with pass/fail status.
     */
    public static String[] evaluateAndSummarizePerformance(String[] names, int[] pushUps, int[] sitUps, int minPushUps, int minSitUps) {
        String[] scoresSummary = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String status = (pushUps[i] >= minPushUps && sitUps[i] >= minSitUps) ? "Pass" : "Fail";
            scoresSummary[i] = names[i] + " - Push-ups: " + pushUps[i] + ", Sit-ups: " + sitUps[i] + " - " + status;
        }

        return scoresSummary;
    }

    /**
     * Finds and returns the maximum value in an integer array.
     *
     * @param array The array to evaluate.
     * @return The maximum value found in the array.
     */
    public static int getMax(int[] array) {
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
    public static int getMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Computes and returns the sum of all values in an integer array.
     *
     * @param array The array to sum up.
     * @return The sum of all values in the array.
     */
    public static int computeSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
