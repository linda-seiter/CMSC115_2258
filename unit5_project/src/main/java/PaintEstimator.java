import java.util.Scanner;

public class PaintEstimator {

    private static final double COST_PER_LITER = 20.0;
    private static final double COST_PER_GALLON = 50.0;
    private static final double SQFT_PER_GALLON = 350.0;
    private static final double SQM_PER_LITER = 10.0;

    public static boolean areValidDimensions2D(double length, double width) {
        // TODO
        return false;
    }

    public static boolean areValidDimensions3D(double length, double width, double height) {
        // TODO
        return false;
    }

    public static double calculateCeilingArea(double length, double width) {
        // TODO
        return 0.0;
    }

    public static double calculateWallArea(double length, double width, double height) {
        // TODO
        return 0.0;
    }

    public static double calculateTotalPaintableArea(double length, double width, double height, boolean includeCeiling) {
        // TODO
        return 0.0;
    }

    public static int calculatePaintQuantity(double paintableArea, boolean isMetric) {
        // TODO
        return 0;
    }

    public static String generatePaintCostSummary(double surfaceArea, int unitsPaint, boolean isMetric) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO
        
        
        scanner.close();
    }
}