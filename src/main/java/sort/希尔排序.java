package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 3:49 下午 */
class ShellSort {

  public static void main(String[] args) {
    int[] arr = {5, 5, 65, 6, 25, 6, 6, 2, 6, 59, 56, 26, 59, 53};
    shellSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  // 2倍步长
  public static void shellSort1(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int len = arr.length;
    int gap, i, j, tmp;
    for (gap = len >> 1; gap > 0; gap >>= 1) {
      for (i = gap; i < len; i++) {
        tmp = arr[i];
        for (j = i - gap; j >= 0 && arr[j] > tmp; j -= gap) {
          arr[j + gap] = arr[j];
        }
        arr[j + gap] = tmp;
      }
    }
  }

  // 3倍步长
  public static void shellSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int gap = 1, i, j, tmp, len = arr.length;
    while (gap < len / 3) {
      gap = gap * 3 + 1;
    }
    for (; gap > 0; gap /= 3) {
      for (i = gap; i < len; i++) {
        tmp = arr[i];
        for (j = i - gap; j >= 0 && arr[j] > tmp; j -= gap) {
          arr[j + gap] = arr[j];
        }
        arr[j + gap] = tmp;
      }
    }
  }
}
