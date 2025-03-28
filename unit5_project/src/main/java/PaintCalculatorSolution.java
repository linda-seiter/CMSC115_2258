import java.util.Scanner;

/**
 * This application helps to calculate the total area of the walls and ceiling of a room,
 * the amount of paint required, and the total paint cost.
 * It supports both imperial and metric measurement systems.
 *
 * @Author First Last
 * @Version 1.0
 *
 */
public class PaintCalculatorSolution {

    /**
     * Checks if the given length and width represent a valid rectangle.
     * A valid rectangle must have both dimensions greater than zero.
     *
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return true if the dimensions represent a valid rectangle, false otherwise.
     */
    public static boolean isValidRectangle(double length, double width) {
        return length > 0 && width > 0;
    }

    /**
     * Checks if the given length, width, and height represent a valid rectangular prism.
     * A valid rectangular prism must have all dimensions greater than zero.
     *
     * @param length The length of the rectangular prism.
     * @param width The width of the rectangular prism.
     * @param height The height of the rectangular prism.
     * @return true if the dimensions represent a valid rectangular prism, false otherwise.
     */
    public static boolean isValidRectangularPrism(double length, double width, double height) {
        return length > 0 && width > 0 && height > 0;
    }

    /**
     * Calculates the area of the ceiling based on the length and width of the room.
     * The method checks if the given dimensions form a valid rectangle (both length and width must be greater than zero).
     * If either dimension is invalid (less than or equal to zero), it returns 0.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @return The area of the ceiling, or 0 if the dimensions are not valid.
     */
    public static double calculateCeilingArea(double length, double width) {
        return isValidRectangle(length, width) ?  length*width : 0;
    }

    /**
     * Calculates the total wall area of the room based on the length, width, and height.
     * The method checks if the dimensions form a valid rectangular prism (all dimensions must be greater than zero).
     * If any of the dimensions are invalid, it returns 0.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @param height The height of the room.
     * @return The total wall area of the room, or 0 if the dimensions do not form a valid rectangular prism.
     */
    public static double calculateWallArea(double length, double width, double height) {
        if (isValidRectangularPrism(length, width, height)) {
            double perimeter = 2 * (length + width); // Perimeter of the room (sum of all sides)
            return perimeter * height; // Wall area
        }
        else
            return 0;
    }

    /**
     * Calculates the total area to be painted, which includes the ceiling and the walls of the room.
     * The method checks if the given dimensions form a valid rectangular prism (all dimensions must be greater than zero).
     * If the dimensions are valid, it returns the sum of the ceiling area and the wall area.
     * If any dimension is invalid, it returns 0.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @param height The height of the room.
     * @return The total area to be painted, or 0 if the dimensions do not form a valid rectangular prism.
     */
    public static double calculateTotalArea(double length, double width, double height) {
        if (isValidRectangularPrism(length, width, height))
            return (calculateCeilingArea(length, width) + calculateWallArea(length, width, height));
        else
            return 0;
    }


    /**
     * Checks if the provided measurement system is valid.
     * The valid systems are "imperial" and "metric".
     *
     * @param measurementSystem The measurement system to check (either "imperial" or "metric").
     * @return true if the measurement system is valid, false otherwise.
     */
    public static boolean isValidMeasurementSystem(String measurementSystem) {
        return (measurementSystem != null && (measurementSystem.equals("imperial") || measurementSystem.equals("metric")));
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
     * Generates a formatted report of the total area,
     * the amount of paint required, and the total cost.
     *
     * @param totalArea The total area to be painted.
     * @param paintRequired The amount of paint required.
     * @param paintCost The total cost of the paint.
     * @param measurementSystem The measurement system being used ("imperial" or "metric").
     * @return A formatted string containing the room renovation report, or an error message if the measurement system is invalid.
     */
    public static String paintCostReport(double totalArea, double paintRequired, double paintCost, String measurementSystem) {
        // Validate the measurement system
        if (!isValidMeasurementSystem(measurementSystem))
            return "Invalid Measurement System";

        // Determine the appropriate units based on the measurement system
        String areaUnit = measurementSystem.equals("imperial") ? "square feet" : "square meters";
        String paintUnit = measurementSystem.equals("imperial") ? "gallons" : "liters";

        // Create the report string using String.format for consistent formatting
        String report = String.format("Total area: %.2f %s\n", totalArea, areaUnit) +
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
        if (!isValidMeasurementSystem(measurementSystem)) {
            System.out.println("Invalid input.");
            return;
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
        System.out.println(paintCostReport(totalArea, paintRequired, paintCost, measurementSystem));

        scanner.close();
    }
}
