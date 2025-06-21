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

public class CeilingAreaTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Valid: 10.0 x 12.0 → 120.0")
    void testCeilingAreaWithValidInputs() {
        assertEquals(120.0, PaintEstimator.calculateCeilingArea(10.0, 12.0), DELTA,
                "Expected area: 120.0");
    }

    @Test
    @DisplayName("Edge: Zero and negative dimensions → 0.0")
    void testCeilingAreaWithEdgeCases() {
        assertEquals(0.0, PaintEstimator.calculateCeilingArea(0.0, 10.0), DELTA,
                "Length 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateCeilingArea(10.0, 0.0), DELTA,
                "Width 0 → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateCeilingArea(-10.0, 12.0), DELTA,
                "Negative length → area should be 0.0");
        assertEquals(0.0, PaintEstimator.calculateCeilingArea(10.0, -12.0), DELTA,
                "Negative width → area should be 0.0");

        double largeExpected = 1_000_000_000_000.0;
        assertEquals(largeExpected, PaintEstimator.calculateCeilingArea(1_000_000, 1_000_000), DELTA,
                "Large values → area should be 1,000,000,000,000.0");
    }

    @Test
    @DisplayName("Fractional: 5.75 x 8.25 → 47.4375")
    void testCeilingAreaWithFractionalInputs() {
        assertEquals(47.4375, PaintEstimator.calculateCeilingArea(5.75, 8.25), DELTA,
                "Expected area: 47.4375");

        assertEquals(55.5, PaintEstimator.calculateCeilingArea(6.0, 9.25), DELTA,
                "Expected area: 55.5");
    }

    @Test
    @DisplayName("calculateCeilingArea calls areValidDimensions2D")
    public void testCalculateCeilingAreaMethodCalls() throws Exception {
        // Path to source file - adjust as needed
        File sourceFile = Paths.get("src/main/java/PaintEstimator.java").toFile();

        // Parse the source file
        CompilationUnit cu = StaticJavaParser.parse(sourceFile);

        // Find the calculatePaintArea method
        MethodDeclaration method = cu.findFirst(MethodDeclaration.class, m -> m.getNameAsString().equals("calculateCeilingArea"))
                .orElseThrow(() -> new RuntimeException("Method calculateCeilingArea not found"));

        // Find all method calls inside calculateCeilingArea
        List<String> methodCalls = method.findAll(MethodCallExpr.class).stream()
                .map(MethodCallExpr::getNameAsString)
                .collect(Collectors.toList());

        // Assert method is called
        assertTrue(methodCalls.contains("areValidDimensions2D"),
                "calculateCeilingArea should call areValidDimensions2D");

    }
}
