import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSortTest {
  private static final double DELTA = 1e-15;

  @Test
  public void exampleTest() {
    MergeSort obj = new MergeSort();
    // assertEquals(expected, actual, delta);
    assertEquals(1, 1, DELTA);
  }
}
