// 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
// 一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
// [["a","b","c","e"],
// ["s","f","c","s"],
// ["a","d","e","e"]]
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//
//
// 示例 1：
//
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
// CCED"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 深度优先搜索
// 👍 213 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-26 16:08:00
 */
class JuZhenZhongDeLuJingLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    char[][] martix;
    String str;
    int row, col, len;

    public boolean exist(char[][] board, String word) {
      martix = board;
      str = word;
      row = board.length;
      col = board[0].length;
      len = word.length();
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (exist(i, j, 0)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean exist(int x, int y, int index) {
      // 已匹配完字符串
      if (len == index) {
        return true;
      }
      // 越界
      if (x < 0 || x >= row || y < 0 || y >= col) {
        return false;
      }

      if (martix[x][y] == str.charAt(index)) {
        // 数组中此位置已使用过，用0占位，避免重复使用
        martix[x][y] = 0;
        boolean b =
            exist(x - 1, y, index + 1)
                || exist(x + 1, y, index + 1)
                || exist(x, y - 1, index + 1)
                || exist(x, y + 1, index + 1);
        // 使用后需要还原
        martix[x][y] = str.charAt(index);
        return b;
      } else {
        return false;
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
