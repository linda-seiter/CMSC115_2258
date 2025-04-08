import java.util.Scanner;

/**
 * The {@code VehicleTask1} class allows a user to input the mileage of a
 * vehicle in kilometers, and then categorizes the mileage into different
 * ranges:
 * low, moderate, high, or very high.
 * 
 * Mileage Categories:
 * - Low mileage: Less than 50,000 km
 * - Moderate mileage: 50,000 (inclusive) to 100,000 (exclusive) km
 * - High mileage: 100,000 (inclusive) to 150,000 (exclusive) km
 * - Very high mileage: At least 150,000 km
 * 
 * Example:
 * Enter mileage in kilometers: 45000
 * Low mileage.
 */
public class VehicleTask1Solution {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt for mileage in km
        System.out.print("Enter mileage in kilometers: ");
        double mileage = scanner.nextDouble();

        // Ladder/Chained/Multi-way conditional
        if (mileage < 0) {
            System.out.println("Invalid mileage.");
        } else if (mileage < 50000) {
            System.out.println("Low mileage.");
        } else if (mileage < 100000) {
            System.out.println("Moderate mileage.");
        } else if (mileage < 150000) {
            System.out.println("High mileage.");
        } else {
            System.out.println("Very high mileage.");
        }

        // Cleanup
        scanner.close();
    }
}
