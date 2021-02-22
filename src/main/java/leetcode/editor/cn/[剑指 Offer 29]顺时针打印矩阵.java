// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 171 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-27 19:24:21
 */
class ShunShiZhenDaYinJuZhenLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] spiralOrder1(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
      }
      int rows = matrix.length, columns = matrix[0].length;
      boolean[][] visited = new boolean[rows][columns];
      int total = rows * columns;
      int[] order = new int[total];
      int row = 0, column = -1;
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int directionIndex = 0;
      int i = 0;
      while (i < total) {
        row += directions[directionIndex][0];
        column += directions[directionIndex][1];
        if (row < 0 || row >= rows || column < 0 || column >= columns || visited[row][column]) {
          row -= directions[directionIndex][0];
          column -= directions[directionIndex][1];
          directionIndex = (directionIndex + 1) % 4;
          continue;
        }
        order[i] = matrix[row][column];
        visited[row][column] = true;
        i++;
      }
      return order;
    }

    public int[] spiralOrder(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
      }
      int rows = matrix.length, columns = matrix[0].length;
      boolean[][] visited = new boolean[rows][columns];
      int total = rows * columns;
      int[] order = new int[total];
      int row = 0, column = 0;
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int directionIndex = 0;
      for (int i = 0; i < total; i++) {
        order[i] = matrix[row][column];
        visited[row][column] = true;
        int nextRow = row + directions[directionIndex][0],
            nextColumn = column + directions[directionIndex][1];
        if (nextRow < 0
            || nextRow >= rows
            || nextColumn < 0
            || nextColumn >= columns
            || visited[nextRow][nextColumn]) {
          directionIndex = (directionIndex + 1) % 4;
        }
        row += directions[directionIndex][0];
        column += directions[directionIndex][1];
      }
      return order;
    }

    public int[] spiralOrder3(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
      }
      int rows = matrix.length, columns = matrix[0].length;
      int total = rows * columns;
      int[] order = new int[total];
      int row = 0, col = -1;
      int index = 0;
      int l = 0, r = columns - 1, u = 0, d = rows - 1;
      for (int i = 0; i < total; i++) {
        switch (index) {
          case 0:
            {
              col++;
              if (col == r) {
                index = (index + 1) % 4;
                u++;
              }
            }
            break;
          case 1:
            {
              row++;
              if (row == d) {
                index = (index + 1) % 4;
                r--;
              }
            }
            break;
          case 2:
            {
              col--;
              if (col == l) {
                index = (index + 1) % 4;
                d--;
              }
            }
            break;
          case 3:
            {
              row--;
              if (row == u) {
                index = (index + 1) % 4;
                l++;
              }
            }
            break;
        }
        order[i] = matrix[row][col];
      }
      return order;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
