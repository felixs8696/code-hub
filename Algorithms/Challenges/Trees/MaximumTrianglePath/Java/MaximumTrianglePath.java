import java.util.*;
import java.io.*;

/*
Description
By starting at the top of the triangle below and moving to adjacent numbers
on the row below, find the maximum total from top to bottom of the triangle.

Runtime:
Space:

Example:

Input: num_rows; row_1; row_2; ...; row_n
4; 3; 7 4; 2 4 6; 8 5 9 3

Output: max_sum
23
*/

class MaximumTrianglePath {

  static int maxSumPath(int[][] triangle, int rows) {
    int[][] sums = new int[rows][rows];
    sums[rows - 1] = triangle[rows - 1];
    for (int i = rows - 1; i > 0; i--)
      for (int j = 0; j < i; j++)
        sums[i - 1][j] = Math.max(sums[i][j] + triangle[i - 1][j], sums[i][j + 1] + triangle[i - 1][j]);
    return sums[0][0];
  }

  static String solve(String str) {
    String[] params = str.split("; ");
    int N = Integer.parseInt(params[0]);
    int[][] triangle = new int[N][N];
    for (int j = 1; j <= N; j++) {
      String[] row = params[j].split(" ");
      for (int k = 0; k < row.length; k++)
        triangle[j - 1][k] = Integer.parseInt(row[k]);
    }
    return String.valueOf(maxSumPath(triangle, N));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    MaximumTrianglePath classInstance = new MaximumTrianglePath(); // If non-static methods

    String test;
    while ( (test = br.readLine()) != null ) {
      String solution = String.valueOf(solve(test));
      if (debug) solution +=  ": '" + test + "'";
      bw.write(solution);
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
