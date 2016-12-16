import java.util.*;
import java.io.*;

/*
Description
Remove duplicates from an unsorted linked list. What if temp buffer not allowed?

Runtime:
Space:

Example:

Input: elements_in_linked_list
1 4 5 2 3 1 2 4

Output: pruned_linked_list
1 4 5 2 3
*/

class RemoveDups {

  static LinkedList<String> stringArrayToLinkedList(String[] str) {
    LinkedList<String> newLL = new LinkedList<String>();
    for (String s : str) newLL.add(s);
    return newLL;
  }

  static String linkedListToString(LinkedList<String> ll) {
    Iterator iter = ll.iterator();
    StringBuilder str = new StringBuilder();
    while(iter.hasNext()) {
      String elem = (String) iter.next();
      str.append(String.valueOf(elem) + ' ');
    }
    str.deleteCharAt(str.length() - 1);
    return str.toString();
  }

  static LinkedList<String> removeDups(LinkedList<String> ll) {
    HashSet<String> set = new HashSet<String>();
    LinkedList<String> newLL = new LinkedList<String>();
    Iterator iter = ll.iterator();
    while(iter.hasNext()) {
      String elem = (String) iter.next();
      if (!set.contains(elem)) {
        newLL.add(elem);
        set.add(elem);
      }
    }
    return newLL;
  }

  static String solve(String str) {
    String[] params = str.split(" ");
    return linkedListToString(removeDups(stringArrayToLinkedList(params)));
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    RemoveDups classInstance = new RemoveDups(); // If non-static methods

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
