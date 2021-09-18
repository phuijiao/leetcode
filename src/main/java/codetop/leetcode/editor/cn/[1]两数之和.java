
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11752 👎 0

package codetop.leetcode.editor.cn;

import java.util.HashMap;

/**
  * @author  phuijiao
  * @date 2021-08-07 21:27:07
  */

class TwoSum {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    //暴力遍历
//    public int[] twoSum1(int[] nums, int target) {
//      if (nums == null || nums.length < 2) {
//        return null;
//      }
//      int len = nums.length;
//      for (int i = 0; i < len - 1; i++) {
//        for (int j = i + 1; j < len; j++) {
//          if (nums[i] + nums[j] == target) {
//            return new int[]{i, j};
//          }
//        }
//      }
//      return null;
//    }

    //哈希法a
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        Integer left = map.get(nums[i]);
        if (left == null) {
          map.put(target - nums[i], i);
        } else {
          return new int[]{left, i};
        }
      }
      return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}