// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
// 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
// 。
//
// 示例 1：
//
// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
// 提示：
//
//
// 2 <= n <= 58
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 139 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-27 13:13:17
 */
class JianShengZiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    //尽量剪成长度为3的段，次之长度为2
    public int cuttingRope(int n) {
      if (n == 2) {
        return 1;
      } else if (n == 3) {
        return 2;
      }
      int m = n / 3;
      int t = n % 3;
      if (t == 0) {
        return (int) Math.pow(3, m);
      } else if (t == 1) {
        return (int) (Math.pow(3, m - 1) * 4);
      } else {
        return (int) (Math.pow(3, m) * 2);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
