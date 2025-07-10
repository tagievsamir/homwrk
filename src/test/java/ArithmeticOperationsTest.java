import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {
    @Test
    @DisplayName("Should return 5 when adding 2 and 3")
    void testAddition() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    @DisplayName("Should return 3 for 5 minus 2")
    void testSubtract() {
        assertEquals(3, ArithmeticOperations.subtract(5, 2));
    }

    @Test
    @DisplayName("Should return 6 when multiplying 2 and 3")
    void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
    }

    @Test
    @DisplayName("Should return 4 when dividing 8 by 2")
    void testDivide() {
        assertEquals(4, ArithmeticOperations.divide(8, 2));
    }

    @Test
    @DisplayName("Should throw ArithmeticException when dividing by 0")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}