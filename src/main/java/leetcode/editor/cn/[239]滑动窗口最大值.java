
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 974 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author phuijiao
 * @date 2021-05-08 20:18:44
 */

class SlidingWindowMaximum {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    //大顶堆，会超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
      int len = nums.length;
      int[] res = new int[len - k + 1];
      PriorityQueue<Integer> dump = new PriorityQueue<>((a, b) -> b - a);
      for (int i = 0; i < k - 1; i++) {
        dump.add(nums[i]);
      }
      for (int i = k - 1; i < len; i++) {
        dump.add(nums[i]);
        Integer poll = dump.peek();
        dump.remove(nums[i - k + 1]);
        res[i - k + 1] = poll;
      }
      return res;
    }


    //二元数组大顶堆
    public int[] maxSlidingWindow2(int[] nums, int k) {
      int len = nums.length;
      PriorityQueue<int[]> dump = new PriorityQueue<>((a, b) -> b[0] - a[0]);
      for (int i = 0; i < k; i++) {
        dump.add(new int[]{nums[i], i});
      }
      int[] res = new int[len - k + 1];
      res[0] = dump.peek()[0];
      for (int i = k; i < len; i++) {
        dump.add(new int[]{nums[i], i});
        while (dump.peek()[1] <= i - k) {
          dump.poll();
        }
        res[i - k + 1] = dump.peek()[0];
      }
      return res;
    }


    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len = nums.length;
      int[] res = new int[len - k + 1];
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < k; i++) {
        while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
          list.pollLast();
        }
        list.addLast(i);
      }
      res[0] = nums[list.peekFirst()];
      for (int i = k; i < len; i++) {
        while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
          list.pollLast();
        }
        list.addLast(i);
        while (list.peekFirst() <= i - k) {
          list.pollFirst();
        }
        res[i - k + 1] = nums[list.peekFirst()];
      }
      return res;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}