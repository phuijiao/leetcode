//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1051 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
* @author phuijiao
* @date 2021-05-10 08:49:17
*/

class ValidateBinarySearchTree {
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
    //递归法
    public boolean isValidBST1(TreeNode root) {
      return isValidBST(root, Long.MIN_VALUE , Long.MAX_VALUE );
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
      if (root == null) {
        return true;
      }
      if (root.val <= min || root.val >= max) {
        return false;
      }
      return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    //中序遍历
    public boolean isValidBST(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      long inorder = Long.MIN_VALUE;
      while (!stack.isEmpty() || root != null) {
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        if (root.val <= inorder) {
          return false;
        }
        inorder = root.val;
        root = root.right;
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}