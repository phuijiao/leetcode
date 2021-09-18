
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
// Related Topics 栈 字符串 动态规划 
// 👍 1414 👎 0

package codetop.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.I2D;

import java.util.LinkedList;

/**
  * @author  phuijiao
  * @date 2021-08-19 09:11:18
  */

class LongestValidParentheses {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int cnt = solution.longestValidParentheses("()");
    System.out.println(cnt);
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses1(String s) {
      int max = 0;
      int[] dp = new int[s.length()];
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
          if (s.charAt(i - 1) == '(') {
            dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
          } else if (dp[i - 1] < i && s.charAt(i - dp[i - 1] - 1) == '(') {
            dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
          }
          max = Math.max(max, dp[i]);
        }
      }
      return max;
    }


    public int longestValidParentheses(String s) {
      int max = 0;
      LinkedList<Integer> stack = new LinkedList<>();
      stack.push(-1);
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