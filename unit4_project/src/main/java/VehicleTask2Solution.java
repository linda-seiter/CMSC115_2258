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
public class VehicleTask2Solution {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt for age
        System.out.print("Enter the car's age: ");
        int age = scanner.nextInt(); // Car's age in years

        // Prompt for accident status
        System.out.print("Any accidents? (true/false): ");
        boolean hadAccident = scanner.nextBoolean();

        // Nested conditional to check car's age and accident history and print purchase
        // message
        if (age > 10) {
            if (hadAccident) {
                System.out.println("Older, with an accident. Avoid buying.");
            } else {
                System.out.println("Older, no accidents. Consider buying.");
            }
        } else {
            if (hadAccident) {
                System.out.println("Newer, but involved in an accident. Caution advised, think twice.");
            } else {
                System.out.println("Newer, no accidents! Highly recommended to buy.");
            }
        }

        // Cleanup
        scanner.close();
    }
}
