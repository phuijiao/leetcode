
//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 298 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-02-24 11:13:15
 */

class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //递归
    public int lastRemaining1(int n, int m) {
      if (n == 1) {
        return 0;
      }
      int x = lastRemaining(n - 1, m);
      return (m + x) % n;
    }

    public int lastRemaining(int n, int m) {
      int f = 0;
      for (int i = 2; i <= n; i++) {
        f = (f + m) % i;
      }
      return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

