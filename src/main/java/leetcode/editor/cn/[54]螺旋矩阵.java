//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 730 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-03-21 14:56:57
 */

class SpiralMatrix{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      int total = row * col;
      ArrayList<Integer> res = new ArrayList<>(total);
      int[][] dire = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      boolean[][] flag = new boolean[row][col];
      int ind = 0, i = 0, j = 0;
      for (int k = 0; k < total; k++) {
        res.add(matrix[i][j]);
        flag[i][j] = true;
        i += dire[ind][0];
        j += dire[ind][1];
        if (i < 0 || i >= row || j < 0 || j >= col || flag[i][j]) {
          i -= dire[ind][0];
          j -= dire[ind][1];
          ind = (ind + 1) % 4;
          i += dire[ind][0];
          j += dire[ind][1];
        }
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

