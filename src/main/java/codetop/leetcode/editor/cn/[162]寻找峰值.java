
//峰值元素是指其值大于左右相邻值的元素。 
//
// 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 496 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-20 19:30:40
  */

class FindPeakElement {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement1(int[] nums) {
      int len = nums.length;
      if (len == 1) {
        return 0;
      }
      if (nums[0] > nums[1]) {
        return 0;
      }
      if (nums[len - 1] > nums[len - 2]) {
        return len - 1;
      }
      for (int i = 1; i < len - 1; i++) {
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
          return i;
        }
      }
      return 0;
    }

    public int findPeakElement2(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
          return i;
        }
      }
      return nums.length - 1;
    }


    //二分法
    public int findPeakElement(int[] nums) {
      return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
      if (l == r) {
        return l;
      }
      int m = (l + r) / 2;
      if (nums[m] > nums[m + 1]) {
        return search(nums, l, m);
      } else {
        return search(nums, m + 1, r);
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}