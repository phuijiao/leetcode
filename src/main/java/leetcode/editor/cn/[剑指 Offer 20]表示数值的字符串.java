// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
// 3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
//
//
// Related Topics 数学
// 👍 135 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 13:57:28
 */
class BiaoShiShuZhiDeZiFuChuanLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isNumber1(String s) {
      try {
        Double.parseDouble(s);
      } catch (Exception e) {
        return false;
      }
      char ch = s.charAt(s.length() - 1);
      if ((ch >= '0' && ch <= '9') || ch == ' ' || ch == '.') {
        return true;
      }
      return false;
    }

    public boolean isNumber(String s) {
      if (s == null || s.length() == 0) {
        return false;
      }
      // 已有数字、小数点、指数符号e或E
      boolean isNum = false, isDot = false, iseE = false;
      // 允许出现空格，过滤掉空格
      char[] str = s.trim().toCharArray();
      for (int i = 0; i < str.length; i++) {
        if (str[i] >= '0' && str[i] <= '9') {
          isNum = true;
        } else if (str[i] == '.') {
          // 小数点只能出现一次，且只能出现在指数符号之前，且不能出现在最后
          if (!isDot && !iseE && i < str.length) {
            isDot = true;
          } else {
            return false;
          }
        } else if (str[i] == 'e' || str[i] == 'E') {
          // 指数符号只能出现在数子后面，且只能出现一次
          if (isNum && !iseE) {
            iseE = true;
            isNum = false;
          } else {
            return false;
          }
        } else if (str[i] == '+' || str[i] == '-') {
          // 正负符号只能出现在首位，或指数符号后面一位
          if (i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E') {

          } else {
            return false;
          }
        } else {
          // 非法字符
          return false;
        }
      }
      // 必须出现数字
      if (isNum) {
        return true;
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
