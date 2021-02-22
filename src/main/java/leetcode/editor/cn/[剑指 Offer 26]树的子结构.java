// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
// 给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
// 给定的树 B：
//
// 4
// /
// 1
// 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
// 输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
// 输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树
// 👍 166 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author phuijiao
 * @date 2021-01-07 19:08:10
 */
class ShuDeZiJieGouLcof {
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
    // 广度遍历树A，时间空间消耗大
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
      if (A == null || B == null) {
        return false;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(A);
      while (!queue.isEmpty()) {
        TreeNode root = queue.remove();
        if (match(root, B)) {
          return true;
        }
        if (root.left != null) {
          queue.add(root.left);
        }
        if (root.right != null) {
          queue.add(root.right);
        }
      }
      return false;
    }

    private boolean match(TreeNode a, TreeNode b) {
      if (b == null) {
        return true;
      } else if (a == null) {
        return false;
      } else if (a.val == b.val) {
        return match(a.left, b.left) && match(a.right, b.right);
      } else {
        return false;
      }
    }

    // 递归 简洁高效
    public boolean isSubStructure(TreeNode A, TreeNode B) {
      if (A == null || B == null) {
        return false;
      }
      return match(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)
}
