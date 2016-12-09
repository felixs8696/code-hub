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

class BufferedIOTemplate {

  static String solve(String str) {
    return "solution";
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    BufferedIOTemplate classInstance = new BufferedIOTemplate(); // If non-static methods

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
