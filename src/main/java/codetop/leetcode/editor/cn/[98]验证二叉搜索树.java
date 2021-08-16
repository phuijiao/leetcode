
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
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1169 👎 0

package codetop.leetcode.editor.cn;
/**
 * @Author phuijiao
 * @date 2021-08-16 16:18:44
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
    long last;
    public boolean isValidBST(TreeNode root) {
        last = Long.MIN_VALUE;
        return dfs(root);
    }

      private boolean dfs(TreeNode root) {
          if (root == null) {
              return true;
          }
          if (!dfs(root.left)) {
              return false;
          }
          if (root.val <= last) {
              return false;
          }
          last = root.val;

          return dfs(root.right);
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
