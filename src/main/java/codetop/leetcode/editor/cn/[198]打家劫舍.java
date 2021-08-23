
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 
// 👍 1608 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-22 18:46:59
  */

class HouseRobber {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    int max;
//    public int rob1(int[] nums) {
//      max = 0;
//      rob(nums, 0, 0);
//      return max;
//    }
//
//    private void rob(int[] nums, int ind, int sum) {
//      int len = nums.length;
//      if (ind >= len) {
//        max = Math.max(max, sum);
//        return;
//      }
//
//      rob(nums, ind + 2, sum + nums[ind]);
//      rob(nums, ind + 1, sum);
//    }

    public int rob(int[] nums) {
      int len = nums.length;
      if (len == 1) {
        return nums[0];
      }
      nums[1] = Math.max(nums[0], nums[1]);
      for (int i = 2; i < len; i++) {
        nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
      }
      return nums[len - 1];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}