
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

public class Task3Test {

    @Test
    public void roomAreaTest() {
        double delta = 0.000001;

        assertEquals(720, PaintCalculator.roomArea(12.0, 15.0, 10.0), delta, "roomArea(12.0, 15.0, 10.0");
        assertEquals(399.75, PaintCalculator.roomArea(7.5, 11.5, 8.25), delta, "roomArea(7.5, 11.5, 8.25)");
    }

    @Test
    public void callGraphTest() {
        try (MockedStatic<PaintCalculator> mocked = mockStatic(PaintCalculator.class, Mockito.CALLS_REAL_METHODS)) {
            // Call method
            PaintCalculator.roomArea(12.0, 15.0, 10.0);
            // Verify ceilingArea and wallArea calls
            mocked.verify(() -> PaintCalculator.ceilingArea(12.0, 15.0), times(1));
            mocked.verify(() -> PaintCalculator.wallArea(12.0, 15.0, 10.0), times(1));
        }
    }

}
