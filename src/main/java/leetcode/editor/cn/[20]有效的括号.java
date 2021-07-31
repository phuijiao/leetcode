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
// 👍 2255 👎 0

package leetcode.editor.cn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author  phuijiao
 * @date 2021-03-20 12:11:31
 */

class ValidParentheses{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
      int len = s.length();
      LinkedList<Character> stack = new LinkedList<>();
      for (int i = 0; i < len; i++) {
        char c = s.charAt(i);
        if (c == '(') {
          stack.push(')');
        } else if (c == '[') {
          stack.push(']');
        } else if (c == '{') {
          stack.push('}');
        } else if (stack.isEmpty()){
          return false;
        } else if (c == stack.peek()) {
          stack.pop();
        } else {
          return false;
        }
      }
      return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

