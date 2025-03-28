import java.util.Scanner;

/**
 * This application helps to calculate the total area of a room,
 * the amount of paint required, and the total paint cost for a renovation project.
 * It supports both imperial and metric measurement systems.
 *
 * @Author First Last
 * @Version 1.0
 *
 */
public class RoomRenovationApp {

    /**
     * Checks if the provided measurement system is valid.
     * The valid systems are "imperial" and "metric".
     *
     * @param measurementSystem The measurement system to check (either "imperial" or "metric").
     * @return true if the measurement system is valid, false otherwise.
     */
    public static boolean isValidMeasurementSystem(String measurementSystem) {
        return (measurementSystem.equals("imperial") || measurementSystem.equals("metric"));
    }

    /**
     * Calculates the area of the ceiling based on the length and width of the room.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @return The area of the ceiling.
     */
    public static double calculateCeilingArea(double length, double width) {
        return length * width;
    }

    /**
     * Calculates the total wall area of the room based on the room's perimeter and height.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @param height The height of the room.
     * @return The total wall area.
     */
    public static double calculateWallArea(double length, double width, double height) {
        double perimeter = 2 * (length + width); // Perimeter of the room (sum of all sides)
        return perimeter * height; // Wall area
    }

    /**
     * Calculates the total area to be painted, which includes the ceiling and the walls.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @param height The height of the room.
     * @return The total area to be painted.
     */
    public static double calculateTotalArea(double length, double width, double height) {
        return calculateCeilingArea(length, width) + calculateWallArea(length, width, height);
    }

    /**
     * Calculates the amount of paint required based on the total area and the measurement system.
     * The calculation depends on the measurement system used (imperial or metric).
     * The constant values used are:
     * - COVERAGE_PER_GALLON = 350.0 (square feet per gallon) for the imperial system.
     * - COVERAGE_PER_LITER = 9.0 (square meters per liter) for the metric system.
     *
     * @param area The total area to be painted.
     * @param measurementSystem The measurement system being used ("imperial" or "metric").
     * @return The amount of paint required or 0 if the measurement system is not valid.
     */
    public static double calculatePaintQuantity(double area, String measurementSystem) {
        double paintQuantity = 0.0;
        final double COVERAGE_PER_GALLON = 350.0; // Square feet per gallon
        final double COVERAGE_PER_LITER = 9.0;   // Square meters per liter

        // Imperial system (gallons) or metric system (liters)
        if (measurementSystem.equals("imperial")) {
            paintQuantity = area / COVERAGE_PER_GALLON;
        } else if (measurementSystem.equals("metric")) {
            paintQuantity = area / COVERAGE_PER_LITER;
        }

        return paintQuantity;
    }

    /**
     * Calculates the total cost of paint required based on the amount of paint and the measurement system.
     * The cost is calculated based on a fixed price per gallon (for imperial) or per liter (for metric).
     * The constant values used are:
     * - PRICE_PER_GALLON = 50.75 (price per gallon in imperial system).
     * - PRICE_PER_LITER = 9.50 (price per liter in metric system).
     *
     * @param paintRequired The amount of paint required.
     * @param measurementSystem The measurement system being used ("imperial" or "metric").
     * @return The total cost of paint or 0 if the measurement system is not valid.
     */
    public static double calculatePaintCost(double paintRequired, String measurementSystem) {
        final double PRICE_PER_GALLON = 50.75;
        final double PRICE_PER_LITER = 9.50;
        double cost = 0.0;

        // Imperial system (gallons) or metric system (liters)
        if (measurementSystem.equals("imperial")) {
            cost = paintRequired * PRICE_PER_GALLON;
        } else if (measurementSystem.equals("metric")) {
            cost = paintRequired * PRICE_PER_LITER;
        }

        return cost;
    }


    /**
     * Generates a formatted report of the room renovation, including the total area,
     * the amount of paint required, and the total cost.
     *
     * @param totalArea The total area to be painted.
     * @param paintRequired The amount of paint required.
     * @param paintCost The total cost of the paint.
     * @param measurementSystem The measurement system being used ("imperial" or "metric").
     * @return A formatted string containing the room renovation report.
     */
    public static String generateRoomRenovationReport(double totalArea, double paintRequired, double paintCost, String measurementSystem) {

        String areaUnit = measurementSystem.equals("imperial") ? "square feet" : "square meters";
        String paintUnit = measurementSystem.equals("imperial") ? "gallons" : "liters";

        // Create the report string using String.format for consistent formatting
        String report = String.format("Total surface area: %.2f %s\n", totalArea, areaUnit) +
                String.format("Amount of paint required: %.2f %s\n", paintRequired, paintUnit) +
                String.format("Total paint cost: $%.2f", paintCost);

        return report;
    }

    /**
     * Main method to interact with the user, take inputs, and display the room renovation report.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like to use imperial (feet, gallons) or metric (meters, liters) units? ");
        String measurementSystem = scanner.next();

        // Loop until user enters valid measurement system (imperial or metric)
        while (!isValidMeasurementSystem(measurementSystem)) {
            System.out.println("Invalid input. Please enter 'imperial' or 'metric'.");
            System.out.print("Would you like to use imperial (feet, gallons) or metric (meters, liters) units? ");
            measurementSystem = scanner.next().toLowerCase();
        }

        // Prompt for room dimensions
        System.out.print("Enter the room length, width, and height: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        // Calculate total surface area
        double totalArea = calculateTotalArea(length, width, height);
        // Calculate the amount of paint required
        double paintRequired = calculatePaintQuantity(totalArea, measurementSystem);
        // Calculate paint cost
        double paintCost = calculatePaintCost(paintRequired, measurementSystem);

        // Generate the report and print the results
        String report = generateRoomRenovationReport(totalArea, paintRequired, paintCost, measurementSystem);
        System.out.println(report);

        scanner.close();
    }
}
