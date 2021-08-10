
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2546 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;

/**
  * @author  phuijiao
  * @date 2021-08-08 19:16:25
  */

class ValidParentheses {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
      int len = s.length();
      ArrayList<Character> stock = new ArrayList<>();

      for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
          stock.add(')');
        } else if (ch == '[') {
          stock.add(']');
        } else if (ch == '{') {
          stock.add('}');
        } else if (stock.isEmpty()) {
          return false;
        } else {
          if (ch == stock.get(stock.size() - 1)) {
            stock.remove(stock.size() - 1);
          } else {
            return false;
          }
        }
      }
      return stock.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}