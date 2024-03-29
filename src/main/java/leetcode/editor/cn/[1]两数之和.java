
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
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
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10568 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author  phuijiao
 * @date 2021-03-19 15:17:25
 */

class TwoSum{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //暴力遍历
    public int[] twoSum1(int[] nums, int target) {
      int len = nums.length;
      for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
          if (nums[i] + nums[j] == target) {
            return new int[] {i, j};
          }
        }
      }
      return new int[0];
    }


    //哈希表
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        Integer ind = map.get(target - nums[i]);
        if (ind != null) {
          return new int[] {ind, i};
        }
        map.put(nums[i], i);
      }
      return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

