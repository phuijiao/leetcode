// 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
// 值排序之后中间两个数的平均值。
//
// 例如，
//
// [2,3,4] 的中位数是 3
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构：
//
//
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。
//
//
// 示例 1：
//
// 输入：
// ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
// [[],[1],[2],[],[3],[]]
// 输出：[null,null,null,1.50000,null,2.00000]
//
//
// 示例 2：
//
// 输入：
// ["MedianFinder","addNum","findMedian","addNum","findMedian"]
// [[],[2],[],[3],[]]
// 输出：[null,null,2.00000,null,2.50000]
//
//
//
// 限制：
//
//
// 最多会对 addNum、findMedian 进行 50000 次调用。
//
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
// m/
// Related Topics 堆 设计
// 👍 87 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author phuijiao
 * @date 2020-12-24 21:19:12
 */
class ShuJuLiuZhongDeZhongWeiShuLcof {
  public static void main(String[] args) {
    MedianFinder solution = new MedianFinder();

    ArrayList<Integer> list =
        new ArrayList<Integer>() {
          {
            add(-1);
            add(-2);
            add(-3);
          }
        };
    list.sort(Comparator.naturalOrder());
    System.out.println(list);

    double median;
    solution.addNum(-1);
    median = solution.findMedian();
    System.out.println(median);
    solution.addNum(-2);
    median = solution.findMedian();
    System.out.println(median);
    solution.addNum(-3);
    median = solution.findMedian();
    System.out.println(median);
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> A, B;

    public MedianFinder() {
      A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
      B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
      if (A.size() != B.size()) {
        A.add(num);
        B.add(A.poll());
      } else {
        B.add(num);
        A.add(B.poll());
      }
    }

    public double findMedian() {
      return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
  }

  /**
   * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
   * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
