package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 11:34 上午 */
class MegerSort {

  public static void main(String[] args) {
    int[] arr = {5, 5, 789, 467, 6, 4, 76, 13, 1};
    megerSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void megerSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int[] result = new int[len];
    megerSort(arr, result, 0, len - 1);
  }

  private static void megerSort(int[] arr, int[] result, int start, int end) {
    if (start >= end) {
      return;
    }
    int len = end - start, mid = (len >> 1) + start;
    int start1 = start, end1 = mid, start2 = mid + 1, end2 = end;
    megerSort(arr, result, start1, end1);
    megerSort(arr, result, start2, end2);
    int k = start;
    while (start1 <= end1 && start2 <= end2) {
      result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
    }
    while (start1 <= end1) {
      result[k++] = arr[start1++];
    }
    while (start2 <= end2) {
      result[k++] = arr[start2++];
    }
    while (start <= end) {
      arr[start] = result[start++];
    }
  }
}
