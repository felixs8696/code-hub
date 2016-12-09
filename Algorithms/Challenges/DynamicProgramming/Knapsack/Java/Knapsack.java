import java.util.*;
import java.io.*;

/* Description
 * Given a list of n items, each with w_i and dollar value v_i, and a weight
 * capacity W, what is the most valuable combination of items?
 *
 * Example:
 *
 * Input: weights_array; value_array; W
 * 6 3 4 2; 30 14 16 9; 10
 *
 * Output: item_nums, value
 * 1 3; 46
**/

class Knapsack {

  static int[] stringAsIntArr(String str) {
    String[] elems = str.split(" ");
    int[] arr = new int[elems.length];
    for(int i = 0; i < elems.length; i++) {
       arr[i] = Integer.parseInt(elems[i]);
    }
    return arr;
  }

  static int knapsackWithRepetition(int[] weights, int[] values, int W) {
    int[] K = new int[W + 1];
    for (int w = 1; w <= W; w++) {
      for (int i = 1; i <= values.length; i++) {
        if (weights[i-1] <= w)
          K[w] = Math.max(values[i-1] + K[w - weights[i-1]],  K[w]);
        else if (K[w - 1] > K[w])
          K[w] = K[w - 1];
      }
    }
    return K[W];
  }

  static int knapsackWithoutRepetition(int[] weights, int[] values, int W) {
    int[][] K = new int[W + 1][values.length + 1];
    for (int w = 1; w <= W; w++) {
      for (int i = 1; i <= values.length; i++) {
        if (weights[i-1] <= w)
          K[w][i] = Math.max(values[i-1] + K[w - weights[i-1]][i - 1],  K[w][i - 1]);
        else
          K[w][i] = K[w][i - 1];
      }
    }
    return K[W][values.length];
  }

  static String solve(String str) {
    String[] params = str.split("; ");
    int[] weights = stringAsIntArr(params[0]);
    int[] values = stringAsIntArr(params[1]);
    int W = Integer.parseInt(params[2]);
    return String.valueOf(knapsackWithoutRepetition(weights, values, W));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    Knapsack classInstance = new Knapsack(); // If non-static methods

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
