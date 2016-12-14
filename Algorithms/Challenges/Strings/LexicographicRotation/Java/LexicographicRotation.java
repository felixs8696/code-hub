import java.util.*;
import java.io.*;

/*
Description
Given a string return the lexicographic maximum/minimum rotation

Example:

Input: input_string
rotate

Output: output_rotation
terota
*/

class LexicographicRotation {

  static String[] allRotations(String str) {
    int n = str.length();
    String[] arr = new String[n];
    String comboStr = str + str;
    for (int i = 0; i < n; i++) arr[i] = comboStr.substring(i, i+n);
    return arr;
  }

  static String getMaxRotation(String str) {
    String[] rotations = allRotations(str);
    Arrays.sort(rotations);
    return rotations[rotations.length - 1];
  }

  static String getMinRotation(String str) {
    String[] rotations = allRotations(str);
    Arrays.sort(rotations);
    return rotations[0];
  }

  static String solve(String str) {
    String[] params = str.split(" ");
    String inputStr = params[0];
    int i = Integer.parseInt(params[1]);
    if (i == 0) return getMinRotation(inputStr);
    if (i == 1) return getMaxRotation(inputStr);
    return "Invlid Input";
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    LexicographicRotation classInstance = new LexicographicRotation(); // If non-static methods

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
