import java.util.Scanner;

/**
 * Rounding class demonstrates numeric conversion and rounding.
 * (1) Cast a double to an int
 * (2) Round a double to nearest integer
 * (3) Truncate a double to 3 digits after the decimal point
 * (4) TODO: Round a double to 3 digits after the decimal point
 * @author First Last
 */

public class Rounding {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter number: " );
		double num = input.nextDouble();
		
		System.out.println("Cast as int: " + (int)num);
		System.out.println();

		System.out.println("Round to nearest int");
		System.out.println("Original: \t"  	+ num);                  
		System.out.println("Add 0.5:\t" 	+ (num + 0.5));           
		System.out.println("Cast as int:\t" + (int) (num + 0.5));   
		System.out.println();

		System.out.println("Truncate to 3 digits after the decimal point");
		System.out.println("Original:\t\t"      		+ num);                         
		System.out.println("Move . 3 digits right:\t" 	+ num * 1000 );          
		System.out.println("Cast as int:\t\t"        	+ (int) (num * 1000));
		System.out.println("Move . 3 digits left:\t"  	+ (int) (num * 1000 ) / 1000.0); 
		System.out.println();

		//TODO
		System.out.println("Round to 3 digits after the decimal point");

	}
}
