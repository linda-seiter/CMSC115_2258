import java.util.Scanner;

/**
 * PizzaShares class demonstrates user input, along with division and remainder
 * operators
 * 
 * @author First Last
 */
public class PizzaShares {
	public static void main(String[] args) {
		// Declare local variables
		int people, totalSlices, slicesPerPerson, slicesRemaining;

		// Declare and initialize Scanner to read user input
		Scanner input = new Scanner(System.in);

		// Prompt for number of pizza slices and number of people
		System.out.print("Enter #slices and #people: ");
		totalSlices = input.nextInt();
		people = input.nextInt();

		// Compute number of slices per person
		slicesPerPerson = totalSlices / people;

		System.out.println("Each person gets " + slicesPerPerson + " slices.");

		// TODO: Compute and print number of slices remaining

	}

}
