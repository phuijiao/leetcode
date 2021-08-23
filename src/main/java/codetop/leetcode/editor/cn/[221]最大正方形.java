
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 843 👎 0

package codetop.leetcode.editor.cn;

/**
 * @author phuijiao
 * @date 2021-08-20 10:23:21
 */

class MaximalSquare {
  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  private static
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 暴力法
    public int maximalSquare1(char[][] matrix) {
      int max = 0;
      int row = matrix.length;
      int col = matrix[0].length;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          int t = square(matrix, i, j);
          max = Math.max(max, t);
        }
      }
      return max;
    }

    private int square(char[][] matrix, int i, int j) {
      int row = matrix.length;
      int col = matrix[0].length;
      int l = 1;
      while ((i + l) <= row && (j + l) <= col) {
        for (int r = 0; r < l; r++) {
          for (int c = 0; c < l; c++) {
            if (matrix[i + r][j + c] == '0') {
              return (l - 1) * (l - 1);
            }
          }
        }
        l++;
      }
      return (l - 1) * (l - 1);
    }


    //动态规划
    public int maximalSquare(char[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      int max = 0;
      int[][] dp = new int[row][col];

      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (matrix[i][j] == '1') {
            if (i == 0 || j == 0) {
              dp[i][j] = 1;
            } else {
              dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
            max = Math.max(max, dp[i][j]);
          }
        }
      }
      return max * max;
    }
  }


//leetcode submit region end(Prohibit modification and deletion)

}