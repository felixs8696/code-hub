import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumTrianglePathTest {
  private static final double DELTA = 1e-15;

  @Test
  public void basicTest() {
    MaximumTrianglePath mtp = new MaximumTrianglePath();
    int[][] triangle = {{3,0,0,0}, {7,4,0,0}, {2,4,6,0}, {8,5,9,3}};
    int rows = 4;
    assertEquals(23, mtp.maxSumPath(triangle, rows), DELTA);
  }

  @Test
  public void mediumTest() {
    MaximumTrianglePath mtp = new MaximumTrianglePath();
    int[][] triangle = {{55,0,0,0},{94,48,0,0},{95,30,96,0},{77,71,26,67}};
    int rows = 4;
    assertEquals(321, mtp.maxSumPath(triangle, rows), DELTA);
  }
  
  @Test
  public void largeTest() {
    MaximumTrianglePath mtp = new MaximumTrianglePath();
    int[][] triangle = {{55,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {94,48,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {95,30,96,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {77,71,26,67,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {97,13,76,38,45,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {7,36,79,16,37,68,0,0,0,0,0,0,0,0,0,0,0,0},
                        {48,7,9,18,70,26,6,0,0,0,0,0,0,0,0,0,0,0},
                        {18,72,79,46,59,79,29,90,0,0,0,0,0,0,0,0,0,0},
                        {20,76,87,11,32,7,7,49,18,0,0,0,0,0,0,0,0,0},
                        {27,83,58,35,71,11,25,57,29,85,0,0,0,0,0,0,0,0},
                        {14,64,36,96,27,11,58,56,92,18,55,0,0,0,0,0,0,0},
                        {2,90,3,60,48,49,41,46,33,36,47,23,0,0,0,0,0,0},
                        {92,50,48,2,36,59,42,79,72,20,82,77,42,0,0,0,0,0},
                        {56,78,38,80,39,75,2,71,66,66,1,3,55,72,0,0,0,0},
                        {44,25,67,84,71,67,11,61,40,57,58,89,40,56,36,0,0,0},
                        {85,32,25,85,57,48,84,35,47,62,17,1,1,99,89,52,0,0},
                        {6,71,28,75,94,48,37,10,23,51,6,48,53,18,74,98,15,0},
                        {27,2,92,23,8,71,76,84,15,52,92,63,81,10,44,10,69,93}};
    int rows = 18;
    assertEquals(1320, mtp.maxSumPath(triangle, rows), DELTA);
  }
}
