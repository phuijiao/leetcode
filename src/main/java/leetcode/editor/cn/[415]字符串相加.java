//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 333 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-19 16:55:00
 */

class AddStrings{
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = solution.addStrings("12", "34");
    System.out.println(s);
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings1(String num1, String num2) {
      int len1 = num1.length();
      int len2 = num2.length();
      int len = Math.max(len1, len2) + 1;
      byte[] sum = new byte[len];
      int carry = 0;
      byte b1, b2;
      for (int i = 0; i < len; i++) {
        if (i < len1) {
          b1 = (byte) (num1.charAt(len1 - i - 1) - '0');
        } else {
          b1 = 0;
        }
        if (i < len2) {
          b2 = (byte) (num2.charAt(len2 - i - 1) - '0');
        } else {
          b2 = 0;
        }
        sum[i] = (byte) (b1 + b2 + carry);
        carry = 0;
        if (sum[i] > 9) {
          sum[i] -= 10;
          carry = 1;
        }
      }
      StringBuilder builder = new StringBuilder();
      if (sum[len - 1] != 0) {
        builder.append(sum[len - 1]);
      }
      for (int i = len - 2; i >= 0; i--) {
        builder.append(sum[i]);
      }
      return builder.toString();
    }

    public String addStrings(String num1, String num2) {
      int i = num1.length() - 1, j = num2.length() - 1, add = 0;
      StringBuffer ans = new StringBuffer();
      while (i >= 0 || j >= 0 || add != 0) {
        int x = i >= 0 ? num1.charAt(i) - '0' : 0;
        int y = j >= 0 ? num2.charAt(j) - '0' : 0;
        int result = x + y + add;
        ans.append(result % 10);
        add = result / 10;
        i--;
        j--;
      }
      // 计算完以后的答案需要翻转过来
      ans.reverse();
      return ans.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}

