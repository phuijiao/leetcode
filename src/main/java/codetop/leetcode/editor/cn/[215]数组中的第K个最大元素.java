
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1209 👎 0

package codetop.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
  * @author  phuijiao
  * @date 2021-08-07 16:19:54
  */

class KthLargestElementInAnArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //小顶堆法
    public int findKthLargest1(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
        return -1;
      }
      PriorityQueue<Integer> minDump = new PriorityQueue<>(k);
      for (int i = 0; i < k; i++) {
        minDump.add(nums[i]);
      }
      for (int i = k; i < nums.length; i++) {
        if (nums[i] > minDump.peek()) {
          minDump.poll();
          minDump.add(nums[i]);
        }
      }

      return minDump.peek();
    }

    //冒泡k次法
    public int findKthLargest(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
        return -1;
      }
      int len = nums.length;
      for (int i = 0; i < k; i++) {
        for (int j = 1; j < len - i; j++) {
          if (nums[j - 1] > nums[j]) {
            int tmp = nums[j];
            nums[j] = nums[j - 1];
            nums[j - 1] = tmp;
          }
        }
      }
      return nums[len - k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}