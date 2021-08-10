
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 960 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
  * @author  phuijiao
  * @date 2021-08-08 18:44:43
  */

class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new Solution();
        
  }


//  Definition for a binary tree node.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
        return res;
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = queue.size() - 1; i >= 0 ; i--) {
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
//leetcode submit region end(Prohibit modification and deletion)

}