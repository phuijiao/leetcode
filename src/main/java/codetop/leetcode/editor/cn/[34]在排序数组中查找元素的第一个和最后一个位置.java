
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1152 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-17 11:22:21
  */

class FindFirstAndLastPositionOfElementInSortedArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return new int[]{-1, -1};
      }
      int left = search(nums, target, true);
      int right = search(nums, target, false) - 1;
      if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
        return new int[]{left, right};
      }
      return new int[]{-1, -1};
    }

    private int search(int[] nums, int target, boolean flag) {
      int l = 0, r = nums.length - 1, m, res = nums.length;
      while (l <= r) {
        m = (l + r) >> 1;
        if (nums[m] > target || (flag && nums[m] == target)) {
          r = m - 1;
          res = m;
        } else {
          l = m + 1;
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}