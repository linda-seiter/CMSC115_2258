import java.util.Scanner;

/**
 * The SalesAssistant class simulates a sales assistant that
 * helps users track daily sales and provides feedback on their progress toward
 * a specified sales target.
 * The program prompts users to input their sales target and the number of days
 * for tracking, then calculates cumulative sales, average daily sales, and
 * predicts the total sales by the end of the period.
 * Based on the current progress, it provides feedback on whether the target is
 * achievable or at risk.
 *
 * @author Your Name
 * @version 1.0
 */
public class SalesAssistant {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user sales target
        System.out.print("Enter your sales target: $");
        double targetSales = input.nextDouble();

        // Set the number of days
        System.out.print("Enter the number of days: ");
        int days = input.nextInt();

        // Variables for tracking sales data
        double totalSales = 0;

        System.out.println();

        // Track sales progress for each day
        for (int i = 1; i <= days; i++) {
            System.out.print("Enter sales for day " + i + ": $");
            double dailySales = input.nextDouble();
            totalSales += dailySales;

            // Calculate average daily sales and predicted total sales
            double avgSalesPerDay = totalSales / i;
            double daysLeft = days - i;
            double predictedTotal = totalSales + (avgSalesPerDay * daysLeft);

            // Display cumulative sales, average daily sales, predicted total sales, and
            // days left
            String output = String.format(
                    "Current Total: $%.2f | Daily Avg: $%.2f | Days Left: %.0f | Predicted Total: $%.2f",
                    totalSales, avgSalesPerDay, daysLeft, predictedTotal);
            System.out.println(output);

            // Predict whether target is achievable or at risk
            System.out.println(
                    predictedTotal >= targetSales ? "PREDICTION: TARGET ACHIEVABLE." : "PREDICTION: TARGET AT RISK.");
            System.out.println();
        }

        // Final feedback in a single line
        System.out.println(String.format(
                "Target: $%.2f | Total: $%.2f | %s",
                targetSales, totalSales,
                totalSales >= targetSales ? "Congratulations! You met your target."
                        : "Target not met. Focus on high-value sales or expanding your outreach."));
    }
}
