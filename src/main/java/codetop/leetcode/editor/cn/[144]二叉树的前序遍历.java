
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 624 👎 0

package codetop.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author phuijiao
 * @date 2021-08-12 17:06:02
 */
 
class BinaryTreePreorderTraversal {
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
    List<Integer> res;
    public List<Integer> preorderTraversal1(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

      private void dfs(TreeNode root) {
          if (root == null) {
              return;
          }
          res.add(root.val);
          dfs(root.left);
          dfs(root.right);
      }


      public List<Integer> preorderTraversal(TreeNode root) {
          ArrayList<Integer> res = new ArrayList<>();
          if (root == null) {
              return res;
          }
          LinkedList<TreeNode> stack = new LinkedList<>();
          stack.add(root);
          while (!stack.isEmpty()) {
              TreeNode node = stack.pollLast();
              res.add(node.val);
              if (node.right != null) {
                  stack.add(node.right);
              }
              if (node.left != null) {
                  stack.add(node.left);
              }
          }
          return res;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
