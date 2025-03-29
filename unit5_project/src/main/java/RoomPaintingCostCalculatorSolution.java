import java.util.Scanner;

/**
 * This application calculates the total area of the walls and ceiling of a room
 * and computes the total paint cost based on those dimensions.
 * It provides methods for calculating surface areas (walls, ceiling), checking if the dimensions are valid,
 * and generating a report with the calculated results.
 *
 * The application allows the user to input room dimensions (length, width, height) and choose whether to include
 * the ceiling in the area calculation. The total area is then used to estimate the amount of paint required and
 * calculate the total cost.
 *
 * Constants used in the calculation:
 * - SQFT_PER_GALLON: the coverage area of one gallon of paint (350 square feet).
 * - PRICE_PER_GALLON: the price per gallon of paint ($50.75).
 *
 * @Author First Last
 * @Version 1.0
 */
public class RoomPaintingCostCalculatorSolution {

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
     * Calculates the ceiling area of a rectangular room using the given length and width.
     * If either dimension is invalid (less than or equal to zero), the method returns 0.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @return The area of the ceiling, or 0 if either dimension is invalid.
     */
    public static double getCeilingArea(double length, double width) {
        return isValidRectangle(length, width) ?  length*width : 0;
    }

    /**
     * Calculates the total wall area of a room with a rectangular prism shape, using the provided length, width, and height.
     * If any of the dimensions are invalid (less than or equal to zero), the method returns 0.
     *
     * @param length The length of the room.
     * @param width The width of the room.
     * @param height The height of the room.
     * @return The total wall area of the room, or 0 if any dimension is invalid.
     */
    public static double getWallArea(double length, double width, double height) {
        if (isValidRectangularPrism(length, width, height)) {
            double perimeter = 2 * (length + width); // Perimeter of the room (sum of all sides)
            return perimeter * height; // Wall area
        }
        else
            return 0;
    }


    /**
     * Calculates the total surface area of a room shaped like a rectangular prism, with an option to include or exclude the ceiling area.
     * Note that the floor area is not included in the calculation.
     * The provided length, width, and height are used for the calculation. If any dimension is invalid (less than or equal to zero), the method returns 0.
     *
     * @param length The length of the room in feet.
     * @param width The width of the room in feet.
     * @param height The height of the room in feet.
     * @param includeCeiling A flag to indicate whether the ceiling area should be included in the total surface area.
     * @return The total surface area to be painted, or 0 if any dimension is invalid.
     */
    public static double getSurfaceArea(double length, double width, double height, boolean includeCeiling) {
        if (isValidRectangularPrism(length, width, height)) {
            if (includeCeiling) {
                return (getCeilingArea(length, width) + getWallArea(length, width, height));
            } else {
                return getWallArea(length, width, height);
            }
        } else {
            return 0;
        }
    }



    /**
     * Calculates the cost of paint required to cover a given surface area.
     *
     * This method calculates how many gallons of paint are required to cover the area,
     * and then calculates the total cost of the paint based on the price per gallon.
     *
     * The constants used in this calculation are:
     * - SQFT_PER_GALLON: the coverage area of one gallon of paint (350 square feet).
     * - PRICE_PER_GALLON: the price per gallon of paint ($50.75).
     *
     * @return The total cost of paint required to cover the surface area.
     */
    public static double calculatePaintCost(double surfaceArea) {
        final double SQFT_PER_GALLON = 350.0;
        final double PRICE_PER_GALLON = 50.75;

        double gallonsPaint = surfaceArea / SQFT_PER_GALLON;
        double cost = gallonsPaint * PRICE_PER_GALLON;
        return cost;
    }


    /**
     * Generates a formatted report of the surface area and the total cost.
     *
     * Example format: "Total area: 700.00 square feet, total cost: $102.25"
     * The values are formatted to display two digits after the decimal point.
     *
     * @param surfaceArea The surface area to be painted.
     * @param paintCost The cost of the paint.
     * @return A formatted string containing the surface area and cost to paint the room.
     */
    public static String generatePaintCostReport(double surfaceArea, double paintCost) {
        return String.format("Total area: %.2f square feet, total cost: $%.2f", surfaceArea, paintCost);
    }

    /**
     * The user is prompted to input room dimensions
     * and whether to include the ceiling in the paint area calculation.
     * The method calculates the total surface area to be painted, the total paint cost,
     * and generates a formatted report displaying the results.
     *
     * @param args Command-line arguments (not used in this method).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for room dimensions
        System.out.print("Enter the room length, width, and height: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        // Prompt for ceiling option
        System.out.println("Include ceiling (true/false): ");
        boolean includeCeiling = scanner.nextBoolean();

        // Calculate total area and cost of paint
        double surfaceArea = getSurfaceArea(length, width, height, includeCeiling);
        double paintCost = calculatePaintCost(surfaceArea);

        // Generate the report and print the results
        System.out.println(generatePaintCostReport(surfaceArea, paintCost));

        scanner.close();
    }
}
