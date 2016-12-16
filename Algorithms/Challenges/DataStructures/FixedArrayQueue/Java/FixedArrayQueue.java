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

class FixedArrayQueue {
  int capacity;
  int size;
  int head;
  int[] queue;

  public FixedArrayQueue(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.head = 0;
      this.queue = new int[capacity];
  }

  public int pop() throws Exception {
      if (size == 0) throw new Exception();
      int result = queue[head];
      head = (head + 1) % capacity;
      size--;
      return result;
  }

  public void push(int elem) throws Exception {
      if (size == capacity) throw new Exception();
      queue[(head + size) % capacity] = elem;
      size++;
  }

  public int peek() throws Exception {
      if (size == 0) throw new Exception();
      return queue[head];
  }

  public boolean isEmpty() {
      return size == 0;
  }

  public String toString() {
    int[] result = new int[size];
    StringBuilder str = new StringBuilder();
    str.append('[');
    for (int i = 0; i < capacity; i++) {
      str.append(queue[i]);
      if (i < capacity - 1) str.append(' ');
    }
    str.append(']');
    return str.toString();
  }

  public int[] toArray() {
    int[] result = new int[size];
    for (int i = head; i < head + size; i++) {
      result[i - head] = queue[i % capacity];
    }
    return result;
  }

  static String solve(String str) {
    return "solution";
  }

  public static void main(String[] args) throws IOException, FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader("io/tests.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("io/solution.txt"));
    boolean debug = true;

    FixedArrayQueue classInstance = new FixedArrayQueue(5); // If non-static methods

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
