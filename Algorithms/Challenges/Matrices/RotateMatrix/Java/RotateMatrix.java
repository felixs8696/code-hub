import java.util.Arrays;

class RotateMatrix {

  private static int[][] transpose(int[][] matrix) {
    int[][] matrixT = new int[matrix[0].length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrixT[j][i] = matrix[i][j];
      }
    }
    return matrixT;
  }

  private static int[][] flipY(int[][] matrix) {
    int targetEnd = matrix.length - 1;
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[targetEnd - i][j];
        matrix[targetEnd - i][j] = temp;
      }
    }
    return matrix;
  }

  private static int[][] flipX(int[][] matrix) {
    int targetEnd = matrix[0].length - 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][targetEnd - j];
        matrix[i][targetEnd - j] = temp;
      }
    }
    return matrix;
  }

  // Rotate left 90 deg if dir == 1, else rotate right 90 deg
  public int[][] rotate(int[][] matrix, int dir) {
    if (matrix.length == 0 || matrix[0].length == 0) return matrix;
    matrix = transpose(matrix);
    if (dir == 1) {
      matrix = flipX(matrix);
    } else {
      matrix = flipY(matrix);
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public static void main(String[] args) {
    int[][] test1 = {{1,2,3},
                     {4,5,6}};
    int[][] sol_1 = {{4,1},
                     {5,2},
                     {6,3}};
    RotateMatrix rm = new RotateMatrix();
    printMatrix(rm.rotate(test1, 1));
    assert rm.rotate(test1, 1) == sol_1;
  }
}
