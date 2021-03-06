// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
// 1 3 6 9
// 镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
// 9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树
// 👍 89 👎 0

package leetcode.editor.cn;
/**
 * @author phuijiao
 * @date 2021-01-07 19:40:04
 */
class ErChaShuDeJingXiangLcof {
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
    public TreeNode mirrorTree(TreeNode root) {
      if (root == null || (root.left == null && root.right == null)) {
        return root;
      }
      TreeNode tmp = root.left;
      root.left = root.right;
      root.right = tmp;
      mirrorTree(root.left);
      mirrorTree(root.right);

      return root;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
