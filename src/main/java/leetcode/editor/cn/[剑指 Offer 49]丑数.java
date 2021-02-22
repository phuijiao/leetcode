// 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
// 输出: 12
// 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学
// 👍 94 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-19 15:38:29
 */
class ChouShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.nthUglyNumber2(19);
    solution.nthUglyNumber(19);
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int nthUglyNumber(int n) {
      int[] ugly = new int[n];
      ugly[0] = 1;
      int i2 = 0;
      int i3 = 0;
      int i5 = 0;
      for (int i = 1; i < n; i++) {
        int n2 = ugly[i2] * 2;
        int n3 = ugly[i3] * 3;
        int n5 = ugly[i5] * 5;
        int min = Math.min(Math.min(n2, n3), n5);
        if (min == n2) {
          i2++;
        }
        if (min == n3) {
          i3++;
        }
        if (min == n5) {
          i5++;
        }
        ugly[i] = min;
      }
      return ugly[n - 1];
    }

    public int nthUglyNumber2(int n) {
      int a = 0, b = 0, c = 0;
      int[] dp = new int[n];
      dp[0] = 1;
      for (int i = 1; i < n; i++) {
        int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
        dp[i] = Math.min(Math.min(n2, n3), n5);
        if (dp[i] == n2) a++;
        if (dp[i] == n3) b++;
        if (dp[i] == n5) c++;
      }
      return dp[n - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
