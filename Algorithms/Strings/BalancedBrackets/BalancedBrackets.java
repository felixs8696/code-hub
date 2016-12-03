import java.util.*;
import java.io.*;

class BalancedBrackets{
  HashSet<Character> openBrackets;
  HashSet<Character> closedBrackets;

  // Edge Cases: Pop from empty stack, Empty input
  public BalancedBrackets() {
    openBrackets = new HashSet<Character>();
    openBrackets.add('(');
    openBrackets.add('{');
    openBrackets.add('[');

    closedBrackets = new HashSet<Character>();
    closedBrackets.add(')');
    closedBrackets.add('}');
    closedBrackets.add(']');
  }

  private boolean isMatch(char open, char closed) {
    if ((open == '(' && closed == ')') || (open == '{' && closed == '}') || (open == '[' && closed == ']'))
      return true;
    return false;
  }

  public boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (openBrackets.contains(c)) {
        stack.push(c);
      } else if (closedBrackets.contains(c)) {
        if (stack.isEmpty()) return false;
        char prev = stack.pop();
        if (!isMatch(prev, c)) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));

    BalancedBrackets bb = new BalancedBrackets();
    boolean debug = true;

    String test;
    while ( (test = br.readLine()) != null ) {
      String solution = String.valueOf(bb.isBalanced(test));
      if (debug) solution +=  ": '" + test + "'";
      bw.write(solution);
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
