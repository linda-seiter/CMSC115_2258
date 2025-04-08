import java.util.Scanner;

/**
 * The TransmissionRateSolution class calculates the number of new cases
 * based on the transmission rate (r0) raised to the power of 4.
 * This is a simple Java program that reads user input for the initial
 * value of r0 and computes and prints the spread (new cases) on the 4th
 * iteration.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class TransmissionRateSolution {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the value of r0 (the initial transmission rate)
        System.out.print("Enter r0: ");

        // Read the integer input from the user and store it in the variable r0
        int r0 = input.nextInt();

        // Prompt the user to enter the number of iterations
        System.out.print("Enter iterations: ");

        int n = input.nextInt();

        // Calculate the number of new cases on the nth iteration by raising r0 to the
        // power of n. Math.pow() returns a double, so we cast it to an integer
        int newCases = (int) Math.pow(r0, n);

        // Display the result: the number of new cases on the nth iteration
        System.out.println("New cases after " + n + " iterations: " + newCases);
    }

}
