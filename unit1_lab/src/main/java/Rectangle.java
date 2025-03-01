import java.util.Scanner;

/**
 * Rectangle class - demonstrate initializing variables from console input
 * 
 * @author First Last
 */
public class Rectangle {
    public static void main(String[] args) {
        // Declare and initialize Scanner for reading input from console
        Scanner input = new Scanner(System.in);

        // Prompt for length and width
        System.out.print("Enter length and width: ");

        // Declare width and initialize from the console input
        double length = input.nextDouble();

        // Declare width and initialize from the console input
        double width = input.nextDouble();

        // TODO: Declare area and initialize using width and height

        // TODO: Update to print area
        System.out.println("length=" + length + " width=" + width);
    }
}
