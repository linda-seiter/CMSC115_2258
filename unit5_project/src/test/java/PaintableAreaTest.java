import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class PaintableAreaTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Valid: Include ceiling → 472.0")
    void testAreaWithCeilingIncluded() {
        assertEquals(472.0,
            PaintEstimator.calculateTotalPaintableArea(10.0, 12.0, 8.0, true),
            DELTA,
            "Expected total area: 472.0");
    }

    @Test
    @DisplayName("Valid: Exclude ceiling → 352.0")
    void testAreaWithoutCeiling() {
        assertEquals(352.0,
            PaintEstimator.calculateTotalPaintableArea(10.0, 12.0, 8.0, false),
            DELTA,
            "Expected wall area: 352.0");
    }

    @Test
    @DisplayName("Edge: Zero or negative dimensions → 0.0")
    void testAreaWithInvalidInputs() {
        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(0.0, 10.0, 8.0, true), DELTA, "Length 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(10.0, 0.0, 8.0, true), DELTA, "Width 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(10.0, 12.0, 0.0, true), DELTA, "Height 0 → area should be 0.0");

        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(-10.0, 12.0, 8.0, true), DELTA, "Negative length → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(10.0, -12.0, 8.0, true), DELTA, "Negative width → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateTotalPaintableArea(10.0, 12.0, -8.0, true), DELTA, "Negative height → area should be 0.0");
    }

    @Test
    @DisplayName("Fractional: Include ceiling → 341.4375")
    void testAreaWithFractionalInputs() {
        assertEquals(341.4375,
            PaintEstimator.calculateTotalPaintableArea(5.75, 8.25, 10.5, true),
            DELTA,
            "Expected total area: 341.4375");
    }

    // @Test
    // @DisplayName("Verify method calls: ceiling and wall area")
    // void testCalculatePaintAreaCallsDependencies() {
    //     try (MockedStatic<PaintEstimator> mockedStatic = mockStatic(PaintEstimator.class)) {
    //         mockedStatic.when(() -> PaintEstimator.calculateWallArea(anyDouble(), anyDouble(), anyDouble()))
    //                 .thenReturn(10.0);
    //         mockedStatic.when(() -> PaintEstimator.calculateCeilingArea(anyDouble(), anyDouble())).thenReturn(20.0);
    //         mockedStatic
    //                 .when(() -> PaintEstimator.calculateTotalPaintableArea(anyDouble(), anyDouble(), anyDouble(),
    //                         anyBoolean()))
    //                 .thenCallRealMethod();
    //         PaintEstimator.calculateTotalPaintableArea(12.0, 8.5, 10.0, true);
    //         mockedStatic.verify(() -> PaintEstimator.calculateWallArea(anyDouble(), anyDouble(), anyDouble()),
    //                 atLeastOnce());
    //         mockedStatic.verify(() -> PaintEstimator.calculateCeilingArea(anyDouble(), anyDouble()), atLeastOnce());
    //     }
    // }

    @Test
    @DisplayName("calculateTotalPaintableArea calls calculateWallArea and calculateCeilingArea")
    public void testCalculatePaintAreaMethodCalls() throws Exception {
        // Path to source file - adjust as needed
        File sourceFile = Paths.get("src/main/java/PaintEstimator.java").toFile();

        // Parse the source file
        CompilationUnit cu = StaticJavaParser.parse(sourceFile);

        // Find the calculatePaintArea method
        MethodDeclaration method = cu.findFirst(MethodDeclaration.class, m -> m.getNameAsString().equals("calculateTotalPaintableArea"))
                .orElseThrow(() -> new RuntimeException("Method calculateTotalPaintableArea not found"));

        // Find all method calls inside calculatePaintArea
        List<String> methodCalls = method.findAll(MethodCallExpr.class).stream()
                .map(MethodCallExpr::getNameAsString)
                .collect(Collectors.toList());

        // Assert methods are called
        assertTrue(methodCalls.contains("areValidDimensions3D"),
                "calculateTotalPaintableArea should call areValidDimensions3D");

        assertTrue(methodCalls.contains("calculateCeilingArea"),
                "calculateTotalPaintableArea should call calculateCeilingArea");

        assertTrue(methodCalls.contains("calculateWallArea"),
                "calculateTotalPaintableArea should call calculateWallArea");

    }
}
