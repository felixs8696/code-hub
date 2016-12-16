import java.util.*;
import java.io.*;

/*
Description
Write a function to generate all possible n pairs of balanced parentheses

Answer: Similar to string permutations.

Runtime: O(2^n)
Space: O(2^n)

Example:

Input: n
3

Output: str_arr_as_string
[{{{}}}, {{}{}}, {{}}{}, {}{{}}, {}{}{}]
*/

class BracketPermutations {

  static String[] bracketPermutations(int n) {
    ArrayList<String> result = brackets(n, 0, "", new ArrayList<String>());
    return result.toArray(new String[result.size()]);
  }

  static ArrayList<String> brackets(int open, int close, String arrangement, ArrayList<String> result) {
    if (open == 0 && close == 0) result.add(arrangement);
    if (open > 0) brackets(open - 1, close + 1, arrangement + "{", result);
    if (close > 0) brackets(open, close - 1, arrangement + "}", result);
    return result;
  }

  static String solve(String str) {
    int n = Integer.parseInt(str);
    return Arrays.toString(bracketPermutations(n));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = false;

    BracketPermutations classInstance = new BracketPermutations(); // If non-static methods

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
