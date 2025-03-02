
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void wallAreaTest() {
        double delta = 0.000001;

        assertEquals(540.0, PaintCalculator.wallArea(12.0, 15.0, 10.0), delta, "wallArea(12.0, 15.0, 10.0)");
        assertEquals(313.5, PaintCalculator.wallArea(7.5, 11.5, 8.25), delta, "wallArea(7.5, 11.5, 8.25)");
    }

}
