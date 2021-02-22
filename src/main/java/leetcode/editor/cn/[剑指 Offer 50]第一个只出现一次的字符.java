//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 68 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author  phuijiao
 * @date 2021-01-19 21:07:31
 */

class DiYiGeZhiChuXianYiCiDeZiFuLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //暴力法
    public char firstUniqChar1(String s) {
      if (s == null || s.length() == 0) {
        return ' ';
      }
      HashSet<Character> set = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (set.contains(c)) {
          continue;
        }
        for (int j = i+1; j < s.length(); j++) {
          if (s.charAt(j) == c) {
            set.add(c);
            break;
          }
        }
        if (!set.contains(c)) {
          return c;
        }
      }
      return ' ';
    }


    //
    public char firstUniqChar(String s) {
      if (s == null || s.length() == 0) {
        return ' ';
      }
      HashMap<Character, Boolean> map = new HashMap<>();
      char[] chars = s.toCharArray();
      for (char aChar : chars) {
        map.put(aChar, !map.containsKey(aChar));
      }
      for (char aChar : chars) {
        if (map.get(aChar)) {
          return aChar;
        }
      }
      return ' ';
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}

