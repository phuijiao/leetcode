
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 68 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-01-22 15:34:04
 */

class HeWeiSdeLiangGeShuZiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length < 2) {
        return new int[0];
      }
      int len = nums.length;
      int i = 0, j = len - 1;
      while (i < j) {
        if (nums[i] + nums[j] == target) {
          return new int[] {nums[i], nums[j]};
        } else if (nums[i] + nums[j] > target) {
          j--;
        } else {
          i++;
        }
      }
      return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

