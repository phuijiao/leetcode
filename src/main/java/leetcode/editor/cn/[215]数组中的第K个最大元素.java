
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 941 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  phuijiao
 * @date 2021-03-14 15:27:39
 */

class KthLargestElementInAnArray{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest1(int[] nums, int k) {
      PriorityQueue<Integer> dump = new PriorityQueue<>();
      for (int num : nums) {
        if (k-- <= 0) {
          if (dump.peek() < num) {
            dump.poll();
          } else {
            continue;
          }
        }
        dump.add(num);
      }
      return dump.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
      PriorityQueue<Integer> dump = new PriorityQueue<>();
      for (int i = 0; i < k; i++) {
        dump.add(nums[i]);
      }
      for (int i = k; i < nums.length; i++) {
        if (dump.peek() < nums[i]) {
          dump.poll();
          dump.add(nums[i]);
        }
      }
      return dump.peek();
    }

    public int findKthLargest(int[] nums, int k) {
      int[] array = Arrays.stream(nums).sorted().toArray();
      return array[nums.length - k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

