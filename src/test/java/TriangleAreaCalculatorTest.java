import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorTest {
    @Test
    @DisplayName("Should return 5.0 for input base = 2, height = 5")
    void testTriangleAreaCalculator() {
        assertEquals(5.0, TriangleAreaCalculator.calculateArea(2, 5));
    }

    @DisplayName("Should throw exception when base or height is non-positive")
    @ParameterizedTest(name = "base: {0}, height: {1} - should throw exception")
    @CsvSource({"0, 1", "1, 0", "-1, -1"})
    void testTriangleAreaCalculatorNegativeInput(double base, double height) {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(base, height));
    }
}