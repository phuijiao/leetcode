//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1313 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

/**
* @author phuijiao
* @date 2021-05-21 19:12:57
*/

class LongestValidParentheses {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.longestValidParentheses("(()");
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses1(String s) {
      Stack<Integer> stack = new Stack<>();
      int len = s.length();
      boolean[] flags = new boolean[len];
      int max = 0;
      for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
          stack.push(i);
        } else if (ch == ')' && !stack.isEmpty()) {
          flags[stack.pop()] = true;
          flags[i] = true;
        }
      }
      int cnt = 0;
      for (int i = 0; i < len; i++) {
        if (flags[i]) {
          cnt++;
        } else {
          max = Math.max(max, cnt);
          cnt = 0;
        }
      }
      max = Math.max(max, cnt);
      return max;
    }

    public int longestValidParentheses(String s) {
      LinkedList<Integer> stack = new LinkedList<>();
      stack.push(-1);
      int max = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
          stack.push(i);
        } else {
          stack.pop();
          if (stack.isEmpty()) {
            stack.push(i);
          } else {
            max = Math.max(max, i - stack.peek());
          }
        }
      }
      return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}