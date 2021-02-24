//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 191 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author  phuijiao
 * @date 2021-02-24 09:48:22
 */

class HuaDongChuangKouDeZuiDaZhiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //大顶堆法
    public int[] maxSlidingWindow1(int[] nums, int k) {
      int len = nums.length;
      if (len == 0 || k == 0 || len < k) {
        return new int[0];
      }
      int[] res = new int[len - k + 1];
      PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
      for (int i = 0; i < len; i++) {
        queue.add(nums[i]);
        if (i >= k - 1) {
          res[i - k + 1] = queue.peek();
          queue.remove(nums[i - k + 1]);
        }
      }
      return res;
    }

    //双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len = nums.length;
      if (len == 0 || k == 0 || len < k) {
        return new int[0];
      }
      Deque<Integer> deque = new LinkedList<>();
      int[] res = new int[len - k + 1];
      for (int j = 0, i = 1 - k; j < len; j++, i++) {
        if (i > 0 && deque.peekFirst() == nums[i - 1]) {
          deque.removeFirst();
        }
        while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
          deque.removeLast();
        }
        deque.addLast(nums[j]);
        if (i >= 0) {
          res[i] = deque.peekFirst();
        }
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

