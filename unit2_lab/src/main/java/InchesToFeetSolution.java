import java.util.Scanner;

/**
 * The InchesToFeet class provides a simple conversion from inches to feet.
 * It prompts the user to enter a value in inches, performs the conversion,
 * and then displays the result in feet.
 * 
 * There is an error in the code.
 * 
 * @author Your Name
 * @version 1.0
 */
public class InchesToFeetSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter inches: ");
        int inches = input.nextInt();
        double feet = inches / 12.0;
        System.out.println(inches + " inches = " + feet + " feet");
    }
}
