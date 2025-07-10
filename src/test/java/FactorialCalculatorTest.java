import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTest {
    @Test(description = "Should return 120 for input 5")
    void testFactorial() {
        assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test(description = "Should throw exception when input is negative")
    void testFactorialWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
    }

    @Test(description = "Should throw IllegalArgumentException when input is greater than 20")
    void testFactorialWithTooLargeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(22);
        });
    }
}