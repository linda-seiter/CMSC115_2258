/**
 * StudentInfo class demonstrates an error in redeclaring a variable.
 * 
 * @author First Last
 */
public class StudentInfo {

	public static void main(String[] args) {
		// Variable declaration and initialization
		double gpa = 3.8;

		// Variable declaration
		int age;
		// Variable initialization
		age = 28;

		// Print initial values
		System.out.println("Age: " + age + " gpa: " + gpa);

		// Update age to 29
		age = 29;

		// TODO: Fix the error and update gpa to 4.0.
		// double gpa = 4.0;

		// Print updated values
		System.out.println("Age: " + age + " gpa: " + gpa);

	}

}
