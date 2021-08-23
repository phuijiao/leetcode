
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1736 👎 0

package codetop.leetcode.editor.cn;

import java.util.Arrays;

/**
  * @author  phuijiao
  * @date 2021-08-21 11:39:43
  */

class LongestCommonPrefix {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
      int len = strs.length;
      if (len == 1) {
        return strs[0];
      }
      Arrays.sort(strs);
      for (int i = 0; i < strs[0].length(); i++) {
        if (strs[0].charAt(i) != strs[len - 1].charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
      return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}