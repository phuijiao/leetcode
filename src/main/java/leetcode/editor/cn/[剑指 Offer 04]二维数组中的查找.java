
// 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
// ]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 双指针
// 👍 188 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 11:06:27
 */
class ErWeiShuZuZhongDeChaZhaoLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 由二位数组规律可知，从右上角或左下角开始查询
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
      if (matrix == null) {
        return false;
      }
      int row = matrix.length;
      if (row == 0) {
        return false;
      }
      int col = matrix[0].length;
      int x = 0, y = col - 1;
      while (x < row && y >= 0) {
        if (matrix[x][y] == target) {
          return true;
        } else if (matrix[x][y] > target) {
          y--;
        } else {
          x++;
        }
      }
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
