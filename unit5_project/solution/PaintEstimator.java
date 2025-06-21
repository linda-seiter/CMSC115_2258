import java.util.Scanner;

public class PaintEstimator {

    private static final double COST_PER_LITER = 20.0;
    private static final double COST_PER_GALLON = 50.0;
    private static final double SQFT_PER_GALLON = 350.0;
    private static final double SQM_PER_LITER = 10.0;

    public static boolean areValidDimensions2D(double length, double width) {
        return length > 0 && width > 0;
    }

    public static boolean areValidDimensions3D(double length, double width, double height) {
        return length > 0 && width > 0 && height > 0;
    }

    public static double calculateCeilingArea(double length, double width) {
        if (!areValidDimensions2D(length, width)) {
            return 0;
        }
        return length * width;
    }

    public static double calculateWallArea(double length, double width, double height) {
        if (!areValidDimensions3D(length, width, height)) {
            return 0;
        }
        double perimeter = 2 * (length + width);
        return perimeter * height;
    }

    public static double calculateTotalPaintableArea(double length, double width, double height, boolean includeCeiling) {
        if (!areValidDimensions3D(length, width, height)) {
            return 0;
        }
        return includeCeiling
                ? calculateCeilingArea(length, width) + calculateWallArea(length, width, height)
                : calculateWallArea(length, width, height);
    }

    public static int calculatePaintQuantity(double paintableArea, boolean isMetric) {
        if (paintableArea <= 0)
            return 0;
        double coverage = isMetric ? SQM_PER_LITER : SQFT_PER_GALLON;
        return (int) Math.ceil(paintableArea / coverage);
    }

    public static String generatePaintCostSummary(double surfaceArea, int unitsPaint, boolean isMetric) {
        String areaUnit = isMetric ? "square meters" : "square feet";
        String unitLabel = isMetric ? "liters" : "gallons";
        double costPerUnit = isMetric ? COST_PER_LITER : COST_PER_GALLON;
        double totalCost = unitsPaint * costPerUnit;

        return String.format(
                "Total area: %.2f %s, paint: %d %s, total cost: $%.2f",
                surfaceArea, areaUnit,
                unitsPaint, unitLabel,
                totalCost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the room length, width, and height.");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        System.out.println("Include ceiling (true/false).");
        boolean includeCeiling = scanner.nextBoolean();

        System.out.println("Metric (true) or Imperial (false).");
        boolean isMetric = scanner.nextBoolean();

        double paintArea = calculateTotalPaintableArea(length, width, height, includeCeiling);

        if (paintArea <= 0) {
            System.out.println("Invalid room dimensions. No paint needed.");
        } else {
            int paintUnits = calculatePaintQuantity(paintArea, isMetric);
            String summary = generatePaintCostSummary(paintArea, paintUnits, isMetric);
            System.out.println(summary);
        }

        scanner.close();
    }
}