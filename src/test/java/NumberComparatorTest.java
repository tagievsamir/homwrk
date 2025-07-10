import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {
    @DisplayName("Should correctly compare two integers")
    @ParameterizedTest(name = "compare {0}, {1} -> {2}")
    @CsvSource({
            "21, 2, First number is greater",
            "-6, 3, Second number is greater",
            "0, 0, Numbers are equal"
    })
    void testCompare(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }
}