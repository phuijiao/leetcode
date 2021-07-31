
// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
// 能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
// 输出: 5
// 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//
// 提示：
//
//
// 0 <= num < 231
//
// 👍 163 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;

/**
 * @author phuijiao
 * @date 2020-12-18 23:12:54
 */
class BaShuZiFanYiChengZiFuChuanLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int translateNum(int num) {
      if (num < 10) {
        return 1;
      }

      int re = num % 100;
      if (re >= 10 && re <= 25) {
        return translateNum(num / 10) + translateNum(num / 100);
      } else {
        return translateNum(num / 10);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
