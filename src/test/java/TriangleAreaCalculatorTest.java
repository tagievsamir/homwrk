import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TriangleAreaCalculatorTest {
    @Test(description = "Should return 5.0 for input base = 2, height = 5")
    void testTriangleAreaCalculator() {
        assertEquals(TriangleAreaCalculator.calculateArea(2, 5), 5.0);
    }

    @DataProvider(name = "dataForBaseHeight")
    public Object[][] dataForBaseHeight() {
        return new Object[][]{
                {0, 1},
                {1, 0},
                {-1, -1}
        };
    }

    @Test(
            description = "Should throw exception when base or height is non-positive",
            dataProvider = "dataForBaseHeight"
    )
    void testTriangleAreaCalculatorNegativeInput(double base, double height) {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.calculateArea(base, height));
    }
}