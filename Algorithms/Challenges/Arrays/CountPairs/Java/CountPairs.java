import java.util.*;
import java.io.*;

/* Description
 * Given an array of integers, and a number k, find the number of pairs of
 * integers in the array whose sum is equal to k.
 *
 * Example:
 *
 * Input: 1 2 3 4 5 6; k
 * 1 2 3 4 5 6; 5
 *
 * Output: num_of_pairs
 * 2
**/

class CountPairs {

  static int[] stringAsIntArr(String str) {
    String[] elems = str.split(" ");
    int[] arr = new int[elems.length];
    for(int i = 0; i < elems.length; i++) {
       arr[i] = Integer.parseInt(elems[i]);
    }
    return arr;
  }

  static int countPairs(int[] arr, int k) {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int count = 0;
    for (int i : arr) {
        if (hm.get(i) == null)
            hm.put(i, 1);
        else
            hm.put(i, hm.get(i) + 1);
    }
    for (int i : arr) {
        if (hm.get(k - i) != null) {
            if (i == k - i) {
                int num = hm.get(i) - 1;
                count += (num * (num + 1));
                hm.remove(i);
            } else {
                count++;
            }
        }
    }
    return count / 2;
  }

  static String solve(String str) {
    String[] params = str.split("; ");
    int[] arr = stringAsIntArr(params[0]);
    int k = Integer.parseInt(params[1]);
    return String.valueOf(countPairs(arr, k));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    CountPairs classInstance = new CountPairs(); // If non-static methods

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
