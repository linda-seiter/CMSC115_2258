import java.util.Scanner;

/**
 * The SeafoodMarketSolution class calculates the total cost of purchasing
 * a specified number of pounds of fish at a given price per pound.
 * This program reads the user's input for the number of pounds and price per
 * pound, computes the total cost, rounds it to two decimal places, and then
 * displays the result.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class SeafoodMarketSolution {

    public static void main(String[] args) {
        // Declare and initialize Scanner to read user input
        Scanner input = new Scanner(System.in);

        // Prompt for pounds of fish and price per pound and store in variables.
        System.out.print("Enter pounds of fish and price per pound: ");
        double lbsFish = input.nextDouble();
        double pricePerPound = input.nextDouble();

        // Calculate cost
        double totalCost = lbsFish * pricePerPound;
        // Manually round to 2 digits after decimal point
        totalCost = (int) (totalCost * 100 + 0.5) / 100.0;

        // Output cost
        System.out.println(lbsFish + " lbs at $" + pricePerPound + " per lb = $" + totalCost);

    }

}
