import java.util.Scanner;

public class RoomRenovationApp {

    // Method to check if the measurement system is valid (either imperial or metric)
    public static boolean isValidMeasurementSystem(String measurementSystem) {
        return (measurementSystem.equalsIgnoreCase("imperial") || measurementSystem.equalsIgnoreCase("metric"));
    }

    // Method to calculate the area of the room (length * width) for the ceiling
    public static double calculateCeilingArea(double length, double width) {
        return length * width;
    }

    // Method to calculate the wall area (perimeter * height) of the room
    public static double calculateWallArea(double length, double width, double height) {
        double perimeter = 2 * (length + width); // Perimeter of the room (sum of all sides)
        return perimeter * height; // Wall area
    }

    // Method to calculate total surface area (ceiling + walls)
    public static double calculateTotalArea(double length, double width, double height) {
        return calculateCeilingArea(length, width) + calculateWallArea(length, width, height);
    }

    // Method to calculate how much paint is needed based on the area to be painted
    public static double calculatePaintQuantity(double area, String measurementSystem) {
        double paintQuantity = 0.0;
        final double COVERAGE_PER_GALLON = 350.0; // Square feet per gallon
        final double COVERAGE_PER_LITER = 9.0; // Square meters per liter

        // Imperial system (gallons) or metric system (liters)
        if (measurementSystem.equalsIgnoreCase("imperial")) {
            paintQuantity = area / COVERAGE_PER_GALLON;
        } else if (measurementSystem.equalsIgnoreCase("metric")) {
            paintQuantity = area / COVERAGE_PER_LITER;
        }

        return paintQuantity;
    }

    // Method to calculate total cost based on the amount of paint and unit
    public static double calculatePaintCost(double paintRequired, String measurementSystem) {
        final double PRICE_PER_GALLON = 50.75;
        final double PRICE_PER_LITER = 9.50;
        double cost = 0.0;

        // Imperial system (gallons) or metric system (liters)
        if (measurementSystem.equalsIgnoreCase("imperial")) {
            cost = paintRequired * PRICE_PER_GALLON;
        } else if (measurementSystem.equalsIgnoreCase("metric")) {
            cost = paintRequired * PRICE_PER_LITER;
        }

        return cost;
    }

    // Method to generate a formatted report of the results
    public static String generateRoomRenovationReport(double totalArea, double paintRequired, double paintCost, String measurementSystem) {
        String areaUnit = measurementSystem.equalsIgnoreCase("imperial") ? "square feet" : "square meters";
        String paintUnit = measurementSystem.equalsIgnoreCase("imperial") ? "gallons" : "liters";

        // Create the report string using String.format for consistent formatting
        String report = String.format("Total surface area: %.2f %s\n", totalArea, areaUnit) +
                String.format("Amount of paint required: %.2f %s\n", paintRequired, paintUnit) +
                String.format("Total paint cost: $%.2f", paintCost);

        return report;
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like to use imperial (feet, gallons) or metric (meters, liters) units? ");
        String measurementSystem = scanner.next().toLowerCase();

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
