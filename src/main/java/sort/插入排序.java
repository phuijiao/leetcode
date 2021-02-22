package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 3:57 下午 */
class InsertSort {
  public static void main(String[] args) {
    int[] arr = {5, 5, 5, 481, 26, 127, 5, 16, 1, 748, 8};
    int[] arr1 = {5, 5, 5, 481, 26, 127, 5, 16, 1, 748, 8};
    insertSort(arr);
    System.out.println(Arrays.toString(arr));
    binaryInsertSort(arr1);
    System.out.println(Arrays.toString(arr1));
  }

  // 直接插入排序
  public static void insertSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int tmp, i, j;
    for (i = 1; i < len; i++) {
      tmp = arr[i];
      for (j = i - 1; j >= 0; j--) {
        if (arr[j] > tmp) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = tmp;
    }
  }

  // 二分插入排序
  public static void binaryInsertSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int key, left, right, mid;
    for (int i = 1; i < len; i++) {
      key = arr[i];
      left = 0;
      right = i - 1;
      while (left <= right) {
        mid = left + ((right - left) >> 1);
        if (arr[mid] > key) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      for (int j = i - 1; j >= left; j--) {
        arr[j + 1] = arr[j];
      }
      arr[left] = key;
    }
  }
}
