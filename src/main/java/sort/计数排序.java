package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/10 5:11 下午 */
class CountSort {
  public static void main(String[] args) {
    int[] arr = {8, 4, 64, 54, 864, 651, 54, 87, 65, 6, 26, 6};
    countSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void countSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    int min = arr[0], max = arr[0];
    for (int i = 1; i < len; i++) {
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }
    int countLen = max - min + 1;
    int[] count = new int[countLen];
    for (int i = 0; i < len; i++) {
      count[arr[i] - min]++;
    }
    int index = 0;
    for (int i = 0; i < countLen; i++) {
      for (int j = 0; j < count[i]; j++) {
        arr[index++] = i + min;
      }
    }
  }
}
