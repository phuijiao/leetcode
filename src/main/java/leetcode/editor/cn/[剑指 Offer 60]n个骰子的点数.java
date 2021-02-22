// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
//
//
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//
//
//
// 示例 1:
//
// 输入: 1
// 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
//
//
// 示例 2:
//
// 输入: 2
// 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
// .05556,0.02778]
//
//
//
// 限制：
//
// 1 <= n <= 11
// 👍 148 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-21 20:40:54
 */
class NgeTouZiDeDianShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.dicesProbability(1);
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public double[] dicesProbability1(int n) {
      double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
      for (int i = 2; i <= n; i++) {
        double[] tmp = new double[5 * i + 1];
        for (int j = 0; j < pre.length; j++) {
          for (int x = 0; x < 6; x++) {
            tmp[j + x] += pre[j] / 6;
          }
        }
        pre = tmp;
      }
      return pre;
    }

    public double[] dicesProbability(int n) {
      int[] dp = new int[70];
      for (int i = 0; i < 70; i++) {
        dp[i] = 0;
      }
      for (int i = 1; i <= 6; i++) {
        dp[i] = 1;
      }
      for (int i = 2; i <= n; i++) {
        for (int j = 6 * i; j >= i; j--) {
          dp[j] = 0;
          for (int cur = 1; cur <= 6; cur++) {
            if (j - cur < i - 1) {
              break;
            }
            dp[j] += dp[j - cur];
          }
        }
      }
      double all = Math.pow(6, n);
      double[] ret = new double[5 * n + 1];
      for (int i = 0; i < 5 * n + 1; i++) {
        ret[i] = dp[i + n] / all;
      }
      return ret;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
