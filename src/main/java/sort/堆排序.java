package sort;

import java.util.Arrays;

/** @Author jiaopenghui @Date 2021/1/9 10:03 上午 */
class HeapSort {

  public static void main(String[] args) {
    int[] arr = {1, 9, 3, 8, 4, 5, 6, 7, 2, 5, 1, 3, 4, 2, 4, 7, 5, 2, 1};
    maxHeapSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  // 大顶堆 升序
  public static void maxHeapSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int len = arr.length;
    // 构建大顶堆，这里是把待排序数组变成一个大顶堆结构的数组
    for (int i = (len / 2 - 1); i >= 0; i--) {
      // 从第一个非叶子节点从下至上，从右至左调整结构
      heapify(arr, i, len);
    }

    // 交换堆顶和当前末尾的节点，重置大顶堆
    for (int i = (len - 1); i > 0; i--) {
      swap(arr, 0, i);
      heapify(arr, 0, i);
    }
  }

  private static void heapify(int[] arr, int i, int len) {
    // 取出当前元素i
    int tmp = arr[i];

    // 从i节点的左子节点开始，也就是2i+1开始
    for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
      // 如果左子节点小于右子节点，则k指向右子节点
      if (k + 1 < len && arr[k] < arr[k + 1]) {
        k++;
      }
      // 如果子节点的值大于父节点，则将子节点的值赋给父节点 （不用交换）
      if (arr[k] > tmp) {
        arr[i] = arr[k];
        i = k;
      }
    }
    // 将tmp放到最终的位置
    arr[i] = tmp;
  }

  // 交换数组中两个元素
  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
