
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1180 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-20 19:26:02
  */

class MoveZeroes {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
      if (nums == null || nums.length <= 1) {
        return;
      }
      int len = nums.length;
      int l = 0, r = 0;
      while (r < len) {
        if (nums[r] != 0) {
          nums[l] = nums[r];
          l++;
        }
        r++;
      }
      while (l < len) {
        nums[l] = 0;
        l++;
      }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}