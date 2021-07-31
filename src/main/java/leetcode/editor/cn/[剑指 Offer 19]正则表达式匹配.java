
// 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
// 是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
//
// 示例 1:
//
// 输入:
// s = "aa"
// p = "a"
// 输出: false
// 解释: "a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
// 输入:
// s = "aa"
// p = "a*"
// 输出: true
// 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3:
//
// 输入:
// s = "ab"
// p = ".*"
// 输出: true
// 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4:
//
// 输入:
// s = "aab"
// p = "c*a*b"
// 输出: true
// 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5:
//
// 输入:
// s = "mississippi"
// p = "mis*is*p*."
// 输出: false
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
//
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
//
// Related Topics 动态规划
// 👍 141 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-23 16:28:39
 */
class ZhengZeBiaoDaShiPiPeiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isMatch1(String s, String p) {
      int n = s.length();
      int m = p.length();
      boolean[][] f = new boolean[n + 1][m + 1];

      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          // 分成空正则和非空正则两种
          if (j == 0) {
            f[i][j] = (i == 0);
          } else {
            // 非空正则分为两种情况 * 和 非*
            if (p.charAt(j - 1) != '*') {
              if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                f[i][j] = f[i - 1][j - 1];
              }
            } else {
              // 碰到 * 了，分为看和不看两种情况
              // 不看
              if (j >= 2) {
                f[i][j] = f[i][j - 2];
              }
              // 看
              if (i >= 1
                  && j >= 2
                  && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                f[i][j] |= f[i - 1][j];
              }
            }
          }
        }
      }

      return f[n][m];
    }

    public boolean isMatch2(String s, String p) {
      // 如果字符串长度为0，需要检测下正则串
      if (s.length() == 0) {
        // 如果正则串长度为奇数，必定不匹配，比如 "." 、"ab*",必须是 a*b*这种形式，*在奇数位上
        if (p.length() % 2 != 0) {
          return false;
        }
        int i = 1;
        while (i < p.length()) {
          if (p.charAt(i) != '*') {
            return false;
          }
          i += 2;
        }
        return true;
      }
      // 如果字符串长度不为0，但是正则串没了，return false
      if (p.length() == 0) {
        return false;
      }
      // c1和c2分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
      char c1 = s.charAt(0);
      char c2 = p.charAt(0);
      char c3 = 'a';
      if (p.length() > 1) {
        c3 = p.charAt(1);
      }
      // 和dp一样，后一位分别是 '*' 和不是 '*' 两种情况
      if (c3 != '*') {
        // 如果该位字符一样，或是正则串该位是 '.' ，也就是能匹配任意字符，就可以往后走
        if (c1 == c2 || c2 == '.') {
          return isMatch(s.substring(1), p.substring(1));
        } else {
          // 否则不匹配
          return false;
        }
      } else {
        // 如果该位字符一样，或是正则串该位是 '.' , 和dp一样，有看和不看两种情况
        if (c1 == c2 || c2 == '.') {
          return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        } else {
          // 不一样，那么正则串这两位就废了，直接往后走
          return isMatch(s, p.substring(2));
        }
      }
    }

    public boolean isMatch(String s, String p) {
      int m = s.length();
      int n = p.length();
      boolean[][] f = new boolean[m + 1][n + 1];
      f[0][0] = true;
      for (int i = 0; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (p.charAt(j - 1) == '*') {
            f[i][j] = f[i][j - 2];
            if (matches(s, p, i, j - 1)) {
              f[i][j] = f[i][j] || f[i - 1][j];
            }
          } else {
            if (matches(s, p, i, j)) {
              f[i][j] = f[i - 1][j - 1];
            }
          }
        }
      }
      return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
      if (i == 0) {
        return false;
      }
      if (p.charAt(j - 1) == '.') {
        return true;
      }
      return s.charAt(i - 1) == p.charAt(j - 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
