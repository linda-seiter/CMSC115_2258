
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void ceilingAreaTest() {
        double delta = 0.000001;

        assertEquals(180.0, PaintCalculator.ceilingArea(12.0, 15.0), delta, "ceilingArea(12.0, 15.0)");
        assertEquals(86.25, PaintCalculator.ceilingArea(7.5, 11.5), delta, "ceilingArea(7.5, 11.5)");
    }

}
