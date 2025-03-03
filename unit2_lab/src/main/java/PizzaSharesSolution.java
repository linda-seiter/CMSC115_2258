import java.util.Scanner;

/**
 * PizzaShares class demonstrates user input, along with division and remainder
 * operators
 *
 * @author First Last
 */
public class PizzaSharesSolution {
    public static void main(String[] args) {
        // Declare local variables

        // Declare and initialize Scanner to read user input
        Scanner input = new Scanner(System.in);

        // Prompt for number of pizza slices and number of people
        System.out.print("Enter #slices and #people: ");
        int totalSlices = input.nextInt();
        int people = input.nextInt();

        // Compute number of slices per person
        int slicesPerPerson = totalSlices / people;

        System.out.println("Each person gets " + slicesPerPerson + " slices.");

        // TODO: Compute and print number of slices remaining
        int slicesRemaining = totalSlices % people;
        System.out.println("There are " + slicesRemaining + " slices remaining.");
    }

}

