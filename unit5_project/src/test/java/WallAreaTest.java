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

public class WallAreaTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Valid: 10.0 x 12.0 x 8.0 → 352.0")
    void testCalculateWallAreaWithPositiveInputs() {
        assertEquals(352.0, PaintEstimator.calculateWallArea(10.0, 12.0, 8.0), DELTA,
                "Expected wall area: 352.0");
    }

    @Test
    @DisplayName("Edge: Zero or negative dimensions → 0.0")
    void testCalculateWallAreaWithEdgeCases() {
        assertEquals(0.0, PaintEstimator.calculateWallArea(0.0, 10.0, 8.0), DELTA,
                "Length 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateWallArea(10.0, 0.0, 8.0), DELTA,
                "Width 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateWallArea(10.0, 12.0, 0.0), DELTA,
                "Height 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateWallArea(-10.0, 12.0, 8.0), DELTA,
                "Negative length → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateWallArea(10.0, -12.0, 8.0), DELTA,
                "Negative width → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateWallArea(10.0, 12.0, -8.0), DELTA,
                "Negative height → area should be 0.0");
    }

    @Test
    @DisplayName("Fractional: 5.75 x 8.25 x 10.5 → 294.0")
    void testCalculateWallAreaWithFractionalInputs() {
        assertEquals(294.0, PaintEstimator.calculateWallArea(5.75, 8.25, 10.5), DELTA,
                "Expected wall area: 294.0");

        assertEquals(266.875, PaintEstimator.calculateWallArea(6.0, 9.25, 8.75), DELTA,
                "Expected wall area: 266.875");
    }

    @Test
    @DisplayName("calculateWallArea calls areValidDimensions3D")
    public void testCalculateCeilingAreaMethodCalls() throws Exception {
        // Path to source file - adjust as needed
        File sourceFile = Paths.get("src/main/java/PaintEstimator.java").toFile();

        // Parse the source file
        CompilationUnit cu = StaticJavaParser.parse(sourceFile);

        // Find the calculatePaintArea method
        MethodDeclaration method = cu.findFirst(MethodDeclaration.class, m -> m.getNameAsString().equals("calculateWallArea"))
                .orElseThrow(() -> new RuntimeException("Method calculateWallArea not found"));

        // Find all method calls inside calculateWallArea
        List<String> methodCalls = method.findAll(MethodCallExpr.class).stream()
                .map(MethodCallExpr::getNameAsString)
                .collect(Collectors.toList());

        // Assert method is called
        assertTrue(methodCalls.contains("areValidDimensions3D"),
                "calculateCeilingArea should call areValidDimensions3D");

    }
}
