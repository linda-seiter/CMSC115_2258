import java.util.Scanner;

/**
 * The {@code TransmissionRate} class calculates the number of new cases based on the given
 * basic reproduction number (r0) raised to the power of 4. This can be used to estimate how
 * rapidly an infection spreads through a population.
 *
 * <p>The program prompts the user to enter the initial reproduction number (r0), and then
 * it computes and displays the number of new cases on the fourth iteration based on the formula:
 * new cases = r0^4.</p>
 *
 * <p>Note: This model assumes that the basic reproduction number remains constant across iterations.</p>
 *
 * @author [Your Name]
 * @version 1.0
 */
public class TransmissionRateSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter r0: ") ;
        int r0 = input.nextInt();
        int spread = (int)Math.pow(r0, 4);
        System.out.println("New cases on 4th iteration: " + spread);
    }

}
