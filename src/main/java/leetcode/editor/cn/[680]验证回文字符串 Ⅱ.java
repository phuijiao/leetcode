//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 339 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-04-12 21:16:15
 */

class ValidPalindromeIi{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
      if (s == null || s.length() <= 2){
        return true;
      }
      int l = 0, r = s.length() -1;
      while (l < r){
        if (s.charAt(l) != s.charAt(r)) {
          return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
        }
        l++;
        r--;
      }
      return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
      while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
          return false;
        }
        l++;
        r--;
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}

