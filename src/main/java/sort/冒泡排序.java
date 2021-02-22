package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 11:35 上午 */
class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {9, 5, 66, 4, 4, 63, 57, 4, 626589, 89, 9, 546, 56, 59, 89, 596, 59, 596, 5, 9};
    //    int[] arr = {1, 2, 3, 4, 5};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
  // 基本冒泡排序
  public static void bubbleSort1(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int tmp;
    for (int i = 0; i < len - 1; i++) {
      for (int j = 1; j < (len - i); j++) {
        if (arr[j - 1] > arr[j]) {
          tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }

  // 无交换时退出
  public static void bubbleSort2(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int tmp;
    boolean exchange;
    for (int i = 0; i < len - 1; i++) {
      exchange = false;
      for (int j = 1; j < (len - i); j++) {
        if (arr[j - 1] > arr[j]) {
          tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
          exchange = true;
        }
      }
      if (!exchange) {
        return;
      }
    }
  }

  // 记录最后一个交换的位置
  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int tmp, k;
    while (len > 0) {
      k = len;
      len = 0;
      for (int i = 1; i < k; i++) {
        if (arr[i - 1] > arr[i]) {
          tmp = arr[i - 1];
          arr[i - 1] = arr[i];
          arr[i] = tmp;
          len = i;
        }
      }
    }
  }
}
