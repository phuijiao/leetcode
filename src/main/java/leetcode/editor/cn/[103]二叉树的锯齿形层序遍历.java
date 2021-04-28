//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 412 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  phuijiao
 * @date 2021-03-20 10:25:59
 */

class BinaryTreeZigzagLevelOrderTraversal{
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }


  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  private static
  //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
        return res;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = queue.size(); i > 0; i--) {
          TreeNode node = queue.remove();
          if ((res.size() & 1) == 0) {
            list.add(node.val);
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
//leetcode submit region end(Prohibit modification and deletion)

}

