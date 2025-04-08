import java.util.Scanner;

/**
 * The {@code VehicleTask3} class prompts the user to enter the vehicle's type
 * (e.g., Sedan, SUV, or Truck), and provides a recommendation or message
 * based on the type of the vehicle. The recommendation is based on a switch
 * expression that assigns a message specific to each vehicle type.
 * 
 * The possible vehicle types and their corresponding messages are:
 * 
 * - Sedan: Great for commuting.
 * - SUV: Perfect for off-road trips.
 * - Truck: Great for heavy loads.
 * - Any other type: "Uncommon: [type]"
 * 
 * Example:
 * 
 * Enter the vehicle type (Sedan, SUV, Truck): SUV
 * SUV: Perfect for off-road trips.
 */
public class VehicleTask3 {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // TODO: Prompt for vehicle type

        // TODO: Use switch expression to assign message variable based on vehicle type
        String message = "";
        System.out.println(message);

        // Cleanup
        scanner.close();
    }
}
