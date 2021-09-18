
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
// Related Topics 数学 字符串 模拟 
// 👍 700 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-22 09:53:10
  */

class MultiplyStrings {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = solution.multiply("123", "456");
    System.out.println(s);
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
      int l1 = num1.length();
      int l2 = num2.length();
      int[] nums = new int[l1 + l2];
      int carry = 0;
      for (int i = l2 - 1; i >= 0; i--) {
        int n2 = num2.charAt(i) - '0';
        for (int j = l1 - 1; j >= 0; j--) {
          int n1 = num1.charAt(j) - '0';
          nums[i + j + 1] += n2 * n1 + carry;
          carry = nums[i + j + 1] / 10;
          nums[i + j + 1] %= 10;
        }
        nums[i] += carry;
        carry = 0;
      }
      StringBuilder builder = new StringBuilder();
      int ind = 0;
      while (ind < l1 + l2 - 1 && nums[ind] == 0) {
        ind++;
      }
      while (ind < l1 + l2) {
        builder.append(nums[ind]);
        ind++;
      }
      return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}