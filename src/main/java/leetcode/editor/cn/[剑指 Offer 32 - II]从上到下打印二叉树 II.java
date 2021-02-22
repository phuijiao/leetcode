// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
// versal/
// Related Topics 树 广度优先搜索
// 👍 74 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phuijiao
 * @date 2021-01-08 10:53:50
 */
class CongShangDaoXiaDaYinErChaShuIiLcof {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }
      ArrayList<List<Integer>> res = new ArrayList<>();
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          list.add(node.val);
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        res.add(list);
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
