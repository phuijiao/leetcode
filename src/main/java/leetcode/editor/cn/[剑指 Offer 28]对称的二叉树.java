// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
// 3 4 4 3
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 👍 118 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 20:17:01
 */
class DuiChengDeErChaShuLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      return match(root.left, root.right);
    }

    private boolean match(TreeNode a, TreeNode b) {
      if (a == null && b == null) {
        return true;
      } else if (a == null || b == null || a.val != b.val) {
        return false;
      } else {
        return match(a.left, b.right) && match(a.right, b.left);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
