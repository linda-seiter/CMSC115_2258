import java.util.Scanner;

/**
 * The {@code VehicleTask2} class evaluates a vehicle's age and accident history
 * to provide a recommendation regarding its purchase.
 * 
 * This class asks the user for two inputs: the car's age and whether it has
 * been in any accidents. Based on the car's age and accident history, it
 * categorizes the car's condition and provides a recommendation:
 * 
 * - Older, with an accident. Avoid buying.
 * - Older, no accidents. Consider buying.
 * - Newer, but involved in an accident. Caution advised, think twice.
 * - Newer, no accidents! Highly recommended to buy.
 * 
 * The term "older" refers to vehicles that are more than 10 years old, while
 * "newer" refers to vehicles that are 10 years old or younger.
 * 
 * Example:
 * 
 * Enter the car's age: 12
 * Any accidents? (true/false): false
 * Output: Older, no accidents. Consider buying.
 */
public class VehicleTask2 {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // TODO: Prompt for age and accident status

        // TODO: Nested conditional to check car's age and accident history and print
        // purchase message

        // Cleanup
        scanner.close();
    }
}
