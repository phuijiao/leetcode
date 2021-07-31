//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 421 👎 0

package leetcode.editor.cn;
/**
* @author phuijiao
* @date 2021-05-20 13:47:00
*/

class SpiralMatrixIi {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
      int[][] res = new int[n][n];
      int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int ind = 0;
      int i = 0, j = -1;
      for (int k = 0; k < n * n; k++) {
        i += direction[ind][0];
        j += direction[ind][1];
        if (i < 0 || i >= n || j < 0 || j >= n || res[i][j] != 0) {
          i -= direction[ind][0];
          j -= direction[ind][1];
          ind = (ind + 1) % 4;
          i += direction[ind][0];
          j += direction[ind][1];
        }
        res[i][j] = k + 1;
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}