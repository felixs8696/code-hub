import org.junit.Test;
import static org.junit.Assert.*;

public class OddCountElementsTest {
  private static final double DELTA = 1e-15;

  @Test
  public void exampleTest() {
    int[] arr = { 5, 1, 2, 4, 4, 3, 4, 1, 5 };
    int[] result = { 2, 3, 4 };

    OddCountElements oce = new OddCountElements();

    // assertEquals(expected, actual, delta);
    assertArrayEquals(result, oce.oddTimeElems(arr));
  }
}
