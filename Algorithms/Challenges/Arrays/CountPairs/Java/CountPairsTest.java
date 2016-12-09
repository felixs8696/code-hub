import org.junit.Test;
import static org.junit.Assert.*;

public class CountPairsTest {
  private static final double DELTA = 1e-15;

  @Test
  public void distinctTest() {
    int[] arr = {1,2,3,4,5,6};
    int k = 5;
    CountPairs cp = new CountPairs();
    assertEquals(2, cp.countPairs(arr, k), DELTA);
  }

  @Test
  public void duplicateTest() {
    int[] arr = {2,2,2};
    int k = 4;
    CountPairs cp = new CountPairs();
    assertEquals(3, cp.countPairs(arr, k), DELTA);
  }

  @Test
  public void largeTest() {
    int[] arr = new int[100000];
    for (int i = 1; i <= arr.length; i++) arr[i - 1] = i;
    int k = 4;
    CountPairs cp = new CountPairs();
    assertEquals(1, cp.countPairs(arr, k), DELTA);
  }
}
