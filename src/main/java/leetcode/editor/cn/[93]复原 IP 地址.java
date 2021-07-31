//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 570 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phuijiao
 * @date 2021-05-07 20:07:10
 */

class RestoreIpAddresses {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.restoreIpAddresses("25525511135");
  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    ArrayList<String> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
      recur(s, 0, 4);
      return res;
    }

    private void recur(String s, int start, int count) {
      int len = s.length();
      if (count == 0 && start == len) {
        res.add(String.join(".", list));
        return;
      }
      if (count <= 0 || len - start < count || len - start > 3 * count) {
        return;
      }

      if (s.charAt(start) == '0') {
        list.add("0");
        recur(s, start + 1, count - 1);
        list.removeLast();
      } else {
        list.add(s.substring(start,start+1));
        recur(s, start + 1, count - 1);
        list.removeLast();

        if (len > start + 1) {
          list.add(s.substring(start,start+2));
          recur(s, start + 2, count - 1);
          list.removeLast();
        }

        if (len > start + 2) {
          int add = Integer.parseInt(s.substring(start, start + 3));
          if (add <= 255) {
            list.add(s.substring(start,start+3));
            recur(s, start + 3, count - 1);
            list.removeLast();
          }
        }
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}