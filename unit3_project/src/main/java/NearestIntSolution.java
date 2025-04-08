import java.util.Scanner;

/**
 * The NearestIntSolution class demonstrates how to round a fraction to its
 * nearest integer and perform various operations involving integer and double
 * data types. This program reads a numerator and denominator, calculates their
 * division as a double, rounds the result to the nearest integer, and handles
 * both positive and negative numbers.
 * 
 * <p>
 * It also demonstrates how to cast double values to integers and round both
 * positive and negative fractional numbers to the nearest integer value.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class NearestIntSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for numerator and denominator
        System.out.print("Enter numerator and denominator: ");
        int numerator = input.nextInt();
        int denominator = input.nextInt();

        // Calculate the double value of the fraction
        double number = 1.0 * numerator / denominator;

        // Round to the nearest integer (positive number)
        int nearestInt = (int) (number + 0.5);

        // Display fraction and rounded results
        System.out.println("Fraction: " + numerator + "/" + denominator);
        System.out.println("Double Value: " + number);
        System.out.println("Cast as Int: " + (int) number);
        System.out.println("Rounded to nearest int: " + nearestInt);

        // Handle negative number case (correct rounding for negative numbers)
        double negNumber = -number;
        int nearestNegInt = (int) (negNumber - 0.5);
        System.out.println("Negative Value: " + negNumber);
        System.out.println("Negative Value rounded to nearest int: " + nearestNegInt);
    }

}
