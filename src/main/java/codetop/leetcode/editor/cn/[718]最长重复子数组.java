
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 508 👎 0

package codetop.leetcode.editor.cn;

/**
 * @Author phuijiao
 * @date 2021-08-13 16:04:21
 */

class MaximumLengthOfRepeatedSubarray {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int findLength(int[] nums1, int[] nums2) {
      int l1 = nums1.length;
      int l2 = nums2.length;
      int[][] dp = new int[l1 + 1][l2 + 1];
      int res = 0;
      for (int i = 1; i <= l1; i++) {
        for (int j = 1; j <= l2; j++) {
          dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
          res = Math.max(res, dp[i][j]);
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
