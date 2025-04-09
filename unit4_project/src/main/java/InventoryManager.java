import java.util.Scanner;

/**
 * The InventoryManager class helps manage inventory levels by tracking orders
 * and providing restock recommendations.
 * The program allows the user to input the initial inventory and a low stock
 * threshold. It then uses a while loop to prompt the user to enter the order
 * quantity, deducts it from the inventory if there is sufficient stock, and
 * provides feedback on the remaining inventory.
 * The program will recommend restocking the inventory when it falls below the
 * low stock threshold.
 * The loop continues until the inventory is completely depleted.
 *
 * Key features:
 * - Prompts for initial inventory and low stock threshold.
 * - Tracks inventory after each order and provides feedback on inventory level.
 * - Notifies the user if the inventory is insufficient to fulfill an order.
 * - Issues a reorder warning when inventory falls below the threshold.
 * - Stops when the inventory reaches zero and requests a restock.
 * 
 * @author Your Name
 * @version 1.0
 */

public class InventoryManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for the initial inventory and low stock threshold
        System.out.print("Enter initial inventory and low stock threshold: ");
        int inventory = input.nextInt();
        int lowStockThreshold = input.nextInt();

        int quantity;

        // Keep track of inventory and provide restock recommendations
        while (inventory > 0) {

            System.out.print("\nEnter order quantity: ");
            quantity = input.nextInt();

            // Check if the order exceeds the available inventory
            if (quantity > inventory) {
                System.out.println("Insufficient inventory. Only " + inventory + " items left.");
            } else {
                // Deduct the quantity from inventory if it's valid
                inventory -= quantity;
                System.out.println("Order filled. Remaining inventory: " + inventory);

                // Check if inventory is below the low stock threshold after filling the order
                if (inventory <= lowStockThreshold) {
                    System.out.println("Low stock. Time to restock.");
                }
            }

        }

        System.out.println("\nInventory empty. Restock required.");
    }
}
