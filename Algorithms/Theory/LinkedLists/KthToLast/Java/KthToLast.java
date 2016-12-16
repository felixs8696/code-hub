import java.util.*;

/*
Description
Find the kth to last element of a singly linked list

Runtime:
Space:

Example:

Input: [format]
[]

Output: [format]
[]
*/

class KthToLast {

  static String kthToLast(Node head, int k) {
    String p1 = head;
    String p2 = head;
    while (k > 0) {
      if (p2 == null)
        return null;
      p2 = p2.next;
    }
    while (p2 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }

  public static void main(String[] args) {

  }
}
