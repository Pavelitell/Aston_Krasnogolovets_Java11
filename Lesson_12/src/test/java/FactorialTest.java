import org.example.Factorial;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FactorialTest {

    private Factorial math;
    @BeforeTest
    public void init() {
        math = new Factorial(); }
    @AfterTest
    public void tearDown() {
        math = null; }
    @Test
    public void calls() {
        assertEquals(0, math.getCalls());
        math.getFactorial(1);
        assertEquals(1, math.getCalls());
        math.getFactorial(1);
        assertEquals(2, math.getCalls());
    }
    @Test
    public void factorial() {
        assertTrue(math.getFactorial(0) == 1);
        assertTrue(math.getFactorial(1) == 1);
        assertTrue(math.getFactorial(5) == 120);
    }

}

