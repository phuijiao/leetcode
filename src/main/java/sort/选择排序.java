package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 11:35 上午 */
class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {8, 564, 84, 51, 574, 845, 15, 48, 45, 15, 154, 84, 65};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int min, tmp;
    for (int i = 0; i < len - 1; i++) {
      min = i;
      for (int j = i + 1; j < len; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      tmp = arr[i];
      arr[i] = arr[min];
      arr[min] = tmp;
    }
  }
}
