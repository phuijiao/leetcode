// 快速排序
package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/** @Author jiaopenghui @Date 2021/1/8 8:48 下午 */
class Quicksort {
  public static void main(String[] args) {
    int[] arr = {1, 9, 3, 8, 3, 5, 7, 1, 5, 6, 7, 4, 5};
    quickSort(arr);
    String s = Arrays.toString(arr);
    System.out.println(s);
  }

  public static void quickSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int i = start, j = end, pivot = arr[start];
      while (i < j) {
        // >= 支持重复元素
        while (i < j && arr[j] >= pivot) {
          j--;
        }
        arr[i] = arr[j];
        while (i < j && arr[i] <= pivot) {
          i++;
        }
        arr[j] = arr[i];
      }
      arr[i] = pivot;
      quickSort(arr, start, i - 1);
      quickSort(arr, i + 1, end);
    }
  }
}
