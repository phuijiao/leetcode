// 输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 150 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author phuijiao
 * @date 2020-12-18 19:34:12
 */
class ZiFuChuanDePaiLieLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = solution.permutation("abc");
    System.out.println(Arrays.toString(strs));
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<String> list = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
      chars = s.toCharArray();
      dfs(0);
      return list.toArray(new String[list.size()]);
    }

    private void dfs(int x) {
      if (x == chars.length - 1) {
        list.add(String.valueOf(chars));
        return;
      }
      HashSet<Character> set = new HashSet<>();
      for (int i = x; i < this.chars.length; i++) {
        if (set.contains(chars[i])) {
          continue;
        }
        set.add(chars[i]);
        swap(x, i);
        dfs(x + 1);
        swap(x, i);
      }
    }

    private void swap(int x, int i) {
      char aChar = chars[x];
      chars[x] = chars[i];
      chars[i] = aChar;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
