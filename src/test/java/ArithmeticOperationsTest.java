import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ArithmeticOperationsTest {
    @Test(description = "Should return 5 when adding 2 and 3")
    void testAddition() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test(description = "Should return 3 for 5 minus 2")
    void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(5, 2), 3);
    }

    @Test(description = "Should return 6 when multiplying 2 and 3")
    void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
    }

    @Test(description = "Should return 4 when dividing 8 by 2")
    void testDivide() {
        assertEquals(ArithmeticOperations.divide(8, 2), 4);
    }

    @Test(description = "Should throw ArithmeticException when dividing by 0")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}