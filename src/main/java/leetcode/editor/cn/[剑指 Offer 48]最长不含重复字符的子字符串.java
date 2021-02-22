// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
//
//
// 示例 1:
//
// 输入: "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// s.length <= 40000
//
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
// eating-characters/
// Related Topics 哈希表 双指针 Sliding Window
// 👍 133 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;

/**
 * @author phuijiao
 * @date 2020-12-19 15:34:04
 */
class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring1(String s) {
      int max = 0;
      int start = -1;
      int last = 0;
      int length = s.length();
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < length; i++) {
        char ch = s.charAt(i);
        if (map.containsKey(ch)) {
          last = start;
          start = map.get(ch);
          for (int j = last + 1; j <= start; j++) {
            map.remove(s.charAt(j));
          }
        } else {
          max = Math.max(max, i - start);
        }
        map.put(ch, i);
      }
      return max;
    }

    public int lengthOfLongestSubstring(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
      int left = -1;
      int max = 0;
      int length = s.length();
      for (int i = 0; i < length; i++) {
        char ch = s.charAt(i);
        left = Math.max(left, map.getOrDefault(ch, -1));
        max = Math.max(max, i - left);
        map.put(ch, i);
      }
      return max;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
