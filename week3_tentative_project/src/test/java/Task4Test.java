
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

public class Task4Test {

    @Test
    public void gallonsPaintTest() {
        assertEquals(3, PaintCalculator.gallonsPaint(12.0, 15.0, 10.0), "gallonsPaint(12.0, 15.0, 10.0)");
        assertEquals(2, PaintCalculator.gallonsPaint(7.5, 11.5, 8.25), "gallonsPaint(7.5, 11.5, 8.25)");
    }

    @Test
    public void callGraphTest() {
        try (MockedStatic<PaintCalculator> mocked = mockStatic(PaintCalculator.class, Mockito.CALLS_REAL_METHODS)) {
            // Call method
            PaintCalculator.gallonsPaint(12.0, 15.0, 10.0);
            // Verify roomArea called
            mocked.verify(() -> PaintCalculator.roomArea(12.0, 15.0, 10.0), times(1));
        }
    }

}
