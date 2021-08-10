
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3931 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-09 21:43:36
  */

class LongestPalindromicSubstring {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String str = solution.longestPalindrome("eabcb");
    System.out.println(str);
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String res;
    int max = 0;
    public String longestPalindrome(String s) {
      int len = s.length();
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < 2; j++) {
          palindrome(s, i, i + j);
        }
      }
      return res;
    }

    private void palindrome(String s, int i, int j) {
      int len = s.length();
      while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
      }
      if (j - i + 1 > max) {
        max = j - i + 1;
        res = s.substring(i + 1, j);
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}