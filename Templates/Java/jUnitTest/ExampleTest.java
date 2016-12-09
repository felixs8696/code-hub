import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {
  private static final double DELTA = 1e-15;

  @Test
  public void exampleTest() {
    Example obj = new Example();
    // assertEquals(expected, actual, delta);
    assertEquals(1, 1, DELTA);
  }
}
