import org.junit.Test;
import static org.junit.Assert.*;

public class FixedArrayQueueTest {
  private static final double DELTA = 1e-15;

  @Test
  public void exampleTest() {
    FixedArrayQueue faq = new FixedArrayQueue(5);
    try {
      for (int i = 1; i <= 5; i++) faq.push(i);
      assertEquals(1, faq.pop(), DELTA);
      faq.push(6);
      System.out.println(faq.toString());
      int[] arr = {2,3,4,5,6};
      // assertEquals(expected, actual, delta);
      assertArrayEquals(arr, faq.toArray());
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }

  }
}
