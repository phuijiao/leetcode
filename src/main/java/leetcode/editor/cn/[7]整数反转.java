//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2816 👎 0

package leetcode.editor.cn;
/**
* @author phuijiao
* @date 2021-05-21 19:02:32
*/

class ReverseInteger {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse1(int x) {
      long res = 0;
      int tmp;
      while (x != 0) {
        tmp = x % 10;
        x /= 10;
        res = res * 10 + tmp;
      }
      return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res;
    }


    //不用64位整数
    public int reverse(int x) {
      final int t1 = Integer.MAX_VALUE / 10;
      final int t2 = Integer.MAX_VALUE % 10;
      final int t3 = Integer.MIN_VALUE / 10;
      final int t4 = Integer.MIN_VALUE % 10;

      int res = 0;
      while (x != 0) {
        int t = x % 10;
        x /= 10;
        if (res > t1 || (res == t1 && t > t2) || res < t3 || (res == t3 && t < t4)) {
          return 0;
        }
        res = res * 10 + t;
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}