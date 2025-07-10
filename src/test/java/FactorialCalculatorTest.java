import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    @DisplayName("Should return 120 for input 5")
    void testFactorial() {
        assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    @DisplayName("Should throw exception when input is negative")
    void testFactorialWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when input is greater than 20")
    void testFactorialWithTooLargeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(22);
        });
    }
}
