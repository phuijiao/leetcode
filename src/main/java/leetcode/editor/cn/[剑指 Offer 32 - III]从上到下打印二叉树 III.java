// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
//  [20,9],
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
// Related Topics 树 广度优先搜索
// 👍 65 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phuijiao
 * @date 2021-01-08 11:05:16
 */
class CongShangDaoXiaDaYinErChaShuIiiLcof {
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
        LinkedList<Integer> list = new LinkedList<>();
        for (int size = queue.size(); size > 0; size--) {
          TreeNode node = queue.remove();
          if ((res.size() & 1) == 0) {
            list.addLast(node.val);
          } else {
            list.addFirst(node.val);
          }
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
