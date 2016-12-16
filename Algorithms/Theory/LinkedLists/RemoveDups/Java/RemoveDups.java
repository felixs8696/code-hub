import java.util.*;

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

  static LinkedList<E> removeDups(LinkedList<E> ll) {
    HashSet<E> set = new HashSet<E>();
    LinkedList<E> newLL = new LinkedList<E>();
    Iterator iter = ll.iterator();
    while(iter.hasNext()) {
      E elem = (E) iter.next();
      if (!set.contains(elem)) {
        newLL.add(elem);
        set.add(elem);
      }
    }
    return newLL;
  }

  public static void main(String[] args) {

  }
}
