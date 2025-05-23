import java.util.Scanner;

/**
 * The {@code VehicleTask4} class evaluates a vehicle's eco-friendliness based
 * on its fuel type and engine size. The program prompts the user to input the
 * fuel type (electric, hybrid, gas, or diesel) and engine size in
 * liters. Based on the fuel type and engine size, the program categorizes the
 * vehicle as either eco-friendly or not eco-friendly.
 * 
 * The eco-friendliness determination follows these rules:
 * 
 * - If the fuel type is either electric or hybrid and the engine size is less
 * than or equal to 2.0 liters, the vehicle is considered eco-friendly.
 * - Otherwise, the vehicle is considered not eco-friendly.
 * 
 * Example:
 * 
 * Enter the fuel type (electric/hybrid/gas/diesel): electric
 * Enter the engine size in liters (e.g., 2.0 for 2.0L): 1.8
 * Eco-Friendly vehicle.
 */
public class VehicleTask4Solution {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt for fuel type
        System.out.print("Enter the fuel type (electric/hybrid/gas/diesel): ");
        String fuelType = scanner.next().toLowerCase();

        // Prompt for engine size
        System.out.print("Enter the engine size in liters (e.g., 2.0 for 2.0L): ");
        double engineSize = scanner.nextDouble();

        // Assign message using a ternary operator to determine eco-friendliness.
        // The boolean expression should include logical operators && and ||.
        String message = (fuelType.equals("electric") || fuelType.equals("hybrid"))
                && engineSize <= 2.0 ? "Eco-Friendly vehicle." : "Not eco-friendly vehicle.";

        // Display message
        System.out.println(message);

        // Cleanup
        scanner.close();
    }
}
