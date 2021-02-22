// 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
// 输出: 5
// 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
// 输出: 0
// 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 10^5
//
//
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
// tock/
// Related Topics 动态规划
// 👍 74 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-21 22:28:00
 */
class GuPiaoDeZuiDaLiRunLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxProfit1(int[] prices) {
      int length = prices.length;
      if (length < 2) {
        return 0;
      }
      int max = 0;
      for (int i = 0; i < length; i++) {
        for (int j = i + 1; j < length; j++) {
          max = Math.max(max, prices[j] - prices[i]);
        }
      }
      return max;
    }

    public int maxProfit(int[] prices) {
      int max = 0;
      int sum = 0;
      int start = 0;
      for (int i = 1; i < prices.length; i++) {
        sum = prices[i] - prices[start];
        if (sum <= 0) {
          start = i;
          sum = 0;
        } else {
          max = Math.max(max, sum);
        }
      }
      return max;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
