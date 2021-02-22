// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
// 输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// 👍 55 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 11:23:11
 */
class TiHuanKongGeLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // String的方法replaceAll
    public String replaceSpace1(String s) {
      return s.replaceAll(" ", "%20");
    }

    // 使用StringBuilder
    public String replaceSpace(String s) {
      int len = s.length();
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < len; i++) {
        char c = s.charAt(i);
        if (c == ' ') {
          builder.append("%20");
        } else {
          builder.append(c);
        }
      }
      return builder.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
