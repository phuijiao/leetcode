
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
// Related Topics 数学 字符串 模拟 
// 👍 416 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-08 18:51:50
  */

class AddStrings {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
      int ind1 = num1.length() - 1;
      int ind2 = num2.length() - 1;
      int jin = 0;
      StringBuilder builder = new StringBuilder();
      while (ind1 >= 0 || ind2 >= 0 || jin > 0) {
        int n1 = ind1 >= 0 ? num1.charAt(ind1) - '0' : 0;
        int n2 = ind2 >= 0 ? num2.charAt(ind2) - '0' : 0;
        builder.append((n1 + n2 + jin) % 10);
        jin = (n1 + n2 + jin) / 10;
        ind1--;
        ind2--;
      }
      return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}