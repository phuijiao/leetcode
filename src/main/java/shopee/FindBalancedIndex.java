package shopee;

public class FindBalancedIndex {
  //[1,2,3,4,6] 3
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,6};
    int res = findBalancedIndex(arr);
    System.out.println(res);
  }
  public static int findBalancedIndex(int[] inputArray) {
    int len = inputArray.length;
    long left = inputArray[0], right = 0;
    for (int i = 2; i < len; i++) {
      right += inputArray[i];
    }
    for (int i = 1; i < len - 1; i++) {
      if (left == right) {
        return i;
      }
      left += inputArray[i];
      right -= inputArray[i+1];
    }

    return -1;
  }
}
