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
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1600 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
* @author phuijiao
* @date 2021-05-14 20:52:54
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
      if (len == 0) {
        return "";
      } else if (len == 1) {
        return strs[0];
      }

      Arrays.sort(strs);
      int i = 0;
      for (; i < strs[0].length(); i++) {
        if (strs[0].charAt(i) != strs[len - 1].charAt(i)) {
          break;
        }
      }
      return strs[0].substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}