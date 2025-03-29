import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatePaintCostTest {

    @Test
    @DisplayName("Test Calculate Paint Cost for a Given Surface Area")
    public void testCalculatePaintCost() {
        // Test case 1: Valid surface area
        double surfaceArea1 = 700.0; // Surface area of 700 square feet
        double expectedCost1 = 101.5; // Hardcoded expected cost for 700 sq ft
        assertEquals(expectedCost1, RoomPaintingCostCalculator.calculatePaintCost(surfaceArea1), 0.01);

        // Test case 2: Surface area is 0 (no paint needed)
        double surfaceArea2 = 0.0; // No surface area to paint
        double expectedCost2 = 0.0; // No cost should be expected
        assertEquals(expectedCost2, RoomPaintingCostCalculator.calculatePaintCost(surfaceArea2), 0.01);

        // Test case 3: Large surface area
        double surfaceArea3 = 1100.0; // Surface area of 1100 square feet
        double expectedCost3 = 159.5; // Hardcoded expected cost for 1400 sq ft
        assertEquals(expectedCost3, RoomPaintingCostCalculator.calculatePaintCost(surfaceArea3), 0.01);
    }
}
