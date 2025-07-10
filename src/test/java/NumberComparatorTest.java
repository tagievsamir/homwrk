import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    @DataProvider(name = "compareData")
    public Object[][] createData() {
        return new Object[][]{
                {21, 2, "First number is greater"},
                {-6, 3, "Second number is greater"},
                {0, 0, "Numbers are equal"}
        };
    }

    @Test(
            description = "Should correctly compare two integers",
            dataProvider = "compareData"
    )
    void testCompare(int a, int b, String expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }
}