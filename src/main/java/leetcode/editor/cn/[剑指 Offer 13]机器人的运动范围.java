// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
// 格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
// 它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
// 输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
// 输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// 👍 193 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 16:50:16
 */
class JiQiRenDeYunDongFanWeiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int count = solution.movingCount(38, 15, 9);
    System.out.println(count);
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int res = 0;
    int m, n, k;
    boolean[][] flag;

    public int movingCount(int m, int n, int k) {
      this.m = m;
      this.n = n;
      this.k = k;
      flag = new boolean[m][n];
      recur(0, 0);

      return res;
    }

    private void recur(int x, int y) {
      if (x < 0 || x >= m || y < 0 || y >= n || flag[x][y]) {
        return;
      }
      int row = 0, col = 0, t = x;
      // 计算数位之和
      while (t != 0) {
        row += t % 10;
        t /= 10;
      }
      t = y;
      while (t != 0) {
        col += t % 10;
        t /= 10;
      }
      if (row + col <= k) {
        flag[x][y] = true;
        res++;
        recur(x + 1, y);
        recur(x, y + 1);
        // 此处去掉左和上依然正确，看来数据排列中间隔断后不能再次走通
        //        recur(x - 1, y);
        //        recur(x, y - 1);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
