//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 193 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;

/**
* @author phuijiao
* @date 2021-05-20 19:20:50
*/

class DiagonalTraverse {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    solution.findDiagonalOrder(ints);
  }
  
  private static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder1(int[][] mat) {
      int row = mat.length;
      int col = mat[0].length;
      int[] res = new int[row * col];
      int[][] direction = {{-1, 1}, {1, -1}};
      int ind = 0;
      int i = 1, j = -1;
      int cnt = 0;
      while (cnt < row * col) {
        i += direction[ind][0];
        j += direction[ind][1];
        if (i < 0) {
          if (j < col) {
            j += 1;
          } else {
            i += 1;
          }
          ind = (ind + 1) % 2;
        } else if (i >= row) {
          j += 1;
          ind = (ind + 1) % 2;
        } else if (j < 0) {
          if (i < row) {
            i += 1;
          } else {
            j += 1;
          }
          ind = (ind + 1) % 2;
        } else if (j >= col) {
          i += 1;
          ind = (ind + 1) % 2;
        } else {
          res[cnt++] = mat[i][j];
        }
      }
      return res;
    }


    public int[] findDiagonalOrder(int[][] mat) {
      if (mat == null || mat.length == 0) {
        return new int[0];
      }
      int row = mat.length;
      int col = mat[0].length;
      int[] res = new int[row * col];
      int k = 0;
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < row + col - 1; i++) {
        list.clear();
        int r = i < col ? 0 : i - col + 1;
        int c = i < col ? i : col -1;
        while (r < row && c >= 0) {
          list.add(mat[r][c]);
          r++;
          c--;
        }
        if (i % 2 == 0) {
          Collections.reverse(list);
        }
        for (Integer num : list) {
          res[k++] = num;
        }
      }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}