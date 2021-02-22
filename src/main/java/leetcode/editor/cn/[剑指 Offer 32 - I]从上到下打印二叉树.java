// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//
//
// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回：
//
// [3,9,20,15,7]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 55 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phuijiao
 * @date 2021-01-08 10:33:49
 */
class CongShangDaoXiaDaYinErChaShuLcof {
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
    public int[] levelOrder(TreeNode root) {
      if (root == null) {
        return new int[0];
      }
      List<Integer> list = new ArrayList<>();
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.remove();
        list.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      int[] res = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
