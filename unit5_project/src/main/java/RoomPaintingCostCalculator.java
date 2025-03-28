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
public class RoomPaintingCostCalculator {

    /**
     * Checks if the given length and width represent a valid rectangle.
     * A valid rectangle must have both dimensions greater than zero.
     *
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return true if the dimensions represent a valid rectangle, false otherwise.
     */
    public static boolean isValidRectangle(double length, double width) {
        // TODO
        return false;
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
        // TODO
        return false;
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
    public static double getCeilingArea(double length, double width) {
        // TODO
        return 0;
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
    public static double getWallArea(double length, double width, double height) {
        // TODO
        return 0;
    }


    /**
     * Calculates the total surface area to be painted, including or excluding the ceiling.
     *
     * @param length The length of the surface in feet.
     * @param width The width of the surface in feet.
     * @param height The height of the surface in feet.
     * @param includeCeiling A flag indicating whether to include the ceiling area in the total surface area calculation.
     * @return The total surface area to be painted.
     */
    public static double getSurfaceArea(double length, double width, double height, boolean includeCeiling) {
        // TODO
        return 0;
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
        // TODO
        return 0;
    }


    /**
     * Generates a formatted report of the surface area and the total cost.
     *
     * @param surfaceArea The surface area to be painted.
     * @param paintCost The cost of the paint.
     * @return A formatted string containing the surface area and cost to paint the room.
     */
    public static String generatePaintCostReport(double surfaceArea, double paintCost) {
        // TODO
        return null;
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

        // TODO

        scanner.close();
    }
}
