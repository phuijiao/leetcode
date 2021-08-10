
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
// Related Topics 数组 矩阵 模拟 
// 👍 842 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
  * @author  phuijiao
  * @date 2021-08-08 23:44:43
  */

class SpiralMatrix {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }
   
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int index = 0;
      int count = row * col;
      boolean[][] flag = new boolean[row][col];
      ArrayList<Integer> list = new ArrayList<>(count);
      int i = 0, j = 0;
      for (int k = 0; k < count; k++) {
        list.add(matrix[i][j]);
        flag[i][j] = true;
        i += direction[index][0];
        j += direction[index][1];
        if (i < 0 || i >= row || j < 0 || j >= col || flag[i][j]) {
          i -= direction[index][0];
          j -= direction[index][1];
          index = (index + 1) % 4;
          i += direction[index][0];
          j += direction[index][1];
        }
      }
      return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}