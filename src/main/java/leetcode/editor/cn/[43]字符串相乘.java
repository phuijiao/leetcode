//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 638 👎 0

package leetcode.editor.cn;
/**
* @author phuijiao
* @date 2021-05-20 09:18:07
*/

class MultiplyStrings {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.multiply("999", "999");
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply1(String num1, String num2) {
      int len1 = num1.length();
      int len2 = num2.length();
      int[] arr1 = new int[len1];
      int[] arr2 = new int[len2];
      int[] res = new int[len1 + len2];
      int carry = 0;
      int tmp;
      for (int i = 0; i < len1; i++) {
        arr1[i] = num1.charAt(i) - '0';
      }
      for (int i = 0; i < len2; i++) {
        arr2[i] = num2.charAt(i) - '0';
      }
      for (int j = len2 - 1; j >= 0; j--) {
        carry = 0;
        for (int i = len1 - 1; i >= 0; i--) {
          tmp = arr1[i] * arr2[j] + carry + res[i + j + 1];
          res[i + j + 1] = tmp % 10;
          carry = tmp / 10;
        }
        res[j] = carry;
      }
      StringBuilder builder = new StringBuilder();
      int i = 0;
      while (i < len1 + len2 - 1 && res[i] == 0) {
        i++;
      }
      for (; i < len1+len2; i++) {
        builder.append(res[i]);
      }
      return builder.toString();
    }

    public String multiply(String num1, String num2) {
      if ("0".equals(num1) || "0".equals(num2)) {
        return "0";
      }
      int len1 = num1.length();
      int len2 = num2.length();
      int[] res = new int[len1 + len2];
      int carry = 0;
      int tmp;

      for (int j = len2 - 1; j >= 0; j--) {
        carry = 0;
        for (int i = len1 - 1; i >= 0; i--) {
          tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + res[i + j + 1];
          res[i + j + 1] = tmp % 10;
          carry = tmp / 10;
        }
        res[j] = carry;
      }
      StringBuilder builder = new StringBuilder();
      int i = 0;
      while (i < len1 + len2 - 1 && res[i] == 0) {
        i++;
      }
      for (; i < len1+len2; i++) {
        builder.append(res[i]);
      }
      return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}