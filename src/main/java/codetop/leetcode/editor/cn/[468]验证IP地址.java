
//编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。 
//
// 
// 如果是有效的 IPv4 地址，返回 "IPv4" ； 
// 如果是有效的 IPv6 地址，返回 "IPv6" ； 
// 如果不是上述类型的 IP 地址，返回 "Neither" 。 
// 
//
// IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1； 
//
// 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。 
//
// IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如, 2001:0db8:85a3:0000:0
//000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85
//a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。 
//
// 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334
// 是无效的 IPv6 地址。 
//
// 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的
//。 
//
// 
//
// 示例 1： 
//
// 输入：IP = "172.16.254.1"
//输出："IPv4"
//解释：有效的 IPv4 地址，返回 "IPv4"
// 
//
// 示例 2： 
//
// 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//输出："IPv6"
//解释：有效的 IPv6 地址，返回 "IPv6"
// 
//
// 示例 3： 
//
// 输入：IP = "256.256.256.256"
//输出："Neither"
//解释：既不是 IPv4 地址，又不是 IPv6 地址
// 
//
// 示例 4： 
//
// 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//输出："Neither"
// 
//
// 示例 5： 
//
// 输入：IP = "1e1.4.5.6"
//输出："Neither"
// 
//
// 
//
// 提示： 
//
// 
// IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。 
// 
// Related Topics 字符串 
// 👍 100 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-21 10:10:27
  */

class ValidateIpAddress {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    String s = solution.validIPAddress(str);
    System.out.println(s);
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String validIPAddress(String IP) {
      if (IP == null || IP.length() < 7 || IP.length() > 39) {
        return "Neither";
      }
      if (IP.contains(".")) {
        return ipv4(IP);
      } else {
        return ipv6(IP);
      }
    }

    private String ipv6(String ip) {
      if (ip.startsWith(":") || ip.endsWith(":")) {
        return "Neither";
      }
      String[] split = ip.split(":");
      if (split.length != 8) {
        return "Neither";
      }
      for (int i = 0; i < 8; i++) {
        if (split[i].length() == 0 || split[i].length() > 4) {
          return "Neither";
        }
        for (int j = 0; j < split[i].length(); j++) {
          char c = split[i].charAt(j);
          if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
            return "Neither";
          }
        }
      }
      return "IPv6";
    }

    private String ipv4(String ip) {
      if (ip.startsWith(".") || ip.endsWith(".")) {
        return "Neither";
      }
      String[] split = ip.split("\\.");
      if (split.length != 4) {
        return "Neither";
      }
      for (int i = 0; i < 4; i++) {
        if (split[i].length() == 0 || split[i].length() > 3) {
          return "Neither";
        }
        if (split[i].charAt(0) == '0' && split[i].length() != 1) {
          return "Neither";
        }
        int num = 0;
        for (int j = 0; j < split[i].length(); j++) {
          char c = split[i].charAt(j);
          if (c < '0' || c > '9') {
            return "Neither";
          }
          num = num * 10 + c - '0';
        }
        if (num > 255) {
          return "Neither";
        }
      }
      return "IPv4";
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}