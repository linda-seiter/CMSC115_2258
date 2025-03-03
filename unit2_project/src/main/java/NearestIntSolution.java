import java.util.Scanner;

import java.util.Scanner;

/**
 * The {@code NearestIntSolution} class demonstrates how to round a fraction to its nearest integer
 * and handle both positive and negative values. It also shows how to cast a fractional number
 * to an integer and round it in different ways.
 *
 * <p>The program takes two integers from the user (numerator and denominator) to create a fraction,
 * then performs the following operations:</p>
 * <ul>
 *     <li>Calculate the double value of the fraction.</li>
 *     <li>Cast the double value to an integer.</li>
 *     <li>Round the value to the nearest integer (for both positive and negative values).</li>
 * </ul>
 *
 * <p>It outputs the fraction, the double value, the integer value (casted), and the rounded integer values for both positive and negative cases.</p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class NearestIntSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numerator and denominator: ");
        int numerator = input.nextInt();
        int denominator = input.nextInt();
        double number = 1.0*numerator/denominator;
        int nearestInt = (int)(number + 0.5);
        System.out.println("Fraction: " + numerator+"/"+denominator);
        System.out.println("Double Value: " + number);
        System.out.println("Cast as Int: " + (int)number );
        System.out.println("Rounded to nearest int: " + nearestInt);
        double negNumber = -number;
        int nearestNegInt = (int)(negNumber - 0.5);
        System.out.println("Negative Value: " + negNumber);
        System.out.println("Negative Value rounded to nearest int: " + nearestNegInt);
    }
}
