// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
// 输出: [1,2,3,4,5,6,7,8,9]
//
//
//
//
// 说明：
//
//
// 用返回一个整数列表来代替打印
// n 为正整数
//
// Related Topics 数学
// 👍 70 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-27 16:10:59
 */
class DaYinCong1daoZuiDaDeNweiShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] printNumbers(int n) {
      int m = (int) Math.pow(10, n);
      int[] res = new int[m - 1];
      for (int i = 0; i < m - 1; i++) {
        res[i] = i + 1;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
