
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 150 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-21 15:36:28
  */

class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
      if (nums == null || nums.length <= 1) {
        return nums;
      }
      int l = 0, r = nums.length - 1;
      while (l < r) {
        if ((nums[l] & 1) == 1) {
          l++;
          continue;
        }
        if ((nums[r] & 1) == 0) {
          r--;
          continue;
        }
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
      }
      return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}