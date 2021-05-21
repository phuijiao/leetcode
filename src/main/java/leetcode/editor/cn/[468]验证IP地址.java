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
// 👍 89 👎 0

package leetcode.editor.cn;

import com.sun.tools.internal.ws.wsdl.document.Import;
import sun.net.util.IPAddressUtil;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
* @author phuijiao
* @date 2021-05-17 19:02:30
*/

class ValidateIpAddress {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = solution.validIPAddress("172.16.254.1");
    System.out.println(s);
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
//    public String validIPAddress1(String IP) {
//      if (IPAddressUtil.isIPv4LiteralAddress(IP)) {
//        return "IPv4";
//      } else if (IPAddressUtil.isIPv6LiteralAddress(IP)) {
//        return "IPv6";
//      } else {
//        return "Neither";
//      }
//    }
//
//    public String validIPAddress2(String IP) {
//      try {
//        return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
//      } catch (UnknownHostException e) {
//        return "Neither";
//      }
//    }


    //正则表达式
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
    public String validIPAddress3(String IP) {
      if (IP.contains(".")) {
        return (patternIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
      } else if (IP.contains(":")) {
        return patternIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
      }
      return "Neither";
    }


    //分治法
    public String validIPAddress(String IP) {
      if (IP.chars().filter(ch -> ch == '.').count() == 3) {
        return validateIPv4(IP);
      } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
        return validateIPv6(IP);
      } else {
        return "Neither";
      }
    }

    private String validateIPv6(String IP) {
      String[] nums = IP.split(":", -1);
      String hezdigits = "0123456789abcdefABCDEF";
      for (String x : nums) {
        if (x.length() == 0 || x.length() > 4) {
          return "Neither";
        }
        for (char ch : x.toCharArray()) {
          if (hezdigits.indexOf(ch) == -1) {
            return "Neither";
          }
        }
      }
      return "IPv6";
    }

    private String validateIPv4(String IP) {
      String[] nums = IP.split("\\.", -1);
      for (String x : nums) {
        if (x.length() == 0 || x.length() > 3) {
          return "Neither";
        }
        if (x.charAt(0) == '0' && x.length() != 1) {
          return "Neither";
        }
        for (char ch : x.toCharArray()) {
          if (!Character.isDigit(ch)) {
            return "Neither";
          }
        }
        if (Integer.parseInt(x) > 255) {
          return "Neither";
        }
      }
      return "IPv4";
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}