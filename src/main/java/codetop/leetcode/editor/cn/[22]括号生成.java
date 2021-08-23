
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1964 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
  * @author  phuijiao
  * @date 2021-08-18 17:38:53
  */

class GenerateParentheses {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res;
    StringBuilder builder;
    public List<String> generateParenthesis(int n) {
      res = new ArrayList<>();
      builder = new StringBuilder();
      generate(n, n);
      return res;
    }

    private void generate(int l, int r) {
      if (l == 0 && r == 0) {
        res.add(builder.toString());
      }
      if (l > 0) {
        builder.append('(');
        generate(l - 1, r);
        builder.deleteCharAt(builder.length() - 1);
      }
      if (r > 0 && r > l) {
        builder.append(')');
        generate(l, r - 1);
        builder.deleteCharAt(builder.length() - 1);
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}