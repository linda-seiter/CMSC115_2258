import java.util.Scanner;

/**
 * The InventoryManager class tracks inventory levels, processes orders,
 * and provides restock alerts. It prompts the user for the initial inventory
 * and low stock threshold, then uses a do-while loop to process orders,
 * updating and displaying inventory status after each transaction.
 *
 * Features:
 * - Prompts for initial inventory and low stock threshold
 * - Processes orders while inventory is available
 * - Alerts when inventory is low or insufficient for an order
 * - Ends when inventory is depleted
 * 
 * @author Your Name
 * @version 1.0
 */

public class InventoryManagerSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for the initial inventory and low stock threshold
        System.out.print("Enter initial inventory and low stock threshold: ");
        int inventory = input.nextInt();
        int lowStockThreshold = input.nextInt();

        int quantity;

        // Keep track of inventory and provide restock recommendations
        do {

            System.out.print("\nEnter order quantity: ");
            quantity = input.nextInt();

            // Check if the order exceeds the available inventory
            if (quantity > inventory) {
                System.out.println("Insufficient inventory. Only " + inventory + " items left.");
            } else {
                // Deduct the quantity from inventory if it's valid
                inventory -= quantity;
                System.out.println("Order filled. Remaining inventory: " + inventory);
            }
            // Check if inventory reaches the low stock threshold
            if (inventory <= lowStockThreshold) {
                System.out.println("Low stock.");
            }

        } while (inventory > 0);

        System.out.println("\nInventory empty.");
    }
}
