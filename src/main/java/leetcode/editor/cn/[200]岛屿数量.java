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
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1045 👎 0

package leetcode.editor.cn;
 /**
 * @author  phuijiao
 * @date 2021-03-21 15:17:58
 */

class NumberOfIslands{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[][] grid;
    int row, col;
    public int numIslands(char[][] grid) {
      row = grid.length;
      col = grid[0].length;
      this.grid = grid;
      int count = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (findGrid(i, j)) {
            count++;
          }
        }
      }
      return count;
    }

    private boolean findGrid(int i, int j) {
      if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
        return false;
      }
      grid[i][j] = '0';
      findGrid(i + 1, j);
      findGrid(i, j + 1);
      findGrid(i - 1, j);
      findGrid(i, j - 1);
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}

