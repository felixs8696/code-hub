import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest {
  private static final double DELTA = 1e-15;

  @Test
  public void exampleTest() {
    Factorial obj = new Factorial();
    // assertEquals(expected, actual, delta);
    assertEquals(1, 1, DELTA);
  }
}
