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
public class VehicleTask1 {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // TODO: Prompt for mileage in km

        // TODO: Ladder/Chained/Multi-way conditional to determine mileage category

        // Cleanup
        scanner.close();
    }
}
