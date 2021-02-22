//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 193 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-01-19 11:45:11
 */

class LianXuZiShuZuDeZuiDaHeLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray1(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int i = 0;
      int sum = 0, max = 0, min = nums[0];
//      while (i < nums.length && nums[i] <= 0) {
//        i++;
//      }
      boolean flag = false;
      while (i < nums.length) {
        if (nums[i] > 0) {
          flag = true;
        }
        if (!flag) {
          min = Math.max(min, nums[i]);
        }

        sum += nums[i];
        if (sum < 0) {
          sum = 0;
        } else {
          max = Math.max(max, sum);
        }
        i++;
      }
      if (!flag) {
        return min;
      }
      return max;
    }


    //动态规划
    public int maxSubArray2(int[] nums) {
      int res = nums[0];
      for (int i = 1; i < nums.length; i++) {
        nums[i] += Math.max(nums[i - 1], 0);
        res = Math.max(res, nums[i]);
      }
      return res;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
      int max = nums[0];
      int former = 0;//用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
      int cur = nums[0];//用于记录dp[i]的值
      for(int num:nums){
        cur = num;
        if(former>0) {
          cur +=former;
        }
        if(cur>max) {
          max = cur;
        }
        former=cur;
      }
      return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

