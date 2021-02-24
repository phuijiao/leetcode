//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 121 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-02-23 09:12:56
 */

class BuYongJiaJianChengChuZuoJiaFaLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add1(int a, int b) {
      int xor = 0;
      do{
        xor = a ^ b;
        b = a & b;
        b = b << 1;
        a = xor;
      } while (b != 0);
      return xor;
    }

    public int add(int a, int b) {
      int c = 0;
      while (b != 0) {
        c = (a & b) << 1;
        a ^= b;
        b = c;
      }
      return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

