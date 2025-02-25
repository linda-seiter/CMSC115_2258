/**
 * Paycheck class - debugging sample to demonstrate variables in memory
 * 
 * @author First Last
 */
public class Paycheck {
	public static void main(String[] args) {
		// Declare and initialize variables
		double hourlyRate = 18.25;
		int hoursWorked = 35;
		double pay = hoursWorked * hourlyRate;

		// Print initial values
		System.out.println("Week#1 hours: " + hoursWorked + " rate: $" + hourlyRate + " pay: $" + pay);

		// Assign hoursWorked to 39, recalculate pay
		hoursWorked = 39;
		pay = hoursWorked * hourlyRate;

		// Print updated values
		System.out.println("Week#2 hours: " + hoursWorked + " rate: $" + hourlyRate + " pay: $" + pay);

		// TODO: Week 3 - Assign hoursWorked to 27, increase hourlyRate by 0.50,
		// recalculate pay

		// TODO: Print updated values

	}
}
