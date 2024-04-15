import org.example.Factorial;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactorialTest {

    private Factorial math;
    @BeforeEach
    public void init() { math = new Factorial(); }
    @AfterEach
    public void tearDown() { math = null; }
    @AfterAll
    public static void endMessege(){
        System.out.println("Тесты окончены");
    }

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
