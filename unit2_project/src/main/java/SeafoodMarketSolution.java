import java.util.Scanner;

/**
 * The {@code SeafoodMarketSolution} class calculates the total cost of purchasing a certain
 * amount of fish based on the user's input for the weight (in pounds) and price per pound.
 * It then displays the total cost, rounded to two decimal places.
 *
 * <p>The program uses a simple formula to compute the cost:
 * total cost = pounds of fish * price per pound.</p>
 *
 * <p>The result is rounded to two decimal places for proper currency formatting.</p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class SeafoodMarketSolution {

    public static void main(String[] args) {
        //Declare and initialize Scanner to read user input
        Scanner input = new Scanner(System.in);

        //Prompt for pounds of fish and price per pound
        System.out.print("Enter pounds of fish and price per pound: ");
        double lbsFish = input.nextDouble();
        double pricePerPound = input.nextDouble();

        //Calculate cost
        double totalCost = lbsFish * pricePerPound;
        //Round to 2 digits after decimal point
        totalCost = (int)(totalCost * 100 + 0.5) / 100.0;

        //Output cost
        System.out.println(lbsFish + " lbs at $" + pricePerPound + " per lb = $" + totalCost );

    }

}
