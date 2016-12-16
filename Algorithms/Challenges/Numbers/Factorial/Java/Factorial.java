import java.util.*;
import java.io.*;

/*
Description

Runtime:
Space:

Example:

Input: [format]
[]

Output: [format]
[]
*/

class Factorial {

  static long factorial(long n) {
    if (n < 0) return -1;
    if (n == 0) return 1;
    return n * factorial(n - 1);
  }

  static String solve(String str) {
    long n = Long.parseLong(str);
    return String.valueOf(factorial(n));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    Factorial classInstance = new Factorial(); // If non-static methods

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
