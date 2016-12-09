import java.util.*;
import java.io.*;

/* Description
 * Stable sort an array of integers using divide and conquer
 * Runtime: Best: O(N log N), Average: O(N log N), Worst: O(N log N)
 * Space: O(N)
 *
 * Example:
 *
 * Input: int_array
 * [1, 6, 7, 4, 5]
 *
 * Output: int_array
 * [1, 4, 5, 6, 7]
**/

class MergeSort {

  static String solve(String str) {
    return "solution";
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    MergeSort classInstance = new MergeSort(); // If non-static methods

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
