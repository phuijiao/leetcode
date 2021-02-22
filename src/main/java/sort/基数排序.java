package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/10 8:11 下午 */
class RadixSort {

  public static void main(String[] args) {
    int[] arr = {4, 6, 2, 8, 3, 7, 1, 6};
    radixSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void radixSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int len = arr.length;
    int d = maxBit(arr);
    int[] tmp = new int[len];
    int[] count = new int[10];
    int i, j, k, radix = 1;

    // 进行d次排序
    for (i = 1; i <= d; i++) {
      for (j = 0; j < 10; j++) {
        count[j] = 0; // 每次分配前清空计数器
      }
      for (j = 0; j < len; j++) {
        k = (arr[j] / radix) % 10; // 统计每个桶中记录数
        count[k]++;
      }
      for (j = 1; j < 10; j++) {
        count[j] += count[j - 1]; // 将tmp中的位置依次分配给每个桶
      }
      for (j = len - 1; j >= 0; j--) { // 将所有桶中记录依次收集到tmp中
        k = (arr[j] / radix) % 10;
        tmp[count[k] - 1] = arr[j];
        count[k]--;
      }
      for (j = 0; j < len; j++) { // 将临时数组的内容复制到arr中
        arr[j] = tmp[j];
      }
      radix *= 10;
    }
  }

  // 数组最大值的位数
  private static int maxBit(int[] arr) {
    int maxVal = arr[0];
    for (int i = 1; i < arr.length; i++) {
      maxVal = Math.max(maxVal, arr[i]);
    }
    int bit = 1;
    while (maxVal >= 10) {
      maxVal /= 10;
      bit++;
    }
    return bit;
  }
}
