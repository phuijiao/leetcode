// 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
// 到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
// 示例 1:
//
// 输入:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// 输出: 12
// 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//
// 提示：
//
//
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200
//
// Related Topics 动态规划
// 👍 85 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-19 11:13:12
 */
class LiWuDeZuiDaJieZhiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int row;
    int col;

    public int maxValue(int[][] grid) {
      row = grid.length;
      col = grid[0].length;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (i == 0 && j == 0) {
            continue;
          } else if (i == 0) {
            grid[0][j] += grid[0][j - 1];
          } else if (j == 0) {
            grid[i][0] += grid[i - 1][0];
          } else {
            grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
          }
        }
      }
      return grid[row - 1][col - 1];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
