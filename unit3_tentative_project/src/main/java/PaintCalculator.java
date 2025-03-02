import java.util.Scanner;

/**
 * PaintCalculator class calculates the gallons of paint
 * needed to cover the ceiling and walls of a rectangular room.
 * 
 * @author First Last
 */
public class PaintCalculator {

    /**
     * main - Print value returned from task method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length, width and height: ");
        double length = in.nextDouble();
        double width = in.nextDouble();
        double height = in.nextDouble();
        System.out.println("Buy " + gallonsPaint(length, width, height) + " gallons of paint.");
    }

    /**
     * ceilingArea - Returns the ceiling area given the room length and width.
     * 
     * @param length - the room length as a double.
     * @param width  - the room width as a double.
     * @return the ceiling area as a double.
     */
    public static double ceilingArea(double length, double width) {
        return length * width;
    }

    /**
     * wallArea - Returns the wall area given the room length, width, and height.
     * 
     * @param length - the room length as a double.
     * @param width  - the room width as a double.
     * @param height - the room height as a double.
     * @return the wall area as a double.
     */
    public static double wallArea(double length, double width, double height) {
        return 2 * (length + width) * height;
    }

    /**
     * roomArea - Returns the total ceiling and wall area given the room length,
     * width, and height.
     * 
     * @param length - the room length as a double.
     * @param width  - the room width as a double.
     * @param height - the room height as a double.
     * @return the total ceiling and wall area as a double.
     */
    public static double roomArea(double length, double width, double height) {
        return ceilingArea(length, width) + wallArea(length, width, height);
    }

    /**
     * gallonsPaint - Returns the gallons of paint needed to cover the ceiling and
     * walls given the room length, width, and height.
     * 
     * @param length - the room length as a double
     * @param width  - the room width as a double
     * @param height - the room height as a double
     * @return the gallons of paint as an int
     */
    public static int gallonsPaint(double length, double width, double height) {
        double sqFt = roomArea(length, width, height);
        double gallons = sqFt / 350;
        double gallonsRoundedUp = Math.ceil(gallons);
        return (int) gallonsRoundedUp;
    }

}
