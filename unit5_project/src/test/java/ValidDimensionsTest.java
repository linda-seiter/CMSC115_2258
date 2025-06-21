import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidDimensionsTest {

// --- Tests for areValidDimensions2D ---

    @Test
    @DisplayName("Valid 2D dimensions: length=5.75, width=3.25")
    public void testAreValidDimensions2D_Valid() {
        assertTrue(PaintEstimator.areValidDimensions2D(5.75, 3.25),
            "Expected valid dimensions for length=5.75, width=3.25");
    }

    @Test
    @DisplayName("Invalid 2D dimensions: length=0.0, width=2.5")
    public void testAreValidDimensions2D_LengthZero() {
        assertFalse(PaintEstimator.areValidDimensions2D(0.0, 2.5),
            "Expected invalid dimensions for length=0.0, width=2.5");
    }

    @Test
    @DisplayName("Invalid 2D dimensions: length=4.0, width=-1.25")
    public void testAreValidDimensions2D_WidthNegative() {
        assertFalse(PaintEstimator.areValidDimensions2D(4.0, -1.25),
            "Expected invalid dimensions for length=4.0, width=-1.25");
    }

    @Test
    @DisplayName("Invalid 2D dimensions: length=0.0, width=0.0")
    public void testAreValidDimensions2D_BothZero() {
        assertFalse(PaintEstimator.areValidDimensions2D(0.0, 0.0),
            "Expected invalid dimensions for length=0.0, width=0.0");
    }

    // --- Tests for areValidDimensions3D ---

    @Test
    @DisplayName("Valid 3D dimensions: length=6.5, width=4.25, height=2.75")
    public void testAreValidDimensions3D_Valid() {
        assertTrue(PaintEstimator.areValidDimensions3D(6.5, 4.25, 2.75),
            "Expected valid dimensions for length=6.5, width=4.25, height=2.75");
    }

    @Test
    @DisplayName("Invalid 3D dimensions: height=-0.5")
    public void testAreValidDimensions3D_HeightNegative() {
        assertFalse(PaintEstimator.areValidDimensions3D(5.25, 3.1, -0.5),
            "Expected invalid dimensions for length=5.25, width=3.1, height=-0.5");
    }

    @Test
    @DisplayName("Invalid 3D dimensions: width=0.0")
    public void testAreValidDimensions3D_WidthZero() {
        assertFalse(PaintEstimator.areValidDimensions3D(3.6, 0.0, 2.0),
            "Expected invalid dimensions for length=3.6, width=0.0, height=2.0");
    }

    @Test
    @DisplayName("Invalid 3D dimensions: all zero")
    public void testAreValidDimensions3D_AllZero() {
        assertFalse(PaintEstimator.areValidDimensions3D(0.0, 0.0, 0.0),
            "Expected invalid dimensions for length=0.0, width=0.0, height=0.0");
    }
}