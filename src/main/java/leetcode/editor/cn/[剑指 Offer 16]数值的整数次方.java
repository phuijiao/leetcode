
// 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
// 问题。
//
//
//
// 示例 1:
//
// 输入: 2.00000, 10
// 输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
// 输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
// 输出: 0.25000
// 解释: 2-2 = 1/22 = 1/4 = 0.25
//
//
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
// Related Topics 递归
// 👍 105 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-27 14:55:05
 */
class ShuZhiDeZhengShuCiFangLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.myPow(2.00000, -2147483648);
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 直接循环求次方会有超时的风险
    public double myPow1(double x, int n) {
      long m = n;
      boolean flag = m < 0 ? true : false;
      m = Math.abs(m);
      double f = x < 0 && m % 2 == 1 ? -1.0 : 1.0;
      x = Math.abs(x);

      if (m == 0) {
        return 1.0;
      } else if (Math.abs(x - 1.0) < 0.000001) {
        return 1.0;
      }
      double res = 1.0;
      for (int i = 0; i < m; i++) {
        res *= x;
      }
      if (flag) {
        res = 1.0 / res;
      }
      return res * f;
    }

    // 将次方二进制展开
    public double myPow(double x, int n) {
      if (n == 0) {
        return 1;
      } else if (x == 0) {
        return 0;
      }

      // 扩展 n 的类型范围，防止溢出
      long b = n;
      if (b < 0) {
        x = 1.0 / x;
        b = -b;
      }

      double res = 1.0;
      // 将幂次展开
      while (b != 0) {
        if ((b & 1) == 1) {
          res *= x;
        }
        x *= x;
        b >>= 1;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
