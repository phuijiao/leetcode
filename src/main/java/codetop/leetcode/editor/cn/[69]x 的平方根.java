
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 746 👎 0

package codetop.leetcode.editor.cn;
/**
 * @Author phuijiao
 * @date 2021-08-12 14:00:08
 */
 
class Sqrtx {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int mySqrt(int x) {
        long res = -1;
        long l = 0, r = x, m;
        while (l <= r) {
            m = (l + r) >> 1;
            if (m * m <= x) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
