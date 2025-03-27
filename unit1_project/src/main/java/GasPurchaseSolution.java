import java.util.Scanner;

/**
 * GasPurchase class - demonstrates initializing variables from console input.
 * This class prompts the user for input regarding the quantity of gallons
 * purchased and the price per gallon, calculates the total cost, and
 * then prints the total amount owed.
 *
 * @author First Last
 */
public class GasPurchaseSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter gallons and price per gallon: ");
        double gallons = input.nextDouble();
        double pricePerGallon = input.nextDouble();

        double total = gallons * pricePerGallon;
        System.out.println("You owe $" + total);
    }
}
