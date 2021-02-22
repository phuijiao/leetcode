package leetcode.editor.cn;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/8 5:39 下午 */
public class Demo1 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 2, 7, 4, 3};
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static int[] sort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }
    sort(arr, 0, arr.length - 1);
    return arr;
  }

  private static void sort(int[] arr, int i, int j) {
    int a = i, b = j;
    if (i >= j) {
      return;
    }
    int index = i;
    int tmp = arr[index];

    while (i < j) {
      while (i < j) {
        if (arr[j] < tmp) {
          break;
        } else {
          j--;
        }
      }

      while (i < j) {
        if (arr[i] > tmp) {
          break;
        } else {
          i++;
        }
      }
      arr[index] = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
    }
    sort(arr, a, i - 1);
    sort(arr, i + 1, b);
  }
}
