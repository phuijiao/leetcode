// 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//
//
// 示例 1：
//
//
// 输入：n = 12
// 输出：5
//
//
// 示例 2：
//
//
// 输入：n = 13
// 输出：6
//
//
//
// 限制：
//
//
// 1 <= n < 2^31
//
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
// Related Topics 数学
// 👍 120 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-24 22:55:30
 */
class OneNzhengShuZhong1chuXianDeCiShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int countDigitOne(int n) {
      int digit = 1;
      int res = 0;
      int high = n / 10;
      int cur = n % 10;
      int low = 0;

      while (high != 0 || cur != 0) {
        if (cur == 0) {
          res += high * digit;
        } else if (cur == 1) {
          res += high * digit + low + 1;
        } else {
          res += (high + 1) * digit;
        }
        low += cur * digit;
        cur = high % 10;
        high /= 10;
        digit *= 10;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
