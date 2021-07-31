//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 967 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-04-29 09:36:16
 */

class MajorityElement {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
      int res = 0;
      int count = 0;
      for (int num : nums) {
        if (count == 0) {
          res = num;
        }
        count += (res == num) ? 1 : -1;
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
