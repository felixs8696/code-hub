import java.util.*;
import java.io.*;

/*
Description
Return all integers that appear an odd number of times in an array

Runtime: O(n)
Space: O(n)

Example:

Input: int_array
[]

Output: [format]
[]
*/

class OddCountElements {

  static int[] stringAsIntArr(String str) {
    String[] elems = str.split(" ");
    int[] arr = new int[elems.length];
    for(int i = 0; i < elems.length; i++) {
       arr[i] = Integer.parseInt(elems[i]);
    }
    return arr;
  }

  static String intArrAsString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < arr.length; i++) {
       sb.append(arr[i]);
       if (i != arr.length - 1)
        sb.append(" ");
    }
    return sb.toString();
  }

  public static int[] convertIntegers(TreeSet<Integer> integers){
    int[] ret = new int[integers.size()];
    Iterator<Integer> iterator = integers.iterator();
    for (int i = 0; i < ret.length; i++) ret[i] = iterator.next().intValue();
    return ret;
  }

  public static int[] oddTimeElems(int[] arr) {
    TreeSet<Integer> result = new TreeSet<Integer>();
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i : arr) {
      if (hm.get(i) == null) {
        hm.put(i, 1);
        result.add(i);
      } else {
        hm.put(i, hm.get(i) + 1);
        if (hm.get(i) % 2 == 0)
          result.remove(i);
        else
          result.add(i);
      }
    }
    int[] answer = convertIntegers(result);
    return answer;
  }

  static String solve(String str) {
    int[] arr = stringAsIntArr(str);
    return intArrAsString(oddTimeElems(arr));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    OddCountElements classInstance = new OddCountElements(); // If non-static methods

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
