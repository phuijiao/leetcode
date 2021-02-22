// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
// 输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
// 输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 151 👎 0

package leetcode.editor.cn; // 如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
/**
 * @author phuijiao
 * @date 2020-12-12 19:45:03
 */
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.verifyPostorder(new int[] {1, 2, 3, 4, 5});
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean verifyPostorder(int[] postorder) {
      if (postorder.length <= 2) {
        return true;
      }
      return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
      if (end - start < 2) {
        return true;
      }
      int left = start;
      for (int i = start; i < end; i++) {
        if (postorder[i] < postorder[end]) {
          left = i;
        } else {
          break;
        }
      }
      for (int i = left + 1; i < end; i++) {
        if (postorder[i] <= postorder[end]) {
          return false;
        }
      }

      return verifyPostorder(postorder, start, left)
          && verifyPostorder(postorder, left + 1, end - 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
