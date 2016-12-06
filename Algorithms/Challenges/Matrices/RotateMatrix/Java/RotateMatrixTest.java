import org.junit.Test;
import static org.junit.Assert.*;

public class RotateMatrixTest {
  private static final double DELTA = 1e-15;

  @Test
  public void emptyMatrixTest() {
   int[][] test1 = {{}};
   int[][] sol_1 = {{}};
   RotateMatrix rm1 = new RotateMatrix();
   assertArrayEquals(rm1.rotate(test1, 1), sol_1);

   RotateMatrix rm2 = new RotateMatrix();
   assertArrayEquals(rm2.rotate(test1, 0), sol_1);
  }

  @Test
  public void squareMatrixRightTest() {
   int[][] test1 = {{1,2,3}, {4,5,6}, {7,8,9}};
   int[][] sol_1 = {{7,4,1}, {8,5,2}, {9,6,3}};
   RotateMatrix rm = new RotateMatrix();
   assertArrayEquals(rm.rotate(test1, 1), sol_1);
  }

  @Test
  public void squareMatrixLeftTest() {
   int[][] test1 = {{1,2,3}, {4,5,6}, {7,8,9}};
   int[][] sol_1 = {{3,6,9}, {2,5,8}, {1,4,7}};
   RotateMatrix rm = new RotateMatrix();
   assertArrayEquals(rm.rotate(test1, 0), sol_1);
  }

  @Test
  public void nonSquareMatrixRightTest() {
   int[][] test1 = {{1,2,3}, {4,5,6}};
   int[][] sol_1 = {{4,1}, {5,2}, {6,3}};
   RotateMatrix rm = new RotateMatrix();
   assertArrayEquals(rm.rotate(test1, 1), sol_1);
  }

  @Test
  public void nonSquareMatrixLefttTest() {
   int[][] test1 = {{1,2,3}, {4,5,6}};
   int[][] sol_1 = {{3,6}, {2,5}, {1,4}};
   RotateMatrix rm = new RotateMatrix();
   assertArrayEquals(rm.rotate(test1, 0), sol_1);
  }
}
