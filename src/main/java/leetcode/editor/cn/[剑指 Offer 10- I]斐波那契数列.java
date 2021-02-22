// 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
//
// F(0) = 0,   F(1) = 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：1
//
//
// 示例 2：
//
//
// 输入：n = 5
// 输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 递归
// 👍 86 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 14:29:29
 */
class FeiBoNaQiShuLieLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 递归会有超时风险
    public int fib1(int n) {
      if (n == 0) {
        return 0;
      } else if (n == 1) {
        return 1;
      } else {
        return fib(n - 1) + fib(n - 2);
      }
    }

    // 使用循环
    public int fib(int n) {
      if (n < 2) {
        return n;
      }
      int x = 0, y = 1, z = 1;
      for (int i = 0; i < n - 1; i++) {
        z = (x + y) % 1000000007;
        x = y;
        y = z;
      }
      return z;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
