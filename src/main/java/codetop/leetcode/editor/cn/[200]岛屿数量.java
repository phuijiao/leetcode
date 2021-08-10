
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1272 👎 0

package codetop.leetcode.editor.cn;
 /**
  * @author  phuijiao
  * @date 2021-08-09 20:59:16
  */

class NumberOfIslands {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      int res = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if ('1' == grid[i][j]) {
            res++;
            mothed(grid, i, j);
          }
        }
      }
      return res;
    }

    private void mothed(char[][] grid, int i, int j) {
      int row = grid.length;
      int col = grid[0].length;
      if (i < 0 || i >= row || j < 0 || j >= col || '0' == grid[i][j]) {
        return;
      }
      grid[i][j] = '0';
      mothed(grid, i + 1, j);
      mothed(grid, i, j + 1);
      mothed(grid, i - 1, j);
      mothed(grid, i, j - 1);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}