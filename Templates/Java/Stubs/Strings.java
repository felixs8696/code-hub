class Strings {

  static int[] stringAsIntArr(String str) {
    String[] elems = str.split(" ");
    int[] arr = new int[elems.length];
    for(int i = 0; i < elems.length; i++)
       arr[i] = Integer.parseInt(elems[i]);
    return arr;
  }

  static String intArrAsString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < arr.length; i++) {
       sb.append(arr[i]);
       if (i != arr.length - 1) sb.append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {}

}
