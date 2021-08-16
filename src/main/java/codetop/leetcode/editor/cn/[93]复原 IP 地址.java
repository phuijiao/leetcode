
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
// Related Topics 字符串 回溯 
// 👍 649 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author phuijiao
 * @date 2021-08-16 17:06:25
 */
 
class RestoreIpAddresses {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res;
    LinkedList<String> list;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        list = new LinkedList<>();
        ips(s, 0, 4);
        return res;
    }

      private void ips(String s, int ind, int count) {
          int len = s.length();
          if (ind == len && count == 0) {
              StringBuilder builder = new StringBuilder();
              for (int i = 0; i < 4; i++) {
                  builder.append(list.get(i)).append(".");
              }
              builder.deleteCharAt(builder.length() - 1);
              res.add(builder.toString());
              return;
          }
          if (ind >= len || count <= 0 || len - ind < count || len - ind > count * 3) {
              return;
          }

          if (s.charAt(ind) == '0') {
              list.add("0");
              ips(s, ind + 1, count - 1);
              list.removeLast();
          } else {
              list.add(s.substring(ind, ind + 1));
              ips(s, ind + 1, count - 1);
              list.removeLast();

              if (ind + 1 < len) {
                  list.add(s.substring(ind, ind + 2));
                  ips(s, ind + 2, count - 1);
                  list.removeLast();
              }

              if (ind + 2 < len) {
                  int num = (s.charAt(ind) - '0') * 100 + (s.charAt(ind + 1) - '0') * 10 + s.charAt(ind + 2) - '0';
                  if (num <= 255) {
                      list.add(s.substring(ind, ind + 3));
                      ips(s, ind + 3, count - 1);
                      list.removeLast();
                  }
              }
          }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
